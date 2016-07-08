package com.muran.dao;

import com.muran.dao.operation.IOperations;
import com.muran.model.User;



public interface IUserDao extends IOperations<User> {
	public User getUser(String usernameOrPhone,String userSys);
	public User getUserByUsername(String username,String userSys);
	public User getUserByPhone(String phone,String userSys);
	public int updateMobile(String mobile,String username,String userSys);
	public int updatePassword(String username,String newPassword,String userSys);
	public int updatePwdByMobile(String mobile,String newPassword,String userSys);
	//public void create(User user,boolean newSession);
}
