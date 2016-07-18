package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.muran.dao.IArticleDao;
import com.muran.model.Article;
import com.muran.util.Data;
import com.muran.util.DateUtil;

@SuppressWarnings("unchecked")
@Repository("ArticleDao")
public class ArticleDao extends AbstractHibernateDao<Article> implements
		IArticleDao {

	public ArticleDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(Article.class);
	}

	@Override
	public List<Article> getWxArticleList(Integer num, String upOrDown,
			Long time, String columnKey, String title, String keyword,
			String source, String status) {
		// TODO Auto-generated method stub
		String hql = " from Article where 1=1 ";
		if (columnKey != null && !columnKey.equals("")) {
			hql += " and columnKey='" + columnKey + "'";
		}
		if (title != null && !title.equals("")) {
			hql += " and title like '%" + title + "%'";
		}
		if (keyword != null && !keyword.equals("")) {
			hql += " and keywords like '%" + keyword + "%'";
		}
		if (source != null && !source.equals("")) {
			hql += " and source like '%" + source + "%'";
		}
		// if (status != null && !status.equals("")) {
		hql += " and status=1";
		// }else{
		//
		// }
		if (num == null) {
			num = 8;
		}
		if (upOrDown == null) {
			upOrDown = "down";
		}
		if (upOrDown.equals("down")) {
			if (time != null) {
				hql += " and publishTime > '"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			}

		}
		if (upOrDown.equals("up")) {
			if (time != null) {
				hql += " and publishTime < '"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			}
		}
		hql += " order by publishTime desc ";
		Query query = getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(num);

		return query.list();
	}

	@Override
	public List<Article> getRandomList(String columnKey, int num) {
		// TODO Auto-generated method stub
		String hql = " from Article where 1=1 ";
		if (columnKey != null && !columnKey.equals("")) {
			hql += " and columnKey='" + columnKey + "'";
		}
		hql += " order by rand() ";
		Query query = getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(num);

		return query.list();
	}

	@Override
	public Data<Article> getArticlesPageList(Integer pageSize,
			Integer pageIndex, Long startTime, Long endTime, String columnKey,
			String title, String keyword, String source, String status) {
		// TODO Auto-generated method stub
		String hql = " from Article where 1=1 ";
		if (columnKey != null && !columnKey.equals("")) {
			hql += " and columnKey='" + columnKey + "'";
		}
		if (startTime != null) {
			hql += " and modifyTime >='"
					+ DateUtil.timestampToDateStr(startTime.toString()) + "'";
		}
		if (endTime != null) {
			hql += " and modifyTime <='"
					+ DateUtil.timestampToDateStr(endTime.toString()) + "'";
		}
		if (title != null && !title.equals("")) {
			hql += " and title like '%" + title + "%'";
		}
		if (keyword != null && !keyword.equals("")) {
			hql += " and keywords like '%" + keyword + "%'";
		}
		if (source != null && !source.equals("")) {
			hql += " and source like '%" + source + "%'";
		}
		if (status != null && !status.equals("")) {
			hql += " and status='" + status + "'";
		}
		hql += " order by createTime desc,publishTime desc ";
		Query query = getCurrentSession().createQuery(hql);
		List<Article> list = query.list();

		Data<Article> data = new Data<Article>();

		int totalRecord = list.size();
		query.setFirstResult((pageIndex - 1) * pageSize);
		query.setMaxResults(pageSize);
		list = query.list();

		data.setPageIndex(pageIndex);
		data.setPageSize(pageSize);
		data.setTotalRecord(totalRecord);

		data.setData(list);

		return data;
	}

}
