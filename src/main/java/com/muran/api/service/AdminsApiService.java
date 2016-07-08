package com.muran.api.service;

import com.muran.dto.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.muran.dto.AdminInfo;
import com.muran.dto.AddAdmin;
import com.muran.dto.PageData;

import java.util.List;

import java.io.InputStream;
import javax.ws.rs.core.Response;
import com.muran.api.Context;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public interface AdminsApiService {
    Response addAdmin(AddAdmin admin,Context context);
    Response deleteAdminInfo(Long autoId,Context context);
    Response getAdminInfo(Long autoId,Context context);
    Response getAdminPageList(Integer pageSize,Integer pageIdex,String name,Context context);
    Response updateAdmin(Long autoId,String name,Boolean gender,String mobile,String email,String idNumber,Context context);
}
