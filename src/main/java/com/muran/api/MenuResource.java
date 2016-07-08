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

import com.muran.api.exception.AssertNull;
import com.muran.model.Menu;
import com.muran.api.service.IMenuService;

/**
 * @author wxz
 * 
 */

@Path("v1/menus")
public class MenuResource extends AbstractApi {

	@Autowired
	IMenuService service;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMenu(@FormParam("type") String type,
			@FormParam("name") String name, @FormParam("descpt") String descpt,
			@FormParam("path") String path, @FormParam("icon") String icon,
			@FormParam("order") Integer order,
			@FormParam("enable") Boolean enable,
			@FormParam("parentId") Long parentId,
			@FormParam("roleKey") String roleKey,
			@FormParam("assign") Boolean assign,
			@FormParam("isShow") Boolean isShow) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(type, name, order, enable, parentId, assign);
		if (type.equals("menu") || type.equals("sub")) {
			AssertNull.assertNull(roleKey);
		}
		String userSys = getUserSys();
		String username = getUsername();
		Menu menu = service.addMenu(type, name, descpt, path,
				icon, order, enable, parentId, roleKey, assign, isShow,
				username, userSys);
		return Response.ok().entity(menu).build();
	}

	@PUT
	@Path("/{autoId}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMenu(@PathParam("autoId") Long autoId,
			@FormParam("type") String type, @FormParam("name") String name,
			@FormParam("descpt") String descpt, @FormParam("path") String path,
			@FormParam("icon") String icon, @FormParam("order") Integer order,
			@FormParam("enable") Boolean enable,
			@FormParam("parentId") Long parentId,
			@FormParam("roleKey") String roleKey,
			@FormParam("assign") Boolean assign,
			@FormParam("isShow") Boolean isShow) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(type, name, order, enable, parentId);
		if (type.equals("menu") || type.equals("sub")) {
			AssertNull.assertNull(roleKey);
		}
		String userSys = getUserSys();
		String username = getUsername();
		Menu menu = service.updateMenu(autoId, type, name, descpt, path, icon,
				order, enable, parentId, roleKey, assign, isShow, username,
				userSys);
		return Response.ok().entity(menu).build();
	}

	@DELETE
	@Path("/{autoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMenu(@PathParam("autoId") Long autoId) {
		// TODO Auto-generated method stub
		service.deleteMenu(autoId);
		return Response.ok().build();
	}

	@GET
	@Path("/{autoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenu(@PathParam("autoId") Long autoId) {
		// TODO Auto-generated method stub
		return Response.ok().entity(service.getMenu(autoId)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(@QueryParam("parentId") Long parentId) {
		// TODO Auto-generated method stub
		return Response.ok().entity(service.getList(parentId)).build();
	}

	@Path("/usermenus")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserMenu() {
		// TODO Auto-generated method stub
		return Response.ok().entity(service.getUserMenuTree(getUsername()))
				.build();
	}

	@Path("/tree")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMenu() {
		// TODO Auto-generated method stub
		return Response.ok().entity(service.getAllMenuTree()).build();
	}
}
