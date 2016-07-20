/**
 * 
 */
package com.muran.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muran.api.exception.AssertNull;
import com.muran.api.service.IUserMenuGroupService;


/**
 * @author wxz
 * 
 */
@Component
@Path("v1/usermenugroups")
public class UserMenuGroupResource extends AbstractApi {
	
	@Autowired
	IUserMenuGroupService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buildUserMenuGroup(
			@FormParam("username") String username,
			@FormParam("groups") String groups) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(username);
		service.buildUserMenuGroup(username, groups);
		return Response.ok().build();
	}
	
	@POST
	@Path("/adduser")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buildUserMenuGroupByUser(
			@FormParam("usernames") String usernames,
			@FormParam("groupId") Long groupId) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(usernames,groupId);
		service.buildUserMenuGroupByUser(usernames, groupId);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenuGroupListByUsername(
			@QueryParam("username") String username) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(username);
		return Response.ok().entity(service.getMenuGroupListByUsername(username)).build();
	}

}
