/**
 * 
 */
package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.UserMenuGroup;

/**
 * @author wxz
 * 
 */
public interface IUserMenuGroupDao extends IOperations<UserMenuGroup> {

	public List<UserMenuGroup> getUserMenuGroupsByGroupId(Long groupId);
	
	public void deleteUserMenuGroupByUsername(String username);
	
	public List<UserMenuGroup> getUserMenuGroupsByUsername(String username);
	
}
