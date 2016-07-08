package com.muran.api.service;

import com.muran.dto.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.muran.dto.CommentWxInfo;
import com.muran.dto.PageData;
import com.muran.dto.AddComment;

import java.util.List;

import java.io.InputStream;
import javax.ws.rs.core.Response;
import com.muran.api.Context;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public interface CommentsApiService {
    Response auditComment(Long autoId,Long status,Context context);
    Response getCommentInfo(String columnKey,Long itemId,Long num,String upOrDown,Long time,Context context);
    Response getCommentInfoPageList(String columnKey,Long itemId,Integer pageSize,Integer pageIdex,String itemTitle,Long startTime,Long endTime,String status,Context context);
    Response submitComment(AddComment signupinfo,Context context);
}
