/**
 * 
 */
package com.muran.api.service;

/**
 * @author wxz
 *
 */
public interface IUserTokenService  {

	public void CreateUserToken(String userToken,String tokenSecret);
	
	public void setDisnableState(String userToken);
	
	public void deleteUser(String username,String userSys);
}
