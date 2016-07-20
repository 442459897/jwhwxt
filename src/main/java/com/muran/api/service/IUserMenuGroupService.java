package com.muran.api.service;

import java.util.List;

import com.muran.model.Admin;
import com.muran.model.MenuGroup;

public interface IUserMenuGroupService  {

	public void buildUserMenuGroup(String username, String groups);
	
	public void buildUserMenuGroupByUser(String usernames, Long groupId);
	
	public List<MenuGroup> getMenuGroupListByUsername(String username);
	
	public List<Admin> getAdminListByGroup(Long groupId);
}
