package com.muran.api;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muran.api.service.IPasswordService;
import com.muran.api.service.IUserLoginService;
import com.muran.model.UserToken;
import com.muran.util.FileUtil;

@Component
@Path("/users")
public class UserApi extends AbstractApi {

	private final static Logger log = Logger.getLogger(FileUtil.class);

	@Autowired
	IUserLoginService loginService;

	@Autowired
	IPasswordService pwdService;

	@POST
	@Path("/{username}/login")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ "application/json" })
	public Response login(@PathParam("username") String username,
			@FormParam("password") String password) {
		UserToken token = loginService.login(username, password, "admin");
		return Response.ok().entity(token).build();
	}

	@POST
	@Path("/loginout")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ "application/json" })
	public Response loginOut() {
		loginService.loginOut(getUserToken());
		return Response.ok().entity(true).build();
	}

	@POST
	@Path("/{username}/password")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ "application/json" })
	public Response modifyPwd(@PathParam("username") String username,
			@FormParam("newpwd") String newpwd,
			@FormParam("oldpwd") String oldpwd) {
		pwdService.modifyPassword(oldpwd, newpwd, getUserToken());
		return Response.ok().entity(true).build();
	}

	@POST
	@Path("/{username}/password/reset")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ "application/json" })
	public Response resetPwd(@PathParam("username") String username) {
		pwdService.resetPassword(username);
		return Response.ok().entity(true).build();
	}
}
