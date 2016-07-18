package com.muran.filter;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.GenericFilterBean;

import com.muran.aop.annotation.UserSecurityVerify;
import com.muran.api.service.IUserTokenService;

/**
 * 
 * @author Steven 2015年6月11日 检查 header里面是否存在userSys标识，是否合法。
 * 
 */
public class UserSysFilter extends GenericFilterBean {
	Logger log = Logger.getLogger(UserSysFilter.class);

	@Autowired
	IUserTokenService service;

	@Resource(name = "UserSecurityVerify")
	UserSecurityVerify securityHandler;

	/**
	 * 对外路由名单
	 */
	private List<String> externalUrls;

	public List<String> getExternalUrls() {
		return externalUrls;
	}

	public void setExternalUrls(List<String> externalUrls) {
		this.externalUrls = externalUrls;
	}

	// private FilterConfig config;
	private final PathMatcher pathMatcher = new AntPathMatcher();

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		// request.getParameter("");//必须加本句话，getBussnessData()才能正常获得post提交的业务数据.
		// 第一次调用方法，request从流中读取数据 改用装饰器模式解决该问题
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		// Enumeration<String> enumat =request.getHeaderNames();
		// while(enumat.hasMoreElements()){
		// log.info(enumat.nextElement());
		// }

		// 检验对外路由名单
		// log.info("对外路由检查开始……");
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		// HttpServletResponse httpResponse = (HttpServletResponse) response;
		// String currentURL = httpRequest.getServletPath();
		String currentURL = httpRequest.getPathInfo();
		 log.info("当前请求路由：" + currentURL);
//		 String externalUrlsStr =
//		 this.config.getInitParameter("externalUrls");
//		 externalUrlsList = strToArray(externalUrlsStr);
		 if (isExternalUrl(currentURL)) {
		 filterChain.doFilter(servletRequest, servletResponse);
		 return;
		 }

		String userSys = request.getHeader("UserSys");

		// EnumUserSystem eus = EnumUserSystem.getEnum(userSys);
		log.info("用户系统来源检查： " + userSys);
		// byte[] data =
		// InputStream2Bytes.inputStream2Bytes(request.getInputStream());
		// String requstDataString = new String(data);
		// log.info("requst inputstream is :"+requstDataString);
		// request.setAttribute("bussData", requstDataString);
		if (userSys != null
				&& (userSys.equals("wx") || userSys.equals("admin"))) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			response.setStatus(403);
			response.getOutputStream().write("未知系统来源".getBytes());
		}
	}

	private boolean isExternalUrl(String currentURL) {
		if (externalUrls == null) {
			return false;
		}
		for (String externalURL : externalUrls) {
			if (pathMatcher.match(externalURL, currentURL)) {
				log.debug("url filter : the url(" + currentURL
						+ ") matches externalUrlsList!");
				return true;
			}
			log.debug("url filter : the url(" + currentURL
					+ ") is not matches externalUrlsList!");
		}
		return false;
	}
}
