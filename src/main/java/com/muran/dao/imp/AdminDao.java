package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.muran.model.Admin;
import com.muran.util.Data;
import com.muran.dao.IAdminDao;

@SuppressWarnings("unchecked")
@Repository("AdminDao")
public class AdminDao extends AbstractHibernateDao<Admin> implements IAdminDao {

	public AdminDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(Admin.class);
	}

	@Override
	public Data<Admin> getAdminPageList(Integer pageSize, Integer pageIndex,
			String name) {
		// TODO Auto-generated method stub
		String hql = " from Admin where 1=1 ";
		if (name != null && !name.equals("")) {
			hql += " and name like '%" + name + "%'";
		}
		Query query = getCurrentSession().createQuery(hql);
		//.setResultTransformer(Transformers.aliasToBean(Admin.class))
		List<Admin> list = query.list();

		Data<Admin> data = new Data<Admin>();

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
