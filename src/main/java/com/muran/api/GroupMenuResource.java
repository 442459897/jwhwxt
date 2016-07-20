package com.muran.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muran.api.exception.AssertNull;
import com.muran.api.service.IGroupMenuService;
import com.muran.dto.GeneralString;

@Component
@Path("v1/groupmenus")
public class GroupMenuResource extends AbstractApi {

	@Autowired
	IGroupMenuService service;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buildGroupMenu(@FormParam("groupId") Long groupId,
			@FormParam("menus") String menus) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(groupId);
		service.buildGroupMenu(groupId, menus);
		return Response.status(Status.OK).build();
	}

	@GET
	@Path("/{groupId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuByGroup(@PathParam("groupId") Long groupId) {
		// TODO Auto-generated method stub
		GeneralString str = new GeneralString();
		str.setValue(service.getMenuByGroup(groupId));
		return Response.ok().entity(str).build();
	}

}
