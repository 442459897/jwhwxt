package com.muran.aop;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.aop.annotation.UserSecurityVerify;
import com.muran.api.Context;
import com.muran.api.exception.ServerException;
import com.muran.application.SpringContextHolder;
import com.muran.filter.UserSysFilter;

@Aspect
@SuppressWarnings("rawtypes")
public class BussAspect {
	private final static Logger log = Logger.getLogger(BussAspect.class);
	// /测试自动化部署

	private List<String> externalUrls;

	public List<String> getExternalUrls() {
		return externalUrls;
	}

	public void setExternalUrls(List<String> externalUrls) {
		this.externalUrls = externalUrls;
	}

	// private FilterConfig config;
	private final PathMatcher pathMatcher = new AntPathMatcher();

	@Resource(name = "UserSecurityVerify")
	UserSecurityVerify securityHandler;

	@Around(value = "@annotation(com.muran.aop.annotation.BussAnnotation) && @annotation(annotation)")
	public Object around(ProceedingJoinPoint joinPoint,
			BussAnnotation annotation) throws Throwable {

		UserSysFilter userSysFilter = (UserSysFilter) SpringContextHolder
				.getBean("UserSysCheck");
		this.setExternalUrls(userSysFilter.getExternalUrls());

		Object result = null;
		//AbstractService service = (AbstractService) joinPoint.getTarget();

		Object[] params = joinPoint.getArgs();
		Context context = null;
		for (Object param : params) {
			if (param instanceof Context) {
				context = (Context) param;
//				if (context == null)
//					throw new ServerException(500, "未找到上下文信息");
				if (annotation.login()) {
					if (context.getUserSys().equals("wx")
							&& (context.getSessionId() == null
									|| context.getSessionId().equals("") || context
										.getSessionIsExpire())) {
						throw new ServerException(401, "微信用户未授权,请重新授权！");
					}

					if (context.getUserSys().equals("admin")
							&& !securityHandler.verify(context.getUserToken())) {
						throw new ServerException(401, "管理用户未登录,请重新登陆！");
					}
				}
			}
		}

		return result;
	}

	public static String getExceptionAllinformation(Throwable ex) {
		String sOut = "";
		StackTraceElement[] trace = ex.getStackTrace();
		for (StackTraceElement s : trace) {
			sOut += "\tat " + s + "\r\n";
		}
		return sOut;
	}

	public static String getExceptionAllinformation(Exception e) {
		String sOut = "";
		StackTraceElement[] trace = e.getStackTrace();
		for (StackTraceElement s : trace) {
			sOut += "\tat " + s + "\r\n";
		}
		return sOut;
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
