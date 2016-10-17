package com.muran.api.service;

import com.muran.dto.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.muran.dto.ColumnPosterInfo;
import com.muran.dto.Error;
import com.muran.dto.ColumnPosterInfoList;
import com.muran.dto.GeneralString;

import java.util.List;

import java.io.InputStream;
import javax.ws.rs.core.Response;

import com.muran.api.Context;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public interface ColumnsApiService {
    Response getColumnPosterInfo(String columnKey, Context context);

    Response getColumnPosterInfoList(Context context);

    Response getCommunityUrl(Context context);

    Response setColumnPosterInfo(String columnKey, Boolean isShowPoster, String posterUrl, String posterImageUrl, Context context);

    Response setCommunityUrl(String outUrl, Context context);

    Response getColumnConfigList();

    Response updateColumnConfig(Long autoId, Boolean bool);
}
