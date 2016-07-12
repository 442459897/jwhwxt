package com.muran.dao.imp;

import org.springframework.stereotype.Repository;

import com.muran.dao.IArticleDao;
import com.muran.model.Article;

@SuppressWarnings("unchecked")
@Repository("ArticleDao")
public class ArticleDao extends AbstractHibernateDao<Article> implements
		IArticleDao {

	public ArticleDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(Article.class);
	}

}
