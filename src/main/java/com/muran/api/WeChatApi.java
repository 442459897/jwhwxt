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
		String code = request.getParameter("code");
		if (code != null && code != "") {
			log.debug("微信回调，code：" + code);
			// 微信回调
			// 根据code获取token 将token存储在缓存中
			snsToken = SnsAPI.oauth2AccessToken(
					GlobalConfig.KEY_APPID,
					GlobalConfig.KEY_APP_SECRET, code);
			snsTokenExpiresTime = System.currentTimeMillis()
					+ (snsToken.getExpires_in() - 120) * 1000;// token创建时间
																// 提前120秒过期
																// 精确到毫秒
			log.debug("微信回调，获取token：" + snsToken.getAccess_token() + ",openid:"
					+ snsToken.getOpenid());
			// 获取用户信息
			User user = SnsAPI.userinfo(snsToken.getAccess_token(),
					snsToken.getOpenid(), "zh_CN");
			// 存储到session
			request.getSession().setAttribute("user", user);

			log.debug("微信回调，获取userinfo  nickname：" + user.getNickname());

		}
		// token 是否存在
		if (snsToken == null) {
			log.debug("第一次调用，token为null，开始请求网页授权……");
			// 不存在重新授权
			String oauthUrl = OAuthReposition(uri, "1");
			return Response.status(Status.FOUND).location(new URI(oauthUrl))
					.build();
		}
		// 判断token是否过期，过期的话使用refreshtoken刷新
		if (System.currentTimeMillis() > snsTokenExpiresTime) {
			log.debug("token过期，开始请求刷新token……");
			snsToken = SnsAPI.oauth2RefreshToken(GlobalConfig.KEY_APPID,
					snsToken.getRefresh_token());
			snsTokenExpiresTime = System.currentTimeMillis()
					+ (snsToken.getExpires_in() - 120) * 1000;// token创建时间
																// 提前120秒过期
																// 精确到毫秒
			log.debug("刷新token结果，errcode：" + snsToken.getErrcode());
			if (snsToken.getErrcode().equals("42002")) {
				log.debug("刷新token失败，重新授权开始……");
				// freshToken超时 即过期 重新授权
				String oauthUrl = OAuthReposition(uri, "1");
				return Response.status(Status.FOUND)
						.location(new URI(oauthUrl)).build();
			}
		}
		// 检查用户信息是否存在
		if (request.getSession().getAttribute("user") == null) {
			log.debug("用户信息不存在，重新获取用户信息……");
			// 获取用户信息
			User user = SnsAPI.userinfo(snsToken.getAccess_token(),
					snsToken.getOpenid(), "zh_CN");
			log.debug("重新获取用户信息,结果：" + user.getErrcode());
			// 存储到session
			request.getSession().setAttribute("user", user);
		}
		// 存在则直接跳转到响应的路由
		return Response.status(Status.FOUND)
				.location(new URI(GlobalConfig.KEY_WEB_URI + uri)).build();

	}

	public static String OAuthReposition(String uri, String state) {
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalConfig.KEY_AUTHURL);
		sb.append("?appid=");
		sb.append(GlobalConfig.KEY_APPID);
		sb.append("&redirect_uri=");
		// 获取服务器域名
		sb.append(GlobalConfig.KEY_REDIRECT_URI);
		sb.append("?uri=" + uri);
		// 如要获取用户详细信息snsapi_base须改为snsapi_userinfo
		sb.append("&response_type=code&scope=snsapi_base&state=");
		sb.append(state);
		sb.append("#wechat_redirect");
		return sb.toString();
	}
}
