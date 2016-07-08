/**
 * 
 */
package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.MenuGroup;

/**
 * @author wxz
 * 
 */
public interface IMenuGroupDao extends IOperations<MenuGroup> {

	
	public List<MenuGroup> getMenuGroupsByUsername(String username);
	
	public List<MenuGroup> getList(String code);
	
	public List<MenuGroup> getMenuGroupListByCode(String code);

}
