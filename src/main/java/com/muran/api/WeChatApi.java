package com.muran.api;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.Cookie;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import weixin.popular.api.MediaAPI;
import weixin.popular.api.MenuAPI;
import weixin.popular.api.SnsAPI;
import weixin.popular.api.TicketAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.media.MediaGetResult;
import weixin.popular.bean.sns.SnsToken;
import weixin.popular.bean.ticket.Ticket;
import weixin.popular.bean.token.Token;
import weixin.popular.bean.user.User;
import weixin.popular.util.JsonUtil;

import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.ICommonService;
import com.muran.api.service.IWeChatUserService;
import com.muran.application.GlobalConfig;
import com.muran.dto.WxConfig;
import com.muran.dto.WxMenu;
import com.muran.model.WeChatUser;
import com.muran.util.FileUtil;
import com.muran.util.GenratorUtil;
import com.muran.util.UserTokenUtil;
import com.muran.util.GenratorUtil.SecurityCodeLevel;
import com.muran.util.SecuritySHA;
import com.muran.util.WxConfigUtil;
import com.muran.util.dataVerify.CommonVerify;

@Path("/oauth2")
@Component
public class WeChatApi extends AbstractApi {

	// public static SnsToken snsToken;// 网页授权token
	public static Token token;// 全局基础token
	public static long tokenExpiresTime;// 微信token过期时间
	//
	public static Ticket ticket;// jsapi_ticket
	public static long ticketExpiresTime;// jsapi_ticket过期时间

	private final static Logger log = Logger.getLogger(GlobalConfig.class);

	@Autowired
	IWeChatUserService wechatUserService;

	@Autowired
	ICommonService service;

