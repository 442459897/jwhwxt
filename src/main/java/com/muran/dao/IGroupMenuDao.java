/**
 * 
 */
package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.GroupMenu;

/**
 * @author wxz
 * 
 */
public interface IGroupMenuDao extends IOperations<GroupMenu> {

	public List<GroupMenu> getGroupMenusByGroupId(Long groupId);

	public void deleteGroupMenusByGroupId(Long groupId);

	public String getRelationRoles(Long menuId, Long groupId);
}
