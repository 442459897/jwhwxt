package com.muran.api.service;

import com.muran.model.UserToken;



public interface IUserLoginService {
	public UserToken login(String usernameOrPhone,String password,String userSys);
	public void loginOut(String userToken);
	
}