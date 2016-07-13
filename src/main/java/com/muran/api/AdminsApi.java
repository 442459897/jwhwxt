package com.muran.api;

import com.muran.dto.*;
import com.muran.api.service.AdminsApiService;
import com.muran.api.AbstractApi;
import io.swagger.annotations.ApiParam;

import com.muran.dto.AdminInfo;
import com.muran.dto.AddAdmin;
import com.muran.dto.PageData;

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

@Path("/admins")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the admins API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AdminsApi extends AbstractApi {
    @Autowired
    AdminsApiService service;
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u65B0\u589E\u4EBA\u5458\u4FE1\u606F", notes = "", response = AdminInfo.class, tags={ "admins(人员管理相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u4FE1\u606F\u6210\u529F", response = AdminInfo.class) })
    public Response addAdmin(@ApiParam(value = "\u4EBA\u5458\u4FE1\u606Fbody" ,required=true) AddAdmin admin,@Context  SecurityContext securityContext){
        return service.addAdmin(admin,context());
    }
    @DELETE
    @Path("/{autoId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u6839\u636Eid\u5220\u9664\u4EBA\u5458\u4FE1\u606F", notes = "", response = void.class, tags={ "admins(人员管理相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u5220\u9664\u4FE1\u606F\u6210\u529F", response = void.class) })
    public Response deleteAdminInfo(@ApiParam(value = "\u4EBA\u5458\u4FE1\u606FautoId",required=true) @PathParam("autoId") Long autoId,@Context  SecurityContext securityContext){
        return service.deleteAdminInfo(autoId,context());
    }
    @GET
    @Path("/{autoId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u6839\u636Eid\u83B7\u53D6\u4EBA\u5458\u4FE1\u606F", notes = "", response = AdminInfo.class, tags={ "admins(人员管理相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u4FE1\u606F\u6210\u529F", response = AdminInfo.class) })
    public Response getAdminInfo(@ApiParam(value = "\u4EBA\u5458\u4FE1\u606FautoId",required=true) @PathParam("autoId") Long autoId,@Context  SecurityContext securityContext){
        return service.getAdminInfo(autoId,context());
    }
    @GET
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u4EBA\u5458\u4FE1\u606F\u5217\u8868", notes = "", response = PageData.class, responseContainer = "List", tags={ "admins(人员管理相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u4FE1\u606F\u6210\u529F", response = PageData.class, responseContainer = "List") })
    public Response getAdminPageList(@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA410\u6761",required=true) @QueryParam("pageSize") Integer pageSize,@ApiParam(value = "\u8D77\u59CB\u9875.\u9ED8\u8BA41",required=true) @QueryParam("pageIdex") Integer pageIdex,@ApiParam(value = "\u4EBA\u5458\u59D3\u540D") @QueryParam("name") String name,@Context  SecurityContext securityContext){
        return service.getAdminPageList(pageSize,pageIdex,name,context());
    }
    @PUT
    @Path("/{autoId}")
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u4FEE\u6539\u4EBA\u5458\u4FE1\u606F", notes = "", response = AdminInfo.class, tags={ "admins(人员管理相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u4FE1\u606F\u6210\u529F", response = AdminInfo.class) })
    public Response updateAdmin(@ApiParam(value = "\u4EBA\u5458\u4FE1\u606FautoId",required=true) @PathParam("autoId") Long autoId,@ApiParam(value = "\u4EBA\u5458\u4FE1\u606FautoId", required=true)@FormParam("name")  String name,@ApiParam(value = "", required=true)@FormParam("gender")  Boolean gender,@ApiParam(value = "")@FormParam("mobile")  String mobile,@ApiParam(value = "")@FormParam("email")  String email,@ApiParam(value = "")@FormParam("idNumber")  String idNumber,@Context  SecurityContext securityContext){
        return service.updateAdmin(autoId,name,gender,mobile,email,idNumber,context());
    }
}
