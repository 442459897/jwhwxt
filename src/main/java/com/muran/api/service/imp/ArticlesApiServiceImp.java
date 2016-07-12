package com.muran.api.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.ArticlesApiService;
import com.muran.dao.IArticleDao;
import com.muran.dao.IAttachDao;
import com.muran.dao.ICommentDao;
import com.muran.dto.AddArticle;
import com.muran.dto.ArticleInfo;
import com.muran.model.Article;
import com.muran.model.Attach;
import com.muran.model.Comment;
import com.muran.util.CommonUtil;
import com.muran.util.Data;

@Service
public class ArticlesApiServiceImp implements ArticlesApiService {

	@Resource(name = "ArticleDao")
	private IArticleDao dao;

	@Resource(name = "AttachDao")
	private IAttachDao attachDao;

	@Resource(name = "CommentDao")
	private ICommentDao commentDao;

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
		dao.deleteById(articleId);
		return Response.ok().build();
	}

	@Override
	public Response getArticleContent(Long articleId, Context context) {
		// TODO Auto-generated method stub
		Article article = dao.findOne(articleId);
		return Response.ok().entity(article).build();
	}

	@Override
	public Response getArticles(Integer num, String upOrDown, Long time,
			String columnKey, String title, String keyword, String source,
			String status, Context context) {
		// TODO Auto-generated method stub
		List<Article> list = dao.getWxArticleList(num, upOrDown, time,
				columnKey, title, keyword, source, status);

		List<ArticleInfo> list2 = new ArrayList<ArticleInfo>();

		if (list != null && !list.isEmpty()) {
			for (Article article : list) {
				ArticleInfo info = new ArticleInfo();
				info.setAutoId(article.getAutoId());
				info.setCommentNum(0l);
				info.setContent("");
				info.setCoverUrl(CommonUtil.getByStringSplit(
						article.getCoverUrl(), ","));
				info.setPublishTime(article.getPublishTime());
				info.setShowType(article.getShowType());
				info.setSource(article.getSource());
				info.setTime(article.getPublishTime().getTime());
				info.setTitle(article.getTitle());
				info.setVideoUrl(article.getVideoUrl());
				list2.add(info);
			}
		}
		return Response.ok().entity(list2).build();
	}

	@Override
	public Response getArticlesKeywords(String columnKey, Context context) {
		// TODO Auto-generated method stub
		List<Article> list = dao.getRandomList(columnKey, 6);
		List<String> list2 = new ArrayList<String>();
		if (list != null && !list.isEmpty()) {
			for (Article article : list) {
				list2.addAll(CommonUtil.getByStrings(article.getKeywords(), ","));
			}
		}
		if (list2 != null && list2.size() > 6) {
			list2 = list2.subList(0, 6);
		}
		return Response.ok().entity(list2).build();
	}

	@Override
	public Response getArticlesPageList(Integer pageSize, Integer pageIdex,
			Long startTime, Long endTime, String columnKey, String title,
			String keyword, String source, String status, Context context) {
		// TODO Auto-generated method stub
		Data<Article> data = dao.getArticlesPageList(pageSize, pageIdex,
				startTime, endTime, columnKey, title, keyword, source, status);
		return Response.ok().entity(data).build();
	}

	@Override
	public Response updateArticle(Long articleId, AddArticle article,
			Context context) {
		// TODO Auto-generated method stub
		Article articleInfo = new Article();
		articleInfo = dao.findOne(articleId);
		if (articleInfo == null) {
			throw new ServerException(Code.BadRequestParams, "资讯信息不不能在！");
		}
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
		articleInfo = dao.update(articleInfo);

		return Response.ok().build();
	}

	@Override
	public Response backArticle(Long autoId, Context context) {
		// TODO Auto-generated method stub
		Article articleInfo = new Article();
		articleInfo = dao.findOne(autoId);
		if (articleInfo == null) {
			throw new ServerException(Code.BadRequestParams, "资讯信息不不能在！");
		}
		articleInfo.setBackMan(context.getUsername());
		articleInfo.setBackTime(new Date());
		articleInfo.setStatus(2l);
		dao.update(articleInfo);
		return Response.ok().build();
	}

	@Override
	public Response publishArticle(Long autoId, Context context) {
		// TODO Auto-generated method stub
		Article articleInfo = new Article();
		articleInfo = dao.findOne(autoId);
		if (articleInfo == null) {
			throw new ServerException(Code.BadRequestParams, "资讯信息不不能在！");
		}
		articleInfo.setPublishMan(context.getUsername());
		articleInfo.setPublishTime(new Date());
		articleInfo.setStatus(1l);
		dao.update(articleInfo);
		return Response.ok().build();
	}

	@Override
	public Response getArticleWxContent(Long articleId, Context context) {
		// TODO Auto-generated method stub
		Article articleInfo = new Article();
		articleInfo = dao.findOne(articleId);
		if (articleInfo == null) {
			throw new ServerException(Code.BadRequestParams, "资讯信息不不能在！");
		}
		ArticleInfo article = new ArticleInfo();
		article.setAutoId(articleInfo.getAutoId());

		article.setContent(articleInfo.getContent());
		article.setCoverUrl(CommonUtil.getByStringSplit(
				articleInfo.getCoverUrl(), ","));
		article.setPublishTime(articleInfo.getPublishTime());
		article.setShowType(articleInfo.getShowType());
		article.setSource(articleInfo.getSource());
		article.setTime(articleInfo.getPublishTime().getTime());
		article.setTitle(articleInfo.getTitle());
		article.setVideoUrl(articleInfo.getVideoUrl());

		// 获取评论数量
		List<Comment> list = new ArrayList<Comment>();
		list = commentDao.getList(articleInfo.getColumeKey(), articleId, 1l);
		long num = list == null ? 0 : list.size();

		article.setCommentNum(num);

		return Response.ok().entity(article).build();
	}

}
