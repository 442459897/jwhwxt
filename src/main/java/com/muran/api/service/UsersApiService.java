package com.muran.api.service;

import com.muran.dto.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.muran.dto.LoginInfo;

import java.util.List;

import java.io.InputStream;
import javax.ws.rs.core.Response;
import com.muran.api.Context;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public interface UsersApiService {
    Response login(String username,String pwd,Context context);
    Response modifyPwd(String username,String pwd,Context context);
    Response resetPwd(String username,String pwd,Context context);
}
