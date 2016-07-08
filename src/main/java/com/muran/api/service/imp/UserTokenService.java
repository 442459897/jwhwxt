/**
 * 
 */
package com.muran.api.service.imp;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.muran.dao.IUserTokenDao;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IUserTokenService;


/**
 * @author wxz
 * 
 */
public class UserTokenService extends AbstractService implements
		IUserTokenService {

	@Resource(name = "UserTokenDao")
	private IUserTokenDao dao;

	@Override
	@Transactional(readOnly = false)
	public void CreateUserToken(String userToken, String tokenSecret) {
		// TODO Auto-generated method stub
		dao.updateUserTokenDisnable(userToken);
		dao.createUserToken(userToken, tokenSecret);
	}

	@Override
	@Transactional(readOnly = false)
	public void setDisnableState(String userToken) {
		// TODO Auto-generated method stub
		dao.setDisnableState(userToken);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String username, String userSys) {
		// TODO Auto-generated method stub
		dao.updateUserTokenDisnable(username, userSys);
	}
}
