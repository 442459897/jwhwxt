package com.muran.api.service;

import com.muran.dto.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.muran.dto.FeedBackInfo;
import com.muran.dto.PageData;
import com.muran.dto.AddFeedback;

import java.util.List;

import java.io.InputStream;
import javax.ws.rs.core.Response;
import com.muran.api.Context;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public interface FeedbacksApiService {
    Response getFeedbackInfo(Long num,String upOrDown,Long time,Context context);
    Response getFeedbackInfoPageList(Integer pageSize,Integer pageIdex,Long startTime,Long endTime,Context context);
    Response submitFeedback(AddFeedback feedback,Context context);
}
