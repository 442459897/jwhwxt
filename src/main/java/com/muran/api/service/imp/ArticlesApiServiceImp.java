package com.muran.api.service.imp;

import java.util.Date;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.service.ArticlesApiService;
import com.muran.dao.IArticleDao;
import com.muran.dao.IAttachDao;
import com.muran.dto.AddArticle;
import com.muran.model.Article;
import com.muran.model.Attach;

@Service
public class ArticlesApiServiceImp implements ArticlesApiService {

	@Resource(name = "ArticleDao")
	private IArticleDao dao;

	@Resource(name = "AttachDao")
	private IAttachDao attachDao;

	@Override
	public Response addArticle(AddArticle article, Context context) {

		// TODO Auto-generated method stub
		Article articleInfo = new Article();
		articleInfo.setColumeKey(article.getColumeKey());
		articleInfo.setContent(article.getContent());
		articleInfo.setCoverUrl(StringUtils.join(article.getCoverUrl()
				.toArray(), ','));
		articleInfo.setCreateMan(context.getUsername());
		articleInfo.setCreateTime(new Date());
		articleInfo.setEnable(true);
		articleInfo.setKeywords(article.getKeyword());
		articleInfo.setModifyMan(context.getUsername());
		articleInfo.setModifyTime(new Date());
		if (article.getStatus() == 1) {
			articleInfo.setPublishMan(context.getUsername());
			articleInfo.setPublishTime(new Date());
		}
		articleInfo.setShowType(article.getShowType());
		articleInfo.setSource(article.getSource());
		articleInfo.setTitle(article.getTitle());
		articleInfo.setVideoUrl(article.getVideoUrl());
		articleInfo.setWriter(article.getWriter());
		articleInfo.setStatus(article.getStatus());
		articleInfo = dao.merge(articleInfo);

		// 新增附件
		String[] array = article.getAttachUrl().split(",");
		for (int i = 0; i < array.length; i++) {
			Attach attach = new Attach();
			attach.setColumnKey(article.getColumeKey());
			attach.setEnable(true);
			attach.setExtension("");
			attach.setItemId(articleInfo.getAutoId());
			attach.setUrl(array[i]);
			attachDao.merge(attach);
		}
		return Response.ok().entity(articleInfo).build();
	}

	@Override
	public Response deleteArticle(Long articleId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getArticleContent(Long articleId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getArticles(Integer num, String upOrDown, Long time,
			String columnKey, String title, String keyword, String source,
			String status, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getArticlesKeywords(String columnKey, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getArticlesPageList(Integer pageSize, Integer pageIdex,
			Long startTime, Long endTime, String columnKey, String title,
			String keyword, String source, String status, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateArticle(Long articleId, AddArticle article,
			Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response backArticle(Long autoId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response publishArticle(Long autoId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
