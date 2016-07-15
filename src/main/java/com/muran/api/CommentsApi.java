package com.muran.api;

import com.muran.dto.*;
import com.muran.api.service.CommentsApiService;
import com.muran.api.AbstractApi;
import io.swagger.annotations.ApiParam;

import com.muran.dto.CommentWxInfo;
import com.muran.dto.PageData;
import com.muran.dto.AddComment;

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

@Path("/comments")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the comments API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class CommentsApi extends AbstractApi {
    @Autowired
    CommentsApiService service;
    @PUT
    @Path("/{autoId}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u5BA1\u6838\u7559\u8A00\u8BC4\u8BBA\u4FE1\u606F", notes = "", response = void.class, tags={ "comments(留言评论相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u5BA1\u6838\u7559\u8A00\u8BC4\u8BBA\u6210\u529F", response = void.class) })
    public Response auditComment(@ApiParam(value = "\u7559\u8A00\u8BC4\u8BBAid",required=true) @PathParam("autoId") Long autoId,@ApiParam(value = "\u7559\u8A00\u8BC4\u8BBA\u5BA1\u6838\u72B6\u6001 0:\u5F85\u5BA1\u6838,1:\u5BA1\u6838\u901A\u8FC7,2:\u5BA1\u6838\u672A\u901A\u8FC7", required=true)@FormParam("status")  Long status,@Context  SecurityContext securityContext){
        return service.auditComment(autoId,status,context());
    }
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u7559\u8A00\u8BC4\u8BBA\u4FE1\u606F\uFF08\u5FAE\u4FE1\uFF09", notes = "", response = CommentWxInfo.class, responseContainer = "List", tags={ "comments(留言评论相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u7559\u8A00\u8BC4\u8BBA", response = CommentWxInfo.class, responseContainer = "List") })
    public Response getCommentInfo(@ApiParam(value = "\u9879\u76EE",required=true) @QueryParam("columnKey") String columnKey,@ApiParam(value = "\u9879\u76EE\u5BF9\u8C61",required=true) @QueryParam("itemId") Long itemId,@ApiParam(value = "\u83B7\u53D6\u6570\u91CF  \u9ED8\u8BA4\u4E3A5",required=true) @QueryParam("num") Long num,@ApiParam(value = "up:\u4E0A\u62C9(\u83B7\u53D6time\u4E4B\u524D) down:\u4E0B\u62C9(\u4ECE\u6700\u65B0num*20\u6761\u4E2D\u968F\u673A\u62BD\u53D6num\u6761).\u9ED8\u8BA4up") @QueryParam("upOrDown") String upOrDown,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("time") Long time,@Context  SecurityContext securityContext){
        return service.getCommentInfo(columnKey,itemId,num,upOrDown,time,context());
    }
    @GET
    @Path("/web")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u7559\u8A00\u8BC4\u8BBA\u4FE1\u606F\uFF08\u540E\u53F0\uFF09", notes = "", response = PageData.class, responseContainer = "List", tags={ "comments(留言评论相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u83B7\u53D6\u4FE1\u606F\u6210\u529F", response = PageData.class, responseContainer = "List") })
    public Response getCommentInfoPageList(@ApiParam(value = "\u9879\u76EE",required=true) @QueryParam("columnKey") String columnKey,@ApiParam(value = "\u9879\u76EE\u5BF9\u8C61",required=true) @QueryParam("itemId") Long itemId,@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA410\u6761",required=true) @QueryParam("pageSize") Integer pageSize,@ApiParam(value = "\u8D77\u59CB\u9875.\u9ED8\u8BA41",required=true) @QueryParam("pageIndex") Integer pageIndex,@ApiParam(value = "\u9879\u76EE\u5BF9\u8C61\u6807\u9898\u4FE1\u606F") @QueryParam("itemTitle") String itemTitle,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("startTime") Long startTime,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("endTime") Long endTime,@ApiParam(value = "\u72B6\u6001,0:\u5F85\u5BA1\u6838,1:\u5BA1\u6838\u901A\u8FC7,2:\u5BA1\u6838\u672A\u901A\u8FC7") @QueryParam("status") String status,@Context  SecurityContext securityContext){
        return service.getCommentInfoPageList(columnKey,itemId,pageSize,pageIndex,itemTitle,startTime,endTime,status,context());
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u63D0\u4EA4\u7559\u8A00\u8BC4\u8BBA\u4FE1\u606F", notes = "", response = void.class, tags={ "comments(留言评论相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u63D0\u4EA4\u7559\u8A00\u8BC4\u8BBA\u6210\u529F", response = void.class) })
    public Response submitComment(@ApiParam(value = "\u7559\u8A00\u8BC4\u8BBAbody" ,required=true) AddComment signupinfo,@Context  SecurityContext securityContext){
        return service.submitComment(signupinfo,context());
    }
}
