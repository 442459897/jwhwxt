package com.muran.api.service;

import com.muran.dto.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.muran.dto.AddArticle;
import com.muran.dto.ArticleInfo;
import com.muran.dto.GeneralString;
import com.muran.dto.PageData;

import java.util.List;

import java.io.InputStream;
import javax.ws.rs.core.Response;
import com.muran.api.Context;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public interface ArticlesApiService {
    Response addArticle(AddArticle article,Context context);
    Response backArticle(Long autoId,Context context);
    Response deleteArticle(Long articleId,Context context);
    Response getArticleContent(Long articleId,Context context);
    Response getArticles(Integer num,String upOrDown,Long time,String columnKey,String title,String keyword,String source,String status,Context context);
    Response getArticlesKeywords(String columnKey,Context context);
    Response getArticlesPageList(Integer pageSize,Integer pageIdex,Long startTime,Long endTime,String columnKey,String title,String keyword,String source,String status,Context context);
    Response publishArticle(Long autoId,Context context);
    Response updateArticle(Long articleId,AddArticle article,Context context);
    Response getArticleWxContent(Long articleId,Context context);
}
