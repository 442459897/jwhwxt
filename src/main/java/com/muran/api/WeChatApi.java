package com.muran.api;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import weixin.popular.api.SnsAPI;
import weixin.popular.api.UserAPI;
import weixin.popular.bean.sns.SnsToken;
import weixin.popular.bean.user.User;

import com.muran.application.GlobalConfig;

@Path("/oauth2")
@Component
public class WeChatApi extends AbstractApi {

	public static SnsToken snsToken;
	public static long snsTokenExpiresTime;
	private final static Logger log = Logger.getLogger(GlobalConfig.class);

	@GET
	@Produces({ "application/json" })
	public Response WeChatOAuth2(@QueryParam("uri") String uri)
			throws URISyntaxException {
		// 如果没有获取到路由 默认为无路由
		if (uri == null) {
			uri = "";
		}

		String code = request.getParameter("code");
		if (code != null && code != "") {
			log.info("微信回调，code：" + code);
			// 微信回调
			// 根据code获取token 将token存储在缓存中
			snsToken = SnsAPI.oauth2AccessToken(GlobalConfig.KEY_APPID,
					GlobalConfig.KEY_APP_SECRET, code);
			snsTokenExpiresTime = System.currentTimeMillis()
					+ (snsToken.getExpires_in() - 120) * 1000;// token创建时间
																// 提前120秒过期
																// 精确到毫秒
			log.info("微信回调，获取token：" + snsToken.getAccess_token() + ",openid:"
					+ snsToken.getOpenid());
			// 获取用户信息
			// User user = SnsAPI.userinfo(snsToken.getAccess_token(),
			// snsToken.getOpenid(), "zh_CN"); 这种获取方法必须使用 snsapi_userinfo
			User user = UserAPI.userInfo(snsToken.getAccess_token(),
					snsToken.getOpenid());
			if (user.isSuccess()) {
				// 存储到session
				request.getSession().setAttribute("user", user);
			}

			log.info("微信回调，获取userinfo  nickname：" + user.getNickname());

		}
		// token 是否存在
		if (snsToken == null) {
			log.info("第一次调用，token为null，开始请求网页授权……");
			// 不存在重新授权
			String oauthUrl = OAuthReposition(uri, "1", "snsapi_base");
			return Response.status(Status.FOUND).location(new URI(oauthUrl))
					.build();
		}
		// 判断token是否过期，过期的话使用refreshtoken刷新
		if (System.currentTimeMillis() > snsTokenExpiresTime) {
			log.info("token过期，开始请求刷新token……");
			snsToken = SnsAPI.oauth2RefreshToken(GlobalConfig.KEY_APPID,
					snsToken.getRefresh_token());
			snsTokenExpiresTime = System.currentTimeMillis()
					+ (snsToken.getExpires_in() - 120) * 1000;// token创建时间
																// 提前120秒过期
																// 精确到毫秒
			log.info("刷新token结果，errcode：" + snsToken.getErrcode());
			if (snsToken.getErrcode().equals("42002")) {
				log.info("刷新token失败，重新授权开始……");
				// freshToken超时 即过期 重新授权
				String oauthUrl = OAuthReposition(uri, "1", "snsapi_base");
				return Response.status(Status.FOUND)
						.location(new URI(oauthUrl)).build();
			}
		}
		// 检查用户信息是否存在
		if (request.getSession().getAttribute("user") == null) {
			log.info("用户信息不存在，重新获取用户信息……");
			// 获取用户信息
			// User user = SnsAPI.userinfo(snsToken.getAccess_token(),
			// snsToken.getOpenid(), "zh_CN");
			User user = UserAPI.userInfo(snsToken.getAccess_token(),
					snsToken.getOpenid());
			log.info("重新获取用户信息,结果：" + user.getErrcode());
			if (user.isSuccess()) {
				// 存储到session
				request.getSession().setAttribute("user", user);
			}
		}
		// 存在则直接跳转到响应的路由
		return Response.status(Status.FOUND)
				.location(new URI(GlobalConfig.KEY_WEB_URI + uri)).build();

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
}
