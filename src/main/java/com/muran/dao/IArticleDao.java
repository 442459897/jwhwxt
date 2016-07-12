package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.Article;
import com.muran.util.Data;

public interface IArticleDao extends IOperations<Article> {

	public List<Article> getWxArticleList(Integer num, String upOrDown,
			Long time, String columnKey, String title, String keyword,
			String source, String status);

	public List<Article> getRandomList(String columnKey, int num);

	public Data<Article> getArticlesPageList(Integer pageSize,
			Integer pageIdex, Long startTime, Long endTime, String columnKey,
			String title, String keyword, String source, String status);
}
