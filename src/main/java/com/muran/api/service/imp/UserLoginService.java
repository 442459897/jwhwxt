package com.muran.api.service.imp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IUserLoginService;
import com.muran.dao.IUserDao;
import com.muran.dao.IUserTokenDao;
import com.muran.model.User;
import com.muran.model.UserToken;
import com.muran.util.PasswordHash;
import com.muran.aop.annotation.BussAnnotation;

@Service("UserLoginService")
@Scope("prototype")
public class UserLoginService extends AbstractService implements
		IUserLoginService {
	private final static Logger log = Logger.getLogger(UserLoginService.class);
	@Resource(name = "UserTokenDao")
	private IUserTokenDao userTokenDao;
	@Resource(name = "UserDao")
	private IUserDao userDao;

	@Override
	@BussAnnotation(bussName = "用户登录", login = false, role = "")
	@Transactional(readOnly = false)
	public UserToken login(String usernameOrPhone, String password,
			String userSys) {
		password = password.toUpperCase();
		User user = userDao.getUser(usernameOrPhone, userSys);
		if (user != null
				&& PasswordHash.validatePassword(password, user.getPassword())) {// 密码验证
			UserToken ut = user.newUserToken();
			userTokenDao.save(ut);
			return ut;
		} else
			throw new ServerException(Code.UserOrPasswordErrorException,
					"用户名或密码错误！");
	}

	// 获取ip地址
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	@Override
	@BussAnnotation(bussName = "登出", login = true, role = "")
	public void loginOut(String userToken) {
		userTokenDao.setDisnableState(userToken);
	}

}
