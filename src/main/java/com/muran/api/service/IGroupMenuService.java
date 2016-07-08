package com.muran.api.service;


public interface IGroupMenuService {

	public void buildGroupMenu(Long groupId, String menus);
	
	public String getMenuByGroup(Long groupId);
}
