package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.RoleRelation;
import com.muran.util.Data;


public interface IRoleRelationDao extends IOperations<RoleRelation> {

	public List<RoleRelation> getList(String clientSys, String clientOperKey,
			String clientOperName, String serverRoleKey, String serverRoleName);

	public Data<RoleRelation> getPageList(Integer pageIndex, Integer pageSize,
			String clientSys, String clientOperKey, String clientOperName,
			String serverRoleKey, String serverRoleName);
	
	public RoleRelation getRoleRelationByClientKey(String clientOperKey);
}
