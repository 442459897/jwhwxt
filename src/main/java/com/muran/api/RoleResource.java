package com.muran.api;

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

import com.muran.api.exception.AssertNull;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.model.Role;
import com.muran.api.service.IRoleService;

@Path("v1/roles")
public class RoleResource extends AbstractApi {

	@Autowired
	IRoleService service;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createRole(@FormParam("roleName") String roleName,
			@FormParam("descpt") String descpt,
			@FormParam("keyCode") String keyCode,
			@FormParam("parentId") long parentId,
			@FormParam("category") String category,
			@FormParam("enable") boolean enable) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(roleName, keyCode, category);

		Role role = service.createRole(roleName, descpt, keyCode, parentId,
				category, enable);
		return Response.ok().entity(role).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{autoId}")
	public Response modifyRole(@PathParam("autoId") Long id,
			@FormParam("roleName") String roleName,
			@FormParam("descpt") String descpt,
			@FormParam("keyCode") String keyCode,
			@FormParam("parentId") long parentId,
			@FormParam("category") String category,
			@FormParam("enable") boolean enable) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(id, roleName, keyCode, category);
		Role role = service.modifyRole(id, roleName, descpt, keyCode, parentId,
				category, enable);
		return Response.ok().entity(role).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{autoId}")
	public Response findOneById(@PathParam("autoId") Long id) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(id);
		Role role = service.findOneById(id);
		if (role == null) {
			throw new ServerException(Code.RoleNotFound);
		}
		return Response.ok().entity(role).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{autoId}")
	public Response deleteRole(@PathParam("autoId") Long id) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(id);
		service.deleteRole(id);
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(@QueryParam("page") boolean page,
			@QueryParam("pageSize") Integer pageSize,
			@QueryParam("pageIndex") Integer pageIndex,
			@QueryParam("roleName") String name,
			@QueryParam("descpt") String descpt,
			@QueryParam("roleKey") String roleKey,
			@QueryParam("category") String category) {
		// TODO Auto-generated method stub
		if (page) {
			AssertNull.assertNull(pageIndex, pageSize);
			return Response
					.ok()
					.entity(service.getPageList(pageSize, pageIndex, name,
							descpt, roleKey, category)).build();
		} else {
			return Response.ok()
					.entity(service.getList(name, descpt, roleKey, category))
					.build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/roleTree")
	public Response getRoleTree() {
		// TODO Auto-generated method stub
		return Response.ok().entity(service.getRoleTree()).build();

	}

	@GET
	@Path("/isroleok/{roleKey}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response isHasTheRole(@PathParam("roleKey") String roleKey) {
		// TODO Auto-generated method stub
		service.isRoleOk(getUserSys(), getUsername(), roleKey);
		return Response.ok().build();
	}

	@POST
	@Path("/initroles")
	public Response initRoleTable() {
		// TODO Auto-generated method stub
		service.createAllRoleKey();
		return Response.ok().build();
	}

}
