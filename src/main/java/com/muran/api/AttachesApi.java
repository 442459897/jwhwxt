package com.muran.api;

import com.muran.dto.*;
import com.muran.api.service.AttachesApiService;
import com.muran.api.AbstractApi;
import io.swagger.annotations.ApiParam;

import com.muran.dto.AttachInfo;

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

@Path("/attaches")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the attaches API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AttachesApi extends AbstractApi {
    @Autowired
    AttachesApiService service;
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u67E5\u8BE2\u9644\u4EF6\u4FE1\u606F", notes = "", response = AttachInfo.class, responseContainer = "List", tags={ "attaches(我有话说相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u4FE1\u606F\u6210\u529F", response = AttachInfo.class, responseContainer = "List") })
    public Response getAttachInfo(@ApiParam(value = "\u680F\u76EEkey",required=true) @QueryParam("columnKey") String columnKey,@ApiParam(value = "\u5BF9\u8C61id",required=true) @QueryParam("itemId") Integer itemId,@Context  SecurityContext securityContext){
        return service.getAttachInfo(columnKey,itemId,context());
    }
}
