package com.muran.api.service;

import javax.ws.rs.core.Response;

import com.muran.api.Context;
import com.muran.dto.AddActivity;
import com.muran.dto.SignupActivity;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public interface ActivitiesApiService {
    Response addActivity(AddActivity activity,Context context);
    Response backActivity(Long autoId,Context context);
    Response deleteActivity(Long autoId,Context context);
    Response getActivity(Long autoId,Context context);
    Response getActivityPageList(Integer pageSize,Integer pageIdex,Long startTime,Long endTime,String title,String keyword,String status,Context context);
    Response getActivityWxList(Integer num,String upOrDown,Long time,String title,String keyword,Context context);
    Response getSignupInfo(Long autoId,Integer num,String upOrDown,Long time,Context context);
    Response getSignupInfoPageList(Long autoId,Integer pageSize,Integer pageIdex,Context context);
    Response publishActivity(Long autoId,Context context);
    Response signupActivity(Long autoId,SignupActivity signupinfo,Context context);
    Response updateActivity(Long autoId,AddActivity activity,Context context);
    Response getSignupNum(Long autoId);
    Response getMySignup(Integer num,String upOrDown,Long time,Context context);
    Response getUserIsSignup(Long autoId,Context context);
}
