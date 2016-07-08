package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.Menu;

public interface IMenuDao extends IOperations<Menu> {

	public List<Menu> getList(Long parentId);
	
	public List<Menu> getListByUsername(String username);
	
	public List<Menu> getListByUsernameAndType(String username,String type);
	
	public List<Menu> getListByUsernameAndParentId(String username,Long parentId);
}
