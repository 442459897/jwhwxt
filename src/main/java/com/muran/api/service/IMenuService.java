/**
 * 
 */
package com.muran.api.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.muran.model.Menu;


/**
 * @author wxz
 * 
 */
public interface IMenuService {

	public Menu addMenu(String type, String name, String descpt, String path,
			String icon, Integer order, Boolean enable, Long parentId,
			String roleKey, Boolean assign, Boolean isShow, String username,
			String userSys);

	public Menu updateMenu(Long autoId, String type, String name,
			String descpt, String path, String icon, Integer order,
			Boolean enable, Long parentId, String roleKey, Boolean assign,
			Boolean isShow, String username, String userSys);

	public void deleteMenu(Long autoId);

	public Menu getMenu(Long autoId);

	public List<Menu> getList(Long parentId);

	public List<LinkedHashMap<String, Object>> getUserMenuTree(String username);

	public List<LinkedHashMap<String, Object>> getAllMenuTree();
}
