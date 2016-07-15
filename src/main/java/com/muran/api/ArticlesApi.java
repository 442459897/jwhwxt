package com.muran.api;

import com.muran.dto.*;
import com.muran.api.service.ArticlesApiService;
import com.muran.api.AbstractApi;
import io.swagger.annotations.ApiParam;

import com.muran.dto.AddArticle;
import com.muran.dto.ArticleInfo;
import com.muran.dto.GeneralString;
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

@Path("/articles")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the articles API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class ArticlesApi extends AbstractApi {
    @Autowired
    ArticlesApiService service;
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u6DFB\u52A0\u6587\u7AE0", notes = "", response = ArticleInfo.class, tags={ "article(文章相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6587\u7AE0\u4FE1\u606F", response = ArticleInfo.class) })
    public Response addArticle(@ApiParam(value = "\u6587\u7AE0body" ,required=true) AddArticle article,@Context  SecurityContext securityContext){
        return service.addArticle(article,context());
    }
    @PUT
    @Path("/{autoId}/back")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u6536\u56DE\u8D44\u8BAF\u4FE1\u606F\uFF08\u540E\u53F0\uFF09", notes = "", response = void.class, tags={ "article(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6536\u56DE\u8D44\u8BAF\u4FE1\u606F", response = void.class) })
    public Response backArticle(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@Context  SecurityContext securityContext){
        return service.backArticle(autoId,context());
    }
    @DELETE
    @Path("/{articleId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u5220\u9664\u6587\u7AE0", notes = "", response = void.class, tags={ "article(文章相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u5220\u9664\u6210\u529F", response = void.class) })
    public Response deleteArticle(@ApiParam(value = "\u6587\u7AE0id",required=true) @PathParam("articleId") Long articleId,@Context  SecurityContext securityContext){
        return service.deleteArticle(articleId,context());
    }
    @GET
    @Path("/{articleId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6587\u7AE0\u5185\u5BB9", notes = "", response = ArticleInfo.class, responseContainer = "List", tags={ "article(文章相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6587\u7AE0\u5185\u5BB9", response = ArticleInfo.class, responseContainer = "List") })
    public Response getArticleContent(@ApiParam(value = "\u6587\u7AE0id",required=true) @PathParam("articleId") Long articleId,@Context  SecurityContext securityContext){
        return service.getArticleContent(articleId,context());
    }
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6587\u7AE0\u5217\u8868", notes = "", response = ArticleInfo.class, responseContainer = "List", tags={ "article(文章相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6587\u7AE0\u5217\u8868", response = ArticleInfo.class, responseContainer = "List") })
    public Response getArticles(@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA45\u6761") @QueryParam("num") Integer num,@ApiParam(value = "up:\u4E0A\u62C9(\u83B7\u53D6time\u4E4B\u524D) down:\u4E0B\u62C9(\u4ECE\u6700\u65B0num*20\u6761\u4E2D\u968F\u673A\u62BD\u53D6num\u6761).\u9ED8\u8BA4up") @QueryParam("upOrDown") String upOrDown,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("time") Long time,@ApiParam(value = "\u680F\u76EE\u552F\u4E00key") @QueryParam("columnKey") String columnKey,@ApiParam(value = "\u6587\u7AE0\u6807\u9898") @QueryParam("title") String title,@ApiParam(value = "\u6587\u7AE0\u5173\u952E\u5B57") @QueryParam("keyword") String keyword,@ApiParam(value = "\u6587\u7AE0\u6765\u6E90") @QueryParam("source") String source,@ApiParam(value = "\u72B6\u6001,0:\u672A\u53D1\u5E03,1:\u5DF2\u53D1\u5E03,2:\u6536\u56DE") @QueryParam("status") String status,@Context  SecurityContext securityContext){
        return service.getArticles(num,upOrDown,time,columnKey,title,keyword,source,status,context());
    }
    @GET
    @Path("/{columnKey}/keywords")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6587\u7AE0\u8D44\u8BAF\u7684\u641C\u7D22\u5173\u952E\u5B57", notes = "", response = GeneralString.class, responseContainer = "List", tags={ "article(搜索关键字相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6587\u7AE0\u5217\u8868", response = GeneralString.class, responseContainer = "List") })
    public Response getArticlesKeywords(@ApiParam(value = "",required=true) @PathParam("columnKey") String columnKey,@Context  SecurityContext securityContext){
        return service.getArticlesKeywords(columnKey,context());
    }
    @GET
    @Path("/web/list")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u83B7\u53D6\u6587\u7AE0\u5217\u8868", notes = "", response = PageData.class, responseContainer = "List", tags={ "article(文章相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6587\u7AE0\u5217\u8868", response = PageData.class, responseContainer = "List") })
    public Response getArticlesPageList(@ApiParam(value = "\u83B7\u53D6\u7684\u6570\u91CF.\u9ED8\u8BA410\u6761") @QueryParam("pageSize") Integer pageSize,@ApiParam(value = "\u8D77\u59CB\u9875.\u9ED8\u8BA41") @QueryParam("pageIndex") Integer pageIndex,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("startTime") Long startTime,@ApiParam(value = "\u65F6\u95F4(\u5FAE\u79D2,eg:1464110904319937).\u9ED8\u8BA4\u5F53\u524D\u65F6\u95F4") @QueryParam("endTime") Long endTime,@ApiParam(value = "\u680F\u76EE\u552F\u4E00key") @QueryParam("columnKey") String columnKey,@ApiParam(value = "\u6587\u7AE0\u6807\u9898") @QueryParam("title") String title,@ApiParam(value = "\u6587\u7AE0\u5173\u952E\u5B57") @QueryParam("keyword") String keyword,@ApiParam(value = "\u6587\u7AE0\u6765\u6E90") @QueryParam("source") String source,@ApiParam(value = "\u72B6\u6001,0:\u672A\u53D1\u5E03,1:\u5DF2\u53D1\u5E03,2:\u6536\u56DE") @QueryParam("status") String status,@Context  SecurityContext securityContext){
        return service.getArticlesPageList(pageSize,pageIndex,startTime,endTime,columnKey,title,keyword,source,status,context());
    }
    @PUT
    @Path("/{autoId}/publish")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u53D1\u5E03\u8D44\u8BAF\u4FE1\u606F\uFF08\u540E\u53F0\uFF09", notes = "", response = void.class, tags={ "article(活动相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u53D1\u5E03\u8D44\u8BAF\u4FE1\u606F", response = void.class) })
    public Response publishArticle(@ApiParam(value = "\u6D3B\u52A8id",required=true) @PathParam("autoId") Long autoId,@Context  SecurityContext securityContext){
        return service.publishArticle(autoId,context());
    }
    @PUT
    @Path("/{articleId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u4FEE\u6539\u6587\u7AE0", notes = "", response = ArticleInfo.class, tags={ "article(文章相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u6587\u7AE0\u4FE1\u606F", response = ArticleInfo.class) })
    public Response updateArticle(@ApiParam(value = "\u6587\u7AE0id",required=true) @PathParam("articleId") Long articleId,@ApiParam(value = "\u6587\u7AE0body" ,required=true) AddArticle article,@Context  SecurityContext securityContext){
        return service.updateArticle(articleId,article,context());
    }
}
