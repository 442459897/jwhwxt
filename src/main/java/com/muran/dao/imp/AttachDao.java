package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.IAttachDao;
import com.muran.model.Attach;

@SuppressWarnings("unchecked")
@Repository("AttachDao")
public class AttachDao extends AbstractHibernateDao<Attach> implements
		IAttachDao {

	public AttachDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(Attach.class);
	}

	@Override
	public List<Attach> getList(String columnKey, Long itemId) {
		// TODO Auto-generated method stub
		String hql = " from Attach where 1=1 ";
		if (columnKey != null && !columnKey.equals("")) {
			hql += " and columnKey='" + columnKey + "'";
		}
		if (itemId != null) {
			hql += " and itemId=" + itemId;
		}
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

}
