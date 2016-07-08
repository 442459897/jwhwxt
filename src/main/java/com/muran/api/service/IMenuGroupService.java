/**
 * 
 */
package com.muran.api.service;

import java.util.List;

import com.muran.model.MenuGroup;

/**
 * @author wxz
 * 
 */
public interface IMenuGroupService {

	public MenuGroup addMenuGroup(String name, String code);

	public MenuGroup updateMenuGroup(Long autoId, String name);

	public void deleteMenuGroup(Long autoId);

	public MenuGroup getMenuGroup(Long autoId);

	public List<MenuGroup> getList(String code);

	

	
	
}
