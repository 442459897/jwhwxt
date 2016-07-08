package com.muran.api.service.imp;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.service.ArticlesApiService;
import com.muran.dto.AddArticle;

@Service
public class ArticlesApiServiceImp implements ArticlesApiService {

	@Override
	public Response addArticle(AddArticle article, Context context) {
		// TODO Auto-generated method stub
		return null;
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
