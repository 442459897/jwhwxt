/**
 * 
 */
package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.Admin;
import com.muran.model.UserMenuGroup;

/**
 * @author wxz
 * 
 */
public interface IUserMenuGroupDao extends IOperations<UserMenuGroup> {

	public List<UserMenuGroup> getUserMenuGroupsByGroupId(Long groupId);
	
	public void deleteUserMenuGroupByUsername(String username);
	
	public List<UserMenuGroup> getUserMenuGroupsByUsername(String username);
	
	public UserMenuGroup getUserMenuGroupByUsernameAndGroupId(String username,Long groupId);
	
	public List<Admin> getAdminByGroup(Long groupId);
	
}
