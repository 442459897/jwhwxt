package com.muran.api;

import com.muran.dto.*;
import com.muran.api.service.ActivitiesApiService;
import com.muran.api.AbstractApi;
import io.swagger.annotations.ApiParam;

import com.muran.dto.AddActivity;
import com.muran.dto.ActivityInfo;
import com.muran.dto.PageData;
import com.muran.dto.SampleActivity;
import com.muran.dto.SignupWxInfo;
import com.muran.dto.SignupActivity;

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

@Path("/activities")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the activities API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class ActivitiesApi extends AbstractApi {
    @Autowired
    ActivitiesApiService service;
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u65B0\u589E\u6D3B\u52A8", notes = "", response = ActivityInfo.class, tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6D3B\u52A8\u4FE1\u606F", response = ActivityInfo.class) })
    public Response addActivity(@ApiParam(value = "\u6D3B\u52A8body" ,required=true) AddActivity activity,@Context  SecurityContext securityContext){
        return service.addActivity(activity,context());
    }
    @PUT
    @Path("/{autoId}/back")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u6536\u56DE\u6D3B\u52A8\u4FE1\u606F\uFF08\u540E\u53F0\uFF09", notes = "", response = void.class, tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6536\u56DE\u6D3B\u52A8\u4FE1\u606F", response = void.class) })
    public Response backActivity(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@Context  SecurityContext securityContext){
        return service.backActivity(autoId,context());
    }
    @DELETE
    @Path("/{autoId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u5220\u9664\u6D3B\u52A8\u4FE1\u606F", notes = "", response = void.class, tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6D3B\u52A8\u4FE1\u606F\u5220\u9664\u6210\u529F", response = void.class) })
    public Response deleteActivity(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@Context  SecurityContext securityContext){
        return service.deleteActivity(autoId,context());
    }
    @GET
    @Path("/{autoId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6D3B\u52A8\u4FE1\u606F", notes = "", response = ActivityInfo.class, tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6D3B\u52A8\u4FE1\u606F\u5220\u9664\u6210\u529F", response = ActivityInfo.class) })
    public Response getActivity(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@Context  SecurityContext securityContext){
        return service.getActivity(autoId,context());
    }
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6D3B\u52A8\u5217\u8868", notes = "", response = PageData.class, responseContainer = "List", tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6D3B\u52A8\u4FE1\u606F", response = PageData.class, responseContainer = "List") })
    public Response getActivityPageList(@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA410\u6761") @QueryParam("pageSize") Integer pageSize,@ApiParam(value = "\u8D77\u59CB\u9875.\u9ED8\u8BA41") @QueryParam("pageIndex") Integer pageIndex,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("startTime") Long startTime,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("endTime") Long endTime,@ApiParam(value = "\u6D3B\u52A8\u6807\u9898") @QueryParam("title") String title,@ApiParam(value = "\u6D3B\u52A8\u5173\u952E\u5B57") @QueryParam("keyword") String keyword,@ApiParam(value = "\u72B6\u6001,0:\u672A\u53D1\u5E03,1:\u5DF2\u53D1\u5E03,2:\u6536\u56DE") @QueryParam("status") String status,@Context  SecurityContext securityContext){
        return service.getActivityPageList(pageSize,pageIndex,startTime,endTime,title,keyword,status,context());
    }
    @GET
    @Path("/wxlist")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u5FAE\u4FE1\u6D3B\u52A8\u4FE1\u606F\u5217\u8868", notes = "", response = SampleActivity.class, responseContainer = "List", tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6D3B\u52A8\u4FE1\u606F", response = SampleActivity.class, responseContainer = "List") })
    public Response getActivityWxList(@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA45\u6761") @QueryParam("num") Integer num,@ApiParam(value = "up:\u4E0A\u62C9(\u83B7\u53D6time\u4E4B\u524D) down:\u4E0B\u62C9(\u4ECE\u6700\u65B0num*20\u6761\u4E2D\u968F\u673A\u62BD\u53D6num\u6761).\u9ED8\u8BA4up") @QueryParam("upOrDown") String upOrDown,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("time") Long time,@ApiParam(value = "\u6D3B\u52A8\u6807\u9898") @QueryParam("title") String title,@ApiParam(value = "\u6D3B\u52A8\u5173\u952E\u5B57") @QueryParam("keyword") String keyword,@Context  SecurityContext securityContext){
        return service.getActivityWxList(num,upOrDown,time,title,keyword,context());
    }
    @GET
    @Path("/{autoId}/wx/signupinfo")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6D3B\u52A8\u62A5\u540D\u4FE1\u606F\uFF08\u5FAE\u4FE1\u7AEF\uFF09", notes = "", response = SignupWxInfo.class, responseContainer = "List", tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u62A5\u540D\u6D3B\u52A8\u6210\u529F", response = SignupWxInfo.class, responseContainer = "List") })
    public Response getSignupInfo(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA45\u6761") @QueryParam("num") Integer num,@ApiParam(value = "up:\u4E0A\u62C9(\u83B7\u53D6time\u4E4B\u524D) down:\u4E0B\u62C9(\u4ECE\u6700\u65B0num*20\u6761\u4E2D\u968F\u673A\u62BD\u53D6num\u6761).\u9ED8\u8BA4up") @QueryParam("upOrDown") String upOrDown,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("time") Long time,@Context  SecurityContext securityContext){
        return service.getSignupInfo(autoId,num,upOrDown,time,context());
    }
    @GET
    @Path("/{autoId}/web/signupinfo")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6D3B\u52A8\u62A5\u540D\u4FE1\u606F\uFF08\u540E\u53F0\uFF09", notes = "", response = PageData.class, responseContainer = "List", tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6D3B\u52A8\u62A5\u540D\u4FE1\u606F", response = PageData.class, responseContainer = "List") })
    public Response getSignupInfoPageList(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA410\u6761") @QueryParam("pageSize") Integer pageSize,@ApiParam(value = "\u8D77\u59CB\u9875.\u9ED8\u8BA41") @QueryParam("pageIndex") Integer pageIndex,@Context  SecurityContext securityContext){
        return service.getSignupInfoPageList(autoId,pageSize,pageIndex,context());
    }
    @PUT
    @Path("/{autoId}/publish")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u53D1\u5E03\u6D3B\u52A8\u4FE1\u606F\uFF08\u540E\u53F0\uFF09", notes = "", response = void.class, tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u53D1\u5E03\u6D3B\u52A8\u4FE1\u606F", response = void.class) })
    public Response publishActivity(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@Context  SecurityContext securityContext){
        return service.publishActivity(autoId,context());
    }
    @POST
    @Path("/{autoId}/wx/signupinfo")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u62A5\u540D\u6D3B\u52A8", notes = "", response = SignupWxInfo.class, tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u62A5\u540D\u6D3B\u52A8\u6210\u529F", response = SignupWxInfo.class) })
    public Response signupActivity(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@ApiParam(value = "\u6D3B\u52A8\u62A5\u540Dbody" ,required=true) SignupActivity signupinfo,@Context  SecurityContext securityContext){
        return service.signupActivity(autoId,signupinfo,context());
    }
    @PUT
    @Path("/{autoId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u4FEE\u6539\u6D3B\u52A8", notes = "", response = ActivityInfo.class, tags={ "activities(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6D3B\u52A8\u4FE1\u606F", response = ActivityInfo.class) })
    public Response updateActivity(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@ApiParam(value = "\u6D3B\u52A8\u4FE1\u606F" ,required=true) AddActivity activity,@Context  SecurityContext securityContext){
        return service.updateActivity(autoId,activity,context());
    }
}
