package com.muran.api.service;

import javax.ws.rs.core.Response;

public interface IRoleRelationService {

	public Response addRoleRelation(String clientSys, String clientOperKey,
			String clientOperName, String serverRoleKey, String serverRoleName);

	public Response updateRoleRelation(Long autoId, String clientSys,
			String clientOperKey, String clientOperName, String serverRoleKey,
			String serverRoleName);

	public Response getList(String clientSys, String clientOperKey,
			String clientOperName, String serverRoleKey, String serverRoleName);

	public Response getPageList(Integer pageIndex, Integer pageSize,
			String clientSys, String clientOperKey, String clientOperName,
			String serverRoleKey, String serverRoleName);

	public Response getRoleRelationByClientKey(String clientOperKey);

}
