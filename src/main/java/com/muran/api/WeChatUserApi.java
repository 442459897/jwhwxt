package com.muran.api;

import java.net.URISyntaxException;

import javax.servlet.http.Cookie;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muran.api.service.IWeChatUserService;
import com.muran.util.UserTokenUtil;

@Path("/wechatuser")
@Component
public class WeChatUserApi extends AbstractApi {

	@Autowired
	IWeChatUserService service;

	@GET
	@Produces({ "application/json" })
	public Response IsUserExist() throws URISyntaxException {
		Cookie cookie = UserTokenUtil.getCookieByName(request, "sessionId");
		if (cookie == null) {
			return Response.ok().entity(false).build();
		}
		String sessionId = cookie.getValue();
		if (sessionId == null || sessionId == "") {
			return Response.ok().entity(false).build();
		}
		boolean result = service.IsUserExistOrExpire(sessionId);
		return Response.ok().entity(result).build();
	}
}
