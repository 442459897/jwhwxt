/**
 * 
 */
package com.muran.api.service.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.muran.aop.annotation.BussAnnotation;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IRoleRelationService;
import com.muran.dao.IRoleRelationDao;
import com.muran.model.RoleRelation;
import com.muran.util.Data;

/**
 * @author wxz
 * 
 */
@Service("RoleRelationService")
public class RoleRelationService extends AbstractService implements
		IRoleRelationService {

	@Resource(name = "RoleRelationDao")
	private IRoleRelationDao dao;

	@Override
	@BussAnnotation(bussName = "新增客户端权限关系", login = true, role = "")
	public Response addRoleRelation(String clientSys, String clientOperKey,
			String clientOperName, String serverRoleKey, String serverRoleName) {
		// TODO Auto-generated method stub
		RoleRelation roleRelation = new RoleRelation();
		roleRelation = dao.getRoleRelationByClientKey(clientOperKey);
		if (roleRelation != null) {
			throw new ServerException(Code.ClientKeyHasExist, "客户端key已存在");
		}
		roleRelation = new RoleRelation();
		roleRelation.setClientOperKey(clientOperKey);
		roleRelation.setClientOperName(clientOperName);
		roleRelation.setClientSys(clientSys);
		roleRelation.setServerRoleKey(serverRoleKey);
		roleRelation.setServerRoleName(serverRoleName);
		dao.merge(roleRelation);

		return Response.ok().build();

	}

	@Override
	@BussAnnotation(bussName = "修改客户端权限关系", login = true, role = "")
	public Response updateRoleRelation(Long autoId, String clientSys,
			String clientOperKey, String clientOperName, String serverRoleKey,
			String serverRoleName) {
		RoleRelation roleRelation = new RoleRelation();
		// roleRelation = dao.getRoleRelationByClientKey(clientOperKey);
		// if (roleRelation == null) {
		// throw new BaseException(Code.ClientKeyHasExist, "客户端key已存在");
		// }
		roleRelation = dao.findOne(autoId);
		if (roleRelation == null) {
			throw new ServerException(Code.ClientKeyNotFound, "关系不存在");
		}
		roleRelation.setClientOperKey(clientOperKey);
		roleRelation.setClientOperName(clientOperName);
		roleRelation.setClientSys(clientSys);
		roleRelation.setServerRoleKey(serverRoleKey);
		roleRelation.setServerRoleName(serverRoleName);
		dao.update(roleRelation);

		return Response.ok().build();
	}

	@Override
	@BussAnnotation(bussName = "获取客户端权限关系列表", login = true, role = "")
	public Response getList(String clientSys, String clientOperKey,
			String clientOperName, String serverRoleKey, String serverRoleName) {
		// TODO Auto-generated method stub
		List<RoleRelation> list = dao.getList(clientSys, clientOperKey,
				clientOperName, serverRoleKey, serverRoleName);
		return Response.ok().entity(list).build();
	}

	@Override
	@BussAnnotation(bussName = "获取客户端权限关系列表（分页）", login = true, role = "")
	public Response getPageList(Integer pageIndex, Integer pageSize,
			String clientSys, String clientOperKey, String clientOperName,
			String serverRoleKey, String serverRoleName) {
		// TODO Auto-generated method stub
		Data<RoleRelation> data = dao.getPageList(pageIndex, pageSize,
				clientSys, clientOperKey, clientOperName, serverRoleKey,
				serverRoleName);

		return Response.ok().entity(data).build();
	}

	@Override
	public Response getRoleRelationByClientKey(String clientOperKey) {
		// TODO Auto-generated method stub
		RoleRelation relation = dao.getRoleRelationByClientKey(clientOperKey);
		return Response.ok().entity(relation).build();

	}

}
