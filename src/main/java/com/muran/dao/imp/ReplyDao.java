package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.IReplyDao;
import com.muran.model.Reply;
import com.muran.model.Role;

@SuppressWarnings("unchecked")
@Repository("ReplyDao")
public class ReplyDao extends AbstractHibernateDao<Reply> implements IReplyDao {

	public ReplyDao() {
		super();
		// TODO Auto-generated constructor stub
		setClazz(Reply.class);
	}

	@Override
	public List<Reply> getReplyList(Long type, Long message, Long status) {
		// TODO Auto-generated method stub
		String hql = " from Reply where 1=1 ";
		if (type != null) {
			hql += " and type=" + type;
		}
		if (message != null) {
			hql += " and message=" + message;
		}
		if (status != null) {
			hql += " and status=" + status;
		}
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

}
