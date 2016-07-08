package com.muran.api.service;

import java.util.List;

import com.muran.model.MenuGroup;

public interface IUserMenuGroupService  {

	public void buildUserMenuGroup(String username, String groups);
	
	public List<MenuGroup> getMenuGroupListByUsername(String username);
}
