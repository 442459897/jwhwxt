package com.muran.api;

import com.muran.dto.*;
import com.muran.api.service.RepliesApiService;
import com.muran.api.AbstractApi;
import io.swagger.annotations.ApiParam;

import com.muran.dto.AddReply;

import java.util.List;
import java.io.InputStream;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/replies")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the replies API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class RepliesApi extends AbstractApi {
	@Autowired
	RepliesApiService service;

	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "\u56DE\u590D \u7559\u8A00\u8BC4\u8BBA/\u6211\u6709\u8BDD\u8BF4/\u56DE\u590D\u4FE1\u606F", notes = "", response = void.class, tags = { "replies(回复信息相关)", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "\u56DE\u590D\u6210\u529F", response = void.class) })
	public Response reply(
			@ApiParam(value = "\u56DE\u590Dbody", required = true) AddReply reply,
			@Context SecurityContext securityContext) {
		return service.reply(reply, context());
	}

	@PUT
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@Path("/{autoId}")
	public Response auditReply(@PathParam("autoId") Long autoId,
			@FormParam("status") Long status,
			@Context SecurityContext securityContext) {
		return service.auditReply(autoId, status, context());
	}
}
