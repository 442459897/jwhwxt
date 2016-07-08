package com.muran.dao;

import com.muran.dao.operation.IOperations;
import com.muran.model.UserToken;

public interface IUserTokenDao extends IOperations<UserToken>{
	public void setDisnableIfExsited(long userId);
	public void setDisnableState(String token);
	public void setUserDisnableState(String username);
	public UserToken getUserTokenByToken(String token);
	public void create(String token,String secrect);
	void setDisnableState(String token, boolean newSession);
	void create(String token, String secrect, boolean newSession);
	
	public void updateUserTokenDisnable(String token); 
	public void updateUserTokenDisnable(String username,String userSys); 
	public void createUserToken(String token,String secrect);
}
