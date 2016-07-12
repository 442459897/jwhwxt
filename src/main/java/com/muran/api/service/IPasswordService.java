/**
 * 
 */
package com.muran.api.service;

/**
 * @author wxz
 * 
 */
public interface IPasswordService {

	public void modifyPassword(String oldPassword, String newPassword,
			String userToken);

	public void verifyPassword(String userToken, String password);
	
	public void resetPassword(String username);

}
