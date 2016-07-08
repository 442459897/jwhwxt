package com.muran.api.service;

public interface IUserService {
	public void signUp(String username, String pwd, String userSys,
			String invitationCode);

	public void addAdmin(String username, String pwd, String userSys);

	public void deleteUser(String username, String userSys);
}