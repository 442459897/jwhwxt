/**
 * 
 */
package com.muran.api;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muran.api.exception.AssertNull;
import com.muran.api.service.IRoleRelationService;

/**
 * @author wxz
 * 
 */
@Component
@Path("v1/rolerelations")
public class RoleRelationResource extends AbstractApi {

	@Autowired
	private IRoleRelationService service;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addRoleRelation(@FormParam("clientSys") String clientSys,
			@FormParam("clientOperKey") String clientOperKey,
			@FormParam("clientOperName") String clientOperName,
			@FormParam("serverRoleKey") String serverRoleKey,
			@FormParam("serverRoleName") String serverRoleName) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(clientSys, clientOperKey, serverRoleKey);
		return service.addRoleRelation(clientSys, clientOperKey,
				clientOperName, serverRoleKey, serverRoleName);
	}

	@PUT
	@Path("/{autoId}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRoleRelation(@PathParam("autoId") Long autoId,
			@FormParam("clientSys") String clientSys,
			@FormParam("clientOperKey") String clientOperKey,
			@FormParam("clientOperName") String clientOperName,
			@FormParam("serverRoleKey") String serverRoleKey,
			@FormParam("serverRoleName") String serverRoleName) {

		AssertNull.assertNull(clientSys, clientOperKey, serverRoleKey);
		return service.updateRoleRelation(autoId, clientSys, clientOperKey,
				clientOperName, serverRoleKey, serverRoleName);
	}

	@DELETE
	@Path("/{autoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("autoId") Long autoId) {
		// TODO Auto-generated method stub
		// return service.deleteById(autoId);
		return Response.ok().build();
	}

	@GET
	@Path("/{autoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoleRelation(@PathParam("autoId") Long autoId) {
		// TODO Auto-generated method stub

		// responseObject.setData(service.findOne(autoId));
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(@QueryParam("page") boolean page,
			@QueryParam("pageIndex") Integer pageIndex,
			@QueryParam("pageSize") Integer pageSize,
			@QueryParam("clientSys") String clientSys,
			@QueryParam("clientOperKey") String clientOperKey,
			@QueryParam("clientOperName") String clientOperName,
			@QueryParam("serverRoleKey") String serverRoleKey,
			@QueryParam("serverRoleName") String serverRoleName) {
		// TODO Auto-generated method stub
		if (page) {
			AssertNull.assertNull(pageIndex, pageSize);
			return service.getPageList(pageIndex, pageSize, clientSys,
					clientOperKey, clientOperName, serverRoleKey,
					serverRoleName);
		} else {
			return service.getList(clientSys, clientOperKey, clientOperName,
					serverRoleKey, serverRoleName);
		}
	}

	@GET
	@Path("/getbykey/{clientOperKey}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoleRelationByClientKey(
			@PathParam("clientOperKey") String clientOperKey) {
		//
		return service.getRoleRelationByClientKey(clientOperKey);
	}

}
