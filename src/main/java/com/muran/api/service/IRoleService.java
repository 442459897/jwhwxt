package com.muran.api.service;

import java.util.List;

import com.muran.model.Role;
import com.muran.util.Data;

public interface IRoleService {
	/**
	 * 新增角色
	 * 
	 * @param roleName
	 * @param descpt
	 * @param key
	 * @return
	 */
	public Role createRole(String roleName, String descpt, String keyCode,
			long parentId, String category,boolean enable);

	/**
	 * 修改角色
	 * 
	 * @param id
	 * @param roleName
	 * @param descpt
	 * @param key
	 * @return
	 */
	public Role modifyRole(Long id, String roleName, String descpt,
			String keyCode, long parentId, String category,boolean enable);

	/**
	 * 根据id查询角色
	 * 
	 * @param id
	 * @return
	 */
	public Role findOneById(Long id);

	/**
	 * 根据id删除角色
	 * 
	 * @param id
	 * @return
	 */
	public void deleteRole(Long id);

	/**
	 * 查询角色列表
	 * 
	 * @param name
	 * @param descpt
	 * @return
	 */
	public List<Role> getList(String name, String descpt,String roleKey,String category);

	public Data<Role> getPageList(Integer pageSize, Integer pageIndex,
			String name, String descpt,String roleKey,String category);

	public List<Role> getRoleTree();
	
	public void isRoleOk(String userSys,String username,String roleKey);
	
	public void createAllRoleKey();
}
