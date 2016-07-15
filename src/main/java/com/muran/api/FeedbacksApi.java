package com.muran.api;

import com.muran.dto.*;
import com.muran.api.service.FeedbacksApiService;
import com.muran.api.AbstractApi;
import io.swagger.annotations.ApiParam;

import com.muran.dto.FeedBackInfo;
import com.muran.dto.PageData;
import com.muran.dto.AddFeedback;

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

@Path("/feedbacks")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the feedbacks API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class FeedbacksApi extends AbstractApi {
    @Autowired
    FeedbacksApiService service;
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u67E5\u8BE2\u6211\u6709\u8BDD\u8BF4(\u5FAE\u4FE1\u7AEF)", notes = "", response = FeedBackInfo.class, responseContainer = "List", tags={ "replies(我有话说相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u4FE1\u606F\u6210\u529F", response = FeedBackInfo.class, responseContainer = "List") })
    public Response getFeedbackInfo(@ApiParam(value = "\u83B7\u53D6\u6570\u91CF  \u9ED8\u8BA4\u4E3A5",required=true) @QueryParam("num") Long num,@ApiParam(value = "up:\u4E0A\u62C9(\u83B7\u53D6time\u4E4B\u524D) down:\u4E0B\u62C9(\u4ECE\u6700\u65B0num*20\u6761\u4E2D\u968F\u673A\u62BD\u53D6num\u6761).\u9ED8\u8BA4up") @QueryParam("upOrDown") String upOrDown,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("time") Long time,@Context  SecurityContext securityContext){
        return service.getFeedbackInfo(num,upOrDown,time,context());
    }
    @GET
    @Path("/web")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u67E5\u8BE2\u6211\u6709\u8BDD\u8BF4(\u5FAE\u4FE1\u7AEF)", notes = "", response = PageData.class, responseContainer = "List", tags={ "replies(我有话说相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u4FE1\u606F\u6210\u529F", response = PageData.class, responseContainer = "List") })
    public Response getFeedbackInfoPageList(@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA410\u6761",required=true) @QueryParam("pageSize") Integer pageSize,@ApiParam(value = "\u8D77\u59CB\u9875.\u9ED8\u8BA41",required=true) @QueryParam("pageIndex") Integer pageIndex,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("startTime") Long startTime,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("endTime") Long endTime,@Context  SecurityContext securityContext){
        return service.getFeedbackInfoPageList(pageSize,pageIndex,startTime,endTime,context());
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u63D0\u4EA4\u6211\u6709\u8BDD\u8BF4", notes = "", response = void.class, tags={ "replies(我有话说相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u63D0\u4EA4\u6210\u529F", response = void.class) })
    public Response submitFeedback(@ApiParam(value = "\u6211\u6709\u8BDD\u8BF4body" ,required=true) AddFeedback feedback,@Context  SecurityContext securityContext){
        return service.submitFeedback(feedback,context());
    }
}