	@GET
	@Produces({ "application/json" })
	public Response WeChatOAuth2(@QueryParam("uri") String uri,
			@QueryParam("type") String type) throws URISyntaxException,
			UnsupportedEncodingException {

		WeChatUser wechatUser = null;
		SnsToken snsToken = null;

		// 参数处理
		if (type == null) {
			return Response
					.ok()
					.location(
							new URI(GlobalConfig.KEY_ERROR_PAGE + "?"
									+ Code.BadRequestParams.getCode())).build();
		}

		// 如果没有获取到路由 默认为无路由
		if (uri == null) {
			uri = "";
		}

		log.info("param uri:" + uri);
		log.info("param type:" + type);

		String code = request.getParameter("code");
		if (code != null && code != "") {
			log.info("微信回调，code：" + code);
			// 微信回调
			// 根据code获取token 将token存储在缓存中
			snsToken = SnsAPI.oauth2AccessToken(GlobalConfig.KEY_APPID,
					GlobalConfig.KEY_APP_SECRET, code);
			// long snsTokenExpiresTime = System.currentTimeMillis()
			// + (snsToken.getExpires_in() - 200) * 1000;// token创建时间
			// // 提前200秒过期
			// // 精确到毫秒
			log.info("微信回调，获取token：" + snsToken.getAccess_token() + ",openid:"
					+ snsToken.getOpenid());

			// User user = SnsAPI.userinfo(snsToken.getAccess_token(),
			// snsToken.getOpenid(), "zh_CN"); 这种获取方法必须使用 snsapi_userinfo

			if (token == null || System.currentTimeMillis() > tokenExpiresTime) {
				// 获取基础token信息 与snstoken不同
				token = TokenAPI.token(GlobalConfig.KEY_APPID,
						GlobalConfig.KEY_APP_SECRET);

				if (token.isSuccess()) {
					// 过期时间
					tokenExpiresTime = System.currentTimeMillis()
							+ (token.getExpires_in() - 200) * 1000;// token创建时间
																	// 提前200秒过期
																	// 精确到毫秒
				}
			}
			// 获取用户信息
			User user = UserAPI.userInfo(token.getAccess_token(),
					snsToken.getOpenid());
			if (user.isSuccess()) {
				// 存储到session 数据库 如果存在会更新 不存在会创建
				// request.getSession().setAttribute("user", user);
				wechatUser = wechatUserService.updateOrCreateWeChatUser(user,
						snsToken);
			}
			log.info("微信回调，获取userinfo  nickname：" + user.getNickname());

		}

		// token 是否存在
		if (snsToken == null || token == null) {
			log.info("第一次调用，snstoken为null，开始请求网页授权……");
			// 不存在重新授权
			String oauthUrl = OAuthReposition(uri, "1", "snsapi_base", type);

			log.info("oauthUrl:" + oauthUrl);
			return Response.status(Status.FOUND).location(new URI(oauthUrl))
					.build();
		}
		// 判断token是否过期，过期的话使用refreshtoken刷新
		if (System.currentTimeMillis() > wechatUser.getExpireTime().getTime()) {
			log.info("snstoken过期，开始请求刷新token……");
			snsToken = SnsAPI.oauth2RefreshToken(GlobalConfig.KEY_APPID,
					snsToken.getRefresh_token());
			// snsTokenExpiresTime = System.currentTimeMillis()
			// + (snsToken.getExpires_in() - 120) * 1000;// token创建时间
			// // 提前120秒过期
			// // 精确到毫秒
			log.info("刷新token结果，errcode：" + snsToken.getErrcode());

			if (!snsToken.isSuccess()) {
				log.info("刷新token失败，重新授权开始……");
				// freshToken超时 即过期 重新授权
				String oauthUrl = OAuthReposition(uri, "1", "snsapi_base");
				return Response.status(Status.FOUND)
						.location(new URI(oauthUrl)).build();
			}
			if (token == null || System.currentTimeMillis() > tokenExpiresTime) {
				// 重新获取基础token信息 与snstoken不同
				token = TokenAPI.token(GlobalConfig.KEY_APPID,
						GlobalConfig.KEY_APP_SECRET);

				if (token.isSuccess()) {
					tokenExpiresTime = System.currentTimeMillis()
							+ (token.getExpires_in() - 200) * 1000;// token创建时间
																	// 提前200秒过期
																	// 精确到毫秒
				}
			}
			User user = UserAPI.userInfo(token.getAccess_token(),
					snsToken.getOpenid());
			if (user.isSuccess()) {
				// 存储到session 数据库 如果存在会更新 不存在会创建
				// request.getSession().setAttribute("user", user);
				wechatUser = wechatUserService.updateOrCreateWeChatUser(user,
						snsToken);
			}
			log.info("刷新token结果，获取userinfo  nickname：" + user.getNickname());

		}
		// 获取用户session信息
		// Cookie cookie = UserTokenUtil.getCookieByName(request, "sessionId");
		// if (wechatUser == null && cookie != null && cookie.getValue() != null
		// && cookie.getValue() != "") {
		// // 如果session存在 获取用户信息
		// wechatUser = wechatUserService.getUserExistAndNoExpire(cookie
		// .getValue());
		// }
		// 检查用户信息是否存在
		if (wechatUser == null) {
			// ||
			// !wechatUserService.IsUserExistOrExpire(wechatUser.getSessionId())

			// log.info("用户信息不存在，重新获取用户信息……");
			// // 获取用户信息
			// // User user = SnsAPI.userinfo(snsToken.getAccess_token(),
			// // snsToken.getOpenid(), "zh_CN");
			//
			// User user = UserAPI.userInfo(token.getAccess_token(),
			// snsToken.getOpenid());
			// log.info("重新获取用户信息,结果：" + user.getErrcode());
			// if (user.isSuccess()) {
			// // 存储到session 数据库
			// // request.getSession().setAttribute("user", user);
			// wechatUser = wechatUserService.updateOrCreateWeChatUser(user);
			// }
			log.info("用户信息不存在，重新授权开始……");
			// freshToken超时 即过期 重新授权
			String oauthUrl = OAuthReposition(uri, "1", "snsapi_base");
			return Response.status(Status.FOUND).location(new URI(oauthUrl))
					.build();
		}

		log.info("sessionid：" + wechatUser.getSessionId());
		NewCookie newCookie = new NewCookie("sessionid",
				wechatUser.getSessionId());
		// 存在则直接跳转到响应的路由或者地址
		log.info("uri:" + uri);
		log.info("type:" + type);
		if (type.equals("router")) {

			String urlString = GlobalConfig.KEY_WEB_URI + uri + "/#!" + uri
					+ "?s=" + wechatUser.getSessionId();
			return Response.status(Status.FOUND).cookie(newCookie)
					.header("sessionid", wechatUser.getSessionId())
					.location(new URI(urlString)).build();

		} else if (type.equals("url")) {
			uri = java.net.URLDecoder.decode(uri, "utf-8");
			log.info("uri:" + uri);
			return Response.status(Status.FOUND).cookie(newCookie)
					.header("sessionid", wechatUser.getSessionId())
					.location(new URI(uri)).build();
		} else {
			return Response
					.ok()
					.location(
							new URI(GlobalConfig.KEY_ERROR_PAGE + "?"
									+ Code.BadRequestParams.getCode())).build();
		}

	}

