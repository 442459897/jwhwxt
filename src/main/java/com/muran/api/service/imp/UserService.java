package com.muran.api.service.imp;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IUserService;
import com.muran.dao.IUserDao;
import com.muran.model.User;
import com.muran.util.PasswordHash;

@Service("UserService")
public class UserService extends AbstractService implements IUserService {
	
	private final static Logger log = Logger.getLogger(UserService.class);

	@Autowired
	UserLoginService loginService;
	 
	@Resource(name = "UserDao")
	private IUserDao userDao;

	@Override
	@Transactional
	@BussAnnotation(bussName = "用户名注册", login = false, role = "")
	public void signUp(String username, String pwd, String userSys,
			String invitationCode) {
		pwd = pwd.toUpperCase();

		User user = userDao.getUser(username, userSys);
		if (user != null) {// 用户已存在
			throw new ServerException(Code.UsernameHasExsited);
		}

		user = new User();
		user.setUserSys(userSys);
		user.setUsername(username);
		if (pwd.length() < 6)
			throw new ServerException(Code.PasswordLengthException, "密码不少于6位");
		String hashPwd = PasswordHash.createHash(pwd);
		user.setPassword(hashPwd);
		userDao.save(user);
	}

	@Override
	@Transactional
	@BussAnnotation(bussName = "添加管理员", login = false, role = "")
	public void addAdmin(String username, String pwd, String userSys) {
		pwd = pwd.toUpperCase();
		User user = userDao.getUser(username, userSys);
		if (user != null) {// 用户已存在
			throw new ServerException(Code.UsernameHasExsited);
		}
		user = new User();
		user.setUserSys(userSys);
		user.setUsername(username);
		if (pwd.length() < 6)
			throw new ServerException(Code.PasswordLengthException, "密码不少于6位");
		String hashPwd = PasswordHash.createHash(pwd);
		user.setPassword(hashPwd);
		userDao.save(user);
	}

	@Override
	@Transactional
	@BussAnnotation(bussName = "注销用户", login = true, role = "")
	public void deleteUser(String username, String userSys) {
		User user = userDao.getUser(username, userSys);
		if (user == null) {// 用户不存在
			throw new ServerException(Code.UserNotFound);
		}
		userDao.delete(user);
	}
}
