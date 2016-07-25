package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.ICommentDao;
import com.muran.model.Admin;
import com.muran.model.Comment;
import com.muran.util.Data;
import com.muran.util.DateUtil;

@SuppressWarnings("unchecked")
@Repository("CommentDao")
public class CommentDao extends AbstractHibernateDao<Comment> implements
		ICommentDao {

	public CommentDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(Comment.class);
	}

	@Override
	public List<Comment> getList(String columnKey, Long itemId, Long status) {
		// TODO Auto-generated method stub
		String hql = " from Comment where 1=1 ";
		if (columnKey != null && !columnKey.equals("")) {
			hql += " and columnKey='" + columnKey + "'";
		}
		if (itemId != null) {
			hql += " and itemId=" + itemId;
		}
		if (status != null) {
			hql += " and status=" + status;
		}
		hql += " order by commentTime desc ";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<Comment> getList(String columnKey, Long itemId, Long num,
			String upOrDown, Long time, Long status) {
		// TODO Auto-generated method stub
		String hql = " from Comment where 1=1 ";
		if (columnKey != null && !columnKey.equals("")) {
			hql += " and columnKey='" + columnKey + "'";
		}
		if (num == null) {
			num = 5l;
		}
		if (itemId != null) {
			hql += " and itemId=" + itemId;
		}
		if (status != null) {
			hql += " and status=" + status;
		}
		if (upOrDown == null || upOrDown.equals("")) {
			upOrDown = "down";
		}
		if (upOrDown.equals("up")) {
			if (time != null) {
				hql += " and commentTime <'"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			}

		} else if (upOrDown.equals("down")) {
			if (time != null) {
				hql += " and commentTime >'"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			}
		}
		hql += " order by commentTime desc ";
		Query query = getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(Integer.valueOf(num.toString()));

		return query.list();
	}

	@Override
	public Data<Comment> getCommentInfoPageList(String columnKey, Long itemId,
			Integer pageSize, Integer pageIdex, String itemTitle,
			Long startTime, Long endTime, String status) {
		// TODO Auto-generated method stub
		String hql = " from Comment where 1=1 ";
		if (columnKey != null && !columnKey.equals("")) {
			hql += " and columnKey='" + columnKey + "'";
		}
		if (itemTitle != null && !itemTitle.equals("")) {
			hql += " and content like '%" + itemTitle + "%'";
		}
		if (startTime != null) {
			hql += " and commentTime >='"
					+ DateUtil.timestampToDateStr(startTime.toString()) + "'";
		}
		if (endTime != null) {
			hql += " and commentTime <='"
					+ DateUtil.timestampToDateStr(endTime.toString()) + "'";
		}
		if (status != null) {
			hql += " and status=" + status;
		}
		hql += " order by commentTime desc ";
		Query query = getCurrentSession().createQuery(hql);

		List<Comment> list = query.list();

		Data<Comment> data = new Data<Comment>();

		int totalRecord = list.size();
		query.setFirstResult((pageIdex - 1) * pageSize);
		query.setMaxResults(pageSize);
		list = query.list();

		data.setPageIndex(pageIdex);
		data.setPageSize(pageSize);
		data.setTotalRecord(totalRecord);

		data.setData(list);

		return data;
	}

	@Override
	public void deleteComment(String columnKey, Long itemId) {
		// TODO Auto-generated method stub
		String hql = " delete Comment where columnKey='" + columnKey
				+ "' and itemId=" + itemId;
		getCurrentSession().createQuery(hql).executeUpdate();
	}

}