	public static String OAuthReposition(String uri, String state, String scope) {
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalConfig.KEY_AUTHURL);
		sb.append("?appid=");
		sb.append(GlobalConfig.KEY_APPID);
		sb.append("&redirect_uri=");
		// 获取服务器域名
		sb.append(GlobalConfig.KEY_REDIRECT_URI);
		sb.append("?uri=" + uri);
		// 如要获取用户详细信息snsapi_base须改为snsapi_userinfo
		sb.append("&response_type=code&scope=" + scope + "&state=");
		sb.append(state);
		sb.append("#wechat_redirect");
		return sb.toString();
	}

	public static String OAuthReposition(String uri, String state,
			String scope, String type) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalConfig.KEY_AUTHURL);
		sb.append("?appid=");
		sb.append(GlobalConfig.KEY_APPID);
		sb.append("&redirect_uri=");
		// 获取服务器域名
		// log.info("type  ***:" + type);
		// if (type.equals("url")) {
		// String u = java.net.URLEncoder.encode(uri, "utf-8");
		// sb.append(GlobalConfig.KEY_REDIRECT_URI + "?uri=" + u + "&type="
		// + type);
		// log.info(GlobalConfig.KEY_REDIRECT_URI + "?uri=" + u + "&type="
		// + type);
		String u = java.net.URLEncoder.encode(GlobalConfig.KEY_REDIRECT_URI
				+ "?uri=" + uri + "&type=" + type, "utf-8");
		sb.append(u);
		log.info("redirect_uri" + u);
		// } else if (type.equals("router")) {
		// sb.append(GlobalConfig.KEY_REDIRECT_URI);
		// sb.append("?uri=" + uri + "&type=" + type);
		// }

		// 如要获取用户详细信息snsapi_base须改为snsapi_userinfo
		sb.append("&response_type=code&scope=" + scope + "&state=");
		sb.append(state);
		sb.append("#wechat_redirect");
		return sb.toString();
	}

	@Path("/wxconfig")
	@GET
	@Produces({ "application/json" })
	public Response WeChatOAuth2JsApi(@QueryParam("url") String url)
			throws URISyntaxException {
		log.info("url:" + url);
		// if (!CommonVerify.verifyUrl(url)) {
		// // 若地址不正确 则提示参数错误
		// log.info("url:地址不正确");
		// return Response
		// .ok()
		// .location(
		// new URI(GlobalConfig.KEY_ERROR_PAGE + "?"
		// + Code.BadRequestParams.getCode())).build();
		// }

		// 检测ticket是否存在或过期
		if (ticket == null || System.currentTimeMillis() > ticketExpiresTime) {
			if (token == null || System.currentTimeMillis() > tokenExpiresTime) {
				token = TokenAPI.token(GlobalConfig.KEY_APPID,
						GlobalConfig.KEY_APP_SECRET);

				if (token.isSuccess()) {
					tokenExpiresTime = System.currentTimeMillis()
							+ (token.getExpires_in() - 200) * 1000;// token创建时间
																	// 提前200秒过期
																	// 精确到毫秒
				} else {
					throw new ServerException(Code.BadRequestParams,
							"token获取失败！");
				}
			}

			ticket = TicketAPI.ticketGetticket(token.getAccess_token());
			if (!ticket.isSuccess()) {
				log.info("ticket获取失败:" + ticket.getErrcode() + ","
						+ ticket.getErrmsg());
				ticket = null;
				throw new ServerException(Code.BadRequestParams, "ticket获取失败！");
			}
		}

		// 获取ticket

		log.info("ticket:获取成功");
		// 获取成功
		// ticketExpiresTime = System.currentTimeMillis()
		// + (ticket.getExpires_in() - 120) * 1000;// ticket创建时间
		// // 提前120秒过期
		// // 精确到毫秒

		// 若ticket存在并且有效 生成JS-SDK权限验证的签名
		String noncestr = GenratorUtil.getSecurityCode(16,
				SecurityCodeLevel.Hard, true);
		int timestamp = Integer.parseInt(String.valueOf(System
				.currentTimeMillis() / 1000));
		// 组建签名体
		StringBuilder sb = new StringBuilder();
		sb.append("noncestr=" + noncestr + "&");
		sb.append("jsapi_ticket=" + ticket.getTicket() + "&");
		sb.append("timestamp=" + String.valueOf(timestamp) + "&");
		String result="";
		try {
			result=java.net.URLDecoder.decode(url,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sb.append("url=" + result);
		log.info("url:"+result);
		log.info("sb:"+sb);
		// 进行sha1签名
		String signature = SecuritySHA.SHA1(sb.toString());

		log.info("signature:" + signature);
		// 组建返回实体
		WxConfig config = new WxConfig();
		config.setDebug(true);
		config.setAppId(GlobalConfig.KEY_APPID);
		config.setNoncestr(noncestr);
		config.setSignature(signature);
		config.setJsApiList(WxConfigUtil.jsApiList);
		config.setTimestamp(timestamp);
		log.info("config:" + JsonUtil.toJSONString(config));
		// 返回
		return Response.ok().entity(config).build();

	}

	@Path("/wxmedia")
	@POST
	@Produces({ "application/json" })
	public Response WeChatDownloadMedia(@FormParam("mediaId") String mediaId)
			throws URISyntaxException {
		// 获取用户信息
		// User user = (User) request.getSession().getAttribute("user");
		WeChatUser wechatUser = null;

		String sessionId = request.getHeader("SessionId");
		log.info("sessionid：" + sessionId);
		if (sessionId != null && sessionId != "") {
			// 如果session存在 获取用户信息
			wechatUser = wechatUserService.getUserExistAndNoExpire(sessionId);
			log.info("wechatUser：" + wechatUser == null);
		}
		if (wechatUser == null) {
			throw new ServerException(Code.UserNoExisted, "用户信息已过期或不存在！");
		}
		// 检测token
		if (token == null || System.currentTimeMillis() > tokenExpiresTime) {
			token = TokenAPI.token(GlobalConfig.KEY_APPID,
					GlobalConfig.KEY_APP_SECRET);

			if (token.isSuccess()) {
				tokenExpiresTime = System.currentTimeMillis()
						+ (token.getExpires_in() - 200) * 1000;// token创建时间
																// 提前200秒过期
																// 精确到毫秒
			} else {
				throw new ServerException(Code.BadRequestParams, "token获取失败！");
			}
		}
		// 获取临时素材
		MediaGetResult result = MediaAPI.mediaGet(token.getAccess_token(),
				mediaId, true);
		if (!result.isSuccess()) {
			throw new ServerException(Code.BadRequestParams, "临时素材获取失败！");
		}
		// 将文件下载到本地
		String basePath = request.getSession().getServletContext()
				.getRealPath("/");
		String path = basePath + "upload/wx/" + wechatUser.getOpenId();
		FileUtil.saveFile(result.getBytes(), path, result.getFilename());
		String url = GlobalConfig.KEY_WEB_BASE + "upload/wx/"
				+ wechatUser.getOpenId() + "/" + result.getFilename();
		return Response.ok().entity(url).build();
	}

	@Path("/menus")
	@POST
	@Produces({ "application/json" })
	public Response WeChatCreateMenu() throws URISyntaxException {

		// 获取用户信息
		// User user = (User) request.getSession().getAttribute("user");
//		WeChatUser wechatUser = null;
//
//		String sessionId = request.getHeader("SessionId");
//		log.info("sessionid：" + sessionId);
//		if (sessionId != null && sessionId != "") {
//			// 如果session存在 获取用户信息
//			wechatUser = wechatUserService.getUserExistAndNoExpire(sessionId);
//			log.info("wechatUser：" + wechatUser == null);
//		}
//		if (wechatUser == null) {
//			throw new ServerException(Code.UserNoExisted, "用户信息已过期或不存在！");
//		}
		if (token == null || System.currentTimeMillis() > tokenExpiresTime) {
			token = TokenAPI.token(GlobalConfig.KEY_APPID,
					GlobalConfig.KEY_APP_SECRET);

			if (token.isSuccess()) {
				tokenExpiresTime = System.currentTimeMillis()
						+ (token.getExpires_in() - 200) * 1000;// token创建时间
																// 提前200秒过期
																// 精确到毫秒
			} else {
				throw new ServerException(Code.BadRequestParams, "token获取失败！");
			}
		}
		

		WxMenu menu = service.getWxMenu();
		String menuJson = JsonUtil.toJSONString(menu);
		log.info("创建菜单的json串：" + menuJson);
		// 调用微信接口
		BaseResult result = MenuAPI.menuCreate(token.getAccess_token(), menuJson);
		log.info("isSuccess：" + result.isSuccess());
		if (!result.isSuccess()) {
			// 失败 返回失败信息
			return Response
					.ok()
					.location(
							new URI(GlobalConfig.KEY_ERROR_PAGE + "?"
									+ Code.CreateMenuFail.getCode())).build();
		}
		log.info("跳转地址：" + GlobalConfig.KEY_WEB_BASE
				+ "createMenu.jsp?result=success");
		return Response.ok().encoding("创建菜单成功！").build();
	}

	@Path("/users")
	@GET
	@Produces({ "application/json" })
	public Response WeChatIsSessionOk() {

		return Response.ok().build();
	}
}
