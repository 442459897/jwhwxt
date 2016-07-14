package com.muran.api;

import io.swagger.annotations.ApiParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muran.api.service.IKeywordsService;
import com.muran.dto.GeneralString;

@Path("/keywords")
@Component
public class KeywordsApi extends AbstractApi {

	@Autowired
	IKeywordsService service;

	@GET
	@Path("/{columnKey}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6587\u7AE0\u8D44\u8BAF\u7684\u641C\u7D22\u5173\u952E\u5B57", notes = "", response = GeneralString.class, responseContainer = "List", tags = { "article(搜索关键字相关)", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "\u6587\u7AE0\u5217\u8868", response = GeneralString.class, responseContainer = "List") })
	public Response getArticlesKeywords(
			@ApiParam(value = "", required = true) @PathParam("columnKey") String columnKey,
			@Context SecurityContext securityContext) {
		return service.getKeywords(columnKey, context());
	}
}
