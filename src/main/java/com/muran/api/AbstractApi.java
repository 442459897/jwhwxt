package com.muran.api;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.muran.application.GlobalConfig;
import com.muran.application.cache.ServerCache;
import com.muran.util.UserTokenUtil;
import com.muran.util.net.NetworkUtil;

/**
 * Created by Steven on 4/29/16.
 */
public abstract class AbstractApi {

	private final static Logger log = Logger.getLogger(AbstractApi.class);
	private final static String HEADER_KEY_SESSION_ID = "session-id";
	private final static String HEADER_KEY_CLIENT_IP = "client-ip";
	private final static String HEADER_KEY_CLIENT_KEY = "client-key";
	private final static String HEADER_KEY_CLIENT_NET_ENV = "client-net-env";
	private final static String HEADER_KEY_CLIENT_VERSION = "version";
	public final static String HEADER_KEY_OPEN_ID = "open-id";

	@javax.ws.rs.core.Context
	HttpServletRequest request;

	public String getUsername() {
		return UserTokenUtil.getUserName(getUserToken());
	}

	// 获取用户token UserToken
	public String getUserToken() {
		// to do
		return request.getHeader("UserToken");
	}
	
	public String getUserSys() {
		String str = request.getHeader("UserSys");
		if (str == null)
			str = "";
		return str;
	}

	// 获取请求时间戳 time
	public Date getRequestTime() {
		// to do
		String timeStr = getTimeInMill();
		if (timeStr == null)
			return null;
		try {
			long timeLong = Long.parseLong(timeStr);
			Date time = new Date();
			time.setTime(timeLong);
			return time;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// 获取请求时间戳字符串 Time
	public String getTimeInMill() {
		return request.getHeader("Time");
	}

	// 获取SignCode
	public String getSignCode() {
		return request.getHeader("SignCode");
	}

	public Context context() {
		if (GlobalConfig.getInstance().getConfig(GlobalConfig.KEY_DEBUG)
				.equals("true")
				&& request.getHeader(HEADER_KEY_SESSION_ID) == null) {// 如果本地测试,而且是使用swagger
																		// ui 测试
			Context context = new Context();
			Session session = new Session("debug_" + new Date().getTime());
			session.setCreateTime(new Date());
			// 根据用户类型不同调用不同的验证
			String userType = request.getHeader("userType");
			
			context.setUsername(getUsername());
			context.setUserToken(getUserToken());
			
			if (userType == "user") {
				session.setUserInfo(null);
			} else if (userType == "admin") {
				session.setUserInfo(null);
			} else {
				session.setUserInfo(null);
			}

			// IUserService userService =
			// SpringContextHolder.getBean(IUserService.class);
			// UserInfo userInfo = userService.getUserInfo((long)
			// 1);//获取幕然科技用户作为swagger测试用户.
			// session.setUserInfo(userInfo);
			ClientInfo clientInfo = new ClientInfo();
			clientInfo.setIp(NetworkUtil.getIpAddress(request));
			clientInfo.setKey("swagger.ui");
			clientInfo.setNetworkEnv("wifi");
			clientInfo.setVersion("1.4.0");
			session.setClientInfo(clientInfo);
			context.setClientInfo(clientInfo);
			context.setSession(session);
			// // TODO: 5/5/16 加入登陆用户信息
			return context;
		}
		// 根据头部sessionId获取session
		// 构建clientInfo
		Context context = new Context();
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setIp(request.getHeader(HEADER_KEY_CLIENT_IP));
		if (clientInfo.getIp() == null)
			clientInfo.setIp(NetworkUtil.getIpAddress(request));
		clientInfo.setKey(request.getHeader(HEADER_KEY_CLIENT_KEY));
		clientInfo.setNetworkEnv(HEADER_KEY_CLIENT_NET_ENV);
		clientInfo.setVersion(HEADER_KEY_CLIENT_VERSION);
		context.setClientInfo(clientInfo);

		String openId = request.getHeader(HEADER_KEY_OPEN_ID);
		if (openId != null) {
			context.put(HEADER_KEY_OPEN_ID, openId);
		}

		String sessionId = request.getHeader(HEADER_KEY_SESSION_ID);
		ServerCache cache = ServerCache.getCache();
		Session session = (Session) cache
				.get(HEADER_KEY_SESSION_ID + sessionId);
		if (session == null) {
			session = new Session(sessionId);
			// // 从数据中读出来用户信息.(由于一天内未使用,清楚了缓存数据).
			// UserInfo userInfo = null;
			// IUserService userService = SpringContextHolder
			// .getBean(IUserService.class);
			// if (openId != null)
			// userInfo = userService.getUserInfoByOpenId(openId);
			// if (userInfo == null)
			// userInfo = userService.getUserInfoBySessionId(sessionId);
			// session.setUserInfo(userInfo);
			// cache.put(HEADER_KEY_SESSION_ID + sessionId, session);
		}
		session.setClientInfo(clientInfo);
		context.setSession(session);
		return context;
	}
}
