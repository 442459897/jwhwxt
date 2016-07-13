package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.imp.AbstractHibernateDao;
import com.muran.model.ColumnItem;
import com.muran.dao.IColumnItemDao;

@Repository("ColumnItemDao")
@SuppressWarnings("unchecked")
public class ColumnItemDao extends AbstractHibernateDao<ColumnItem> implements
		IColumnItemDao {
	public ColumnItemDao() {
		super();
		setClazz(ColumnItem.class);
	}

	@Override
	public List<ColumnItem> getList(Long parentId) {
		// TODO Auto-generated method stub
		String hql = " from ColumnItem where 1=1 ";
		if (parentId != null) {
			hql += " and parentId=" + parentId;
		}
		hql += " order by autoId asc";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public ColumnItem getColumnItemByKey(String columnKey) {
		// TODO Auto-generated method stub
		String hql = " from ColumnItem where columnKey='" + columnKey + "'";
		Query query = getCurrentSession().createQuery(hql);
		List<ColumnItem> list = query.list();
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public List<ColumnItem> getPosterColumnList() {
		// TODO Auto-generated method stub
		String hql = " from ColumnItem where isPoster=1 ";
		hql += " order by autoId asc";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}
}
