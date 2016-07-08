package com.muran.api;

import com.muran.dto.*;
import com.muran.api.service.ColumnsApiService;
import com.muran.api.AbstractApi;
import io.swagger.annotations.ApiParam;

import com.muran.dto.ColumnPosterInfo;
import com.muran.dto.Error;
import com.muran.dto.ColumnPosterInfoList;
import com.muran.dto.GeneralString;

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

@Path("/columns")
@Component
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the columns API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class ColumnsApi extends AbstractApi {
    @Autowired
    ColumnsApiService service;
    @GET
    @Path("/{columnKey}/posters")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u680F\u76EE\u6D77\u62A5\u4FE1\u606F", notes = "\u83B7\u53D6\u680F\u76EE\u6D77\u62A5\u4FE1\u606F", response = ColumnPosterInfo.class, tags={ "columns(栏目相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u680F\u76EE\u6D77\u62A5\u4FE1\u606F\u83B7\u53D6\u6210\u529F\u3002", response = ColumnPosterInfo.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "\u680F\u76EE\u6D77\u62A5\u4FE1\u606F\u83B7\u53D6\u5931\u8D25\u3002", response = ColumnPosterInfo.class) })
    public Response getColumnPosterInfo(@ApiParam(value = "\u680F\u76EE\u552F\u4E00key",required=true) @PathParam("columnKey") String columnKey,@Context  SecurityContext securityContext){
        return service.getColumnPosterInfo(columnKey,context());
    }
    @GET
    @Path("/posters")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u680F\u76EE\u6D77\u62A5\u4FE1\u606F", notes = "\u83B7\u53D6\u680F\u76EE\u6D77\u62A5\u4FE1\u606F\u5217\u8868", response = ColumnPosterInfoList.class, tags={ "columns(栏目相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u680F\u76EE\u6D77\u62A5\u4FE1\u606F\u83B7\u53D6\u6210\u529F\u3002", response = ColumnPosterInfoList.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "\u680F\u76EE\u6D77\u62A5\u4FE1\u606F\u83B7\u53D6\u5931\u8D25\u3002", response = ColumnPosterInfoList.class) })
    public Response getColumnPosterInfoList(@Context  SecurityContext securityContext){
        return service.getColumnPosterInfoList(context());
    }
    @GET
    @Path("/communities")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u5C0F\u533A\u6982\u51B5\u5730\u5740url", notes = "\u8BBE\u7F6E\u5C0F\u533A\u6982\u51B5\u7684\u5730\u5740\u4FE1\u606F", response = GeneralString.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u5C0F\u533A\u6982\u51B5\u5730\u5740url\u83B7\u53D6\u6210\u529F\u3002", response = GeneralString.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "\u5C0F\u533A\u6982\u51B5\u5730\u5740url\u83B7\u53D6\u5931\u8D25\u3002", response = GeneralString.class) })
    public Response getCommunityUrl(@Context  SecurityContext securityContext){
        return service.getCommunityUrl(context());
    }
    @PUT
    @Path("/{columnKey}/posters")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u680F\u76EE\u6D77\u62A5\u4FE1\u606F", notes = "\u8BBE\u7F6E\u680F\u76EE\u6D77\u62A5\u4FE1\u606F", response = GeneralString.class, tags={ "columns(栏目相关)", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u680F\u76EE\u6D77\u62A5\u8BBE\u7F6E\u6210\u529F\u3002", response = GeneralString.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "\u680F\u76EE\u6D77\u62A5\u8BBE\u7F6E\u5931\u8D25\u3002", response = GeneralString.class) })
    public Response setColumnPosterInfo(@ApiParam(value = "\u680F\u76EE\u552F\u4E00key",required=true) @PathParam("columnKey") String columnKey,@ApiParam(value = "\u662F\u5426\u663E\u793A\u6D77\u62A5", required=true)@FormParam("isShowPoster")  Boolean isShowPoster,@ApiParam(value = "\u6D77\u62A5url")@FormParam("posterUrl")  String posterUrl,@Context  SecurityContext securityContext){
        return service.setColumnPosterInfo(columnKey,isShowPoster,posterUrl,context());
    }
    @PUT
    @Path("/communities")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "\u5C0F\u533A\u6982\u51B5\u5730\u5740url", notes = "\u8BBE\u7F6E\u5C0F\u533A\u6982\u51B5\u7684\u5730\u5740\u4FE1\u606F", response = GeneralString.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "\u5C0F\u533A\u6982\u51B5\u5730\u5740\u8BBE\u7F6E\u6210\u529F\u3002", response = GeneralString.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "\u5C0F\u533A\u6982\u51B5\u5730\u5740\u8BBE\u7F6E\u5931\u8D25\u3002", response = GeneralString.class) })
    public Response setCommunityUrl(@ApiParam(value = "\u6D77\u62A5url", required=true)@FormParam("outUrl")  String outUrl,@Context  SecurityContext securityContext){
        return service.setCommunityUrl(outUrl,context());
    }
}
