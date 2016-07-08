package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.Role;
import com.muran.util.Data;
/**
 * 
 * @author 郑金龙 日期：2015-7-21
 */
public interface IRoleDao extends IOperations<Role> {

	public boolean checkRepeat(Long id, String key, String roleName);

	public Data<Role> getPageList(Integer pageSize, Integer pageIndex,
			String name, String descpt,String roleKey,String category);

	public List<Role> getList(String name, String descpt,String roleKey,String category);
	public List<Role> getChildList(long parentId);
	
	public Role getRoleByKey(String key);
	
	public boolean isRoleOk(String username,String key);
	
}
