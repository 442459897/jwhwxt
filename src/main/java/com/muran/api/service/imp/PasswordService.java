/**
 * 
 */
package com.muran.api.service.imp;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.api.exception.Code;
import com.muran.api.exception.GeneralResponseCode;
import com.muran.api.exception.ServerException;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IPasswordService;
import com.muran.dao.IUserDao;
import com.muran.dao.IUserTokenDao;
import com.muran.model.User;
import com.muran.model.UserToken;
import com.muran.util.PasswordHash;

/**
 * @author wxz
 * 
 */
@Service("PasswordService")
public class PasswordService extends AbstractService implements
		IPasswordService {

	private final static Logger log = Logger.getLogger(PasswordService.class);

	@Resource(name = "UserDao")
	private IUserDao userDao;

	@Resource(name = "UserTokenDao")
	private IUserTokenDao userTokenDao;

	@Override
	@BussAnnotation(bussName = "修改登陆密码", login = true, role = "")
	public void modifyPassword(String oldPassword, String newPassword,
			String userToken) {
		// md5密码转换为大写
		oldPassword = oldPassword.toUpperCase();
		newPassword = newPassword.toUpperCase();
		// 根据token获取username
		if (newPassword.length() < 6)
			throw new ServerException(Code.PasswordLengthException, "密码不少于6位");
		UserToken userTokenObject = new UserToken();
		userTokenObject = (UserToken) userTokenDao
				.getUserTokenByToken(userToken);

		if (userTokenObject == null) {
			throw new ServerException(GeneralResponseCode.UserTokenException);
		}
		// 获取用户信息
		User user = new User();
		user = userDao.getUserByUsername(userTokenObject.getUsername(),
				userTokenObject.getUserSys());
		if (user == null) {
			throw new ServerException(GeneralResponseCode.UserSecurityExcepiton);
		}
		// 验证原来的密码
		String password = user.getPassword();

		if (!PasswordHash.validatePassword(oldPassword, password)) {
			throw new ServerException(Code.PasswordUnCorrect);
		}
		// 对新密码加密
		String newHashPwd = PasswordHash.createHash(newPassword);
		// 更新密码
		int i = userDao.updatePassword(userTokenObject.getUsername(),
				newHashPwd, userTokenObject.getUserSys());
		if (i <= 0) {
			throw new ServerException(Code.OperationFailed);
		}

	}

	@Override
	@BussAnnotation(bussName = "验证登陆密码", login = true, role = "")
	public void verifyPassword(String userToken, String password) {
		// TODO Auto-generated method stub
		password = password.toUpperCase();
		// 根据token获取username
		UserToken userTokenObject = new UserToken();
		userTokenObject = (UserToken) userTokenDao
				.getUserTokenByToken(userToken);

		if (userTokenObject == null) {
			throw new ServerException(GeneralResponseCode.UserTokenException);
		}
		// 获取用户信息
		User user = new User();
		user = userDao.getUserByUsername(userTokenObject.getUsername(),
				userTokenObject.getUserSys());
		if (user == null) {
			throw new ServerException(GeneralResponseCode.UserSecurityExcepiton);
		}
		String dbPassword = user.getPassword();
		boolean bool = PasswordHash.validatePassword(password, dbPassword);
		if (!bool) {
			throw new ServerException(Code.PasswordUnCorrect);
		}
	}

	@Override
	@BussAnnotation(bussName = "重置登陆密码", login = true, role = "")
	public void resetPassword(String username) {
		// TODO Auto-generated method stub
		String newHashPwd = PasswordHash.createHash("88888888");
		int i = userDao.updatePassword(username, newHashPwd, "admin");
		if (i <= 0) {
			throw new ServerException(Code.OperationFailed);
		}
	}

}
