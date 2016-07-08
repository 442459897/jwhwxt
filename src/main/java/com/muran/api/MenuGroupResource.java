/**
 * 
 */
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
import org.springframework.stereotype.Component;

import com.muran.api.exception.AssertNull;
import com.muran.api.service.IMenuGroupService;

/**
 * @author wxz
 * 
 */
@Component
@Path("v1/menugroups")
public class MenuGroupResource extends AbstractApi {

	@Autowired
	IMenuGroupService service;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMenuGroup(@FormParam("groupName") String groupName,
			@FormParam("code") String code) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(groupName);
		return Response.ok().entity(service.addMenuGroup(groupName, code))
				.build();
	}

	@PUT
	@Path("/{autoId}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMenuGroup(@PathParam("autoId") Long autoId,
			@FormParam("groupName") String groupName) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(groupName);
		return Response.ok().entity(service.updateMenuGroup(autoId, groupName))
				.build();
	}

	@DELETE
	@Path("/{autoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMenuGroup(@PathParam("autoId") Long autoId) {
		// TODO Auto-generated method stub
		service.deleteMenuGroup(autoId);
		return Response.ok().build();
	}

	@GET
	@Path("/{autoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuGroup(@PathParam("autoId") Long autoId) {
		// TODO Auto-generated method stub
		return Response.ok().entity(service.getMenuGroup(autoId)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(@QueryParam("code") String code) {
		// TODO Auto-generated method stub
		return Response.ok().entity(service.getList(code)).build();
	}

}
