package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.IActivitySignUpDao;
import com.muran.model.ActivitySignup;
import com.muran.util.Data;

/**
 * @author jerry.zheng
 * @version 创建时间：2016年7月12日 下午4:13:50 类说明
 */
@SuppressWarnings("unchecked")
@Repository("ActivitySignupDao")
public class ActivitySignupDao extends AbstractHibernateDao<ActivitySignup>
		implements IActivitySignUpDao {

	public ActivitySignupDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(ActivitySignup.class);
	}

	@Override
	public int getSignUpNum(Long autoId) {
		// TODO Auto-generated method stub
		String hql = " from ActivitySignup where 1=1 ";
		if (autoId != null) {
			hql += " and activity =" + autoId;
		}

		Query query = getCurrentSession().createQuery(hql);
		List<ActivitySignup> list = query.list();
		if (list != null && list.size() > 0) {
			return list.size();
		}
		return 0;
	}

	@Override
	public ActivitySignup getOneByOpenId(Long activity, String openid) {
		String hql = " from ActivitySignup where 1=1 ";
		if (openid != null && openid != "") {
			hql += " and openId ='" + openid + "'";
		}
		if (activity != null) {
			hql += " and activity =" + activity;
		}
		Query query = getCurrentSession().createQuery(hql);
		List<ActivitySignup> list = query.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Data<ActivitySignup> getActivitySignupPageList(Long autoId,
			Integer pageSize, Integer pageIndex) {
		// TODO Auto-generated method stub
		String hql = " from ActivitySignup where 1=1 ";

		if (autoId != null) {
			hql += " and activity =" + autoId;
		}
		Query query = getCurrentSession().createQuery(hql);
		List<ActivitySignup> list = query.list();

		Data<ActivitySignup> data = new Data<ActivitySignup>();

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

	@Override
	public List<ActivitySignup> getListByOpenId(String openid) {
		String hql = " from ActivitySignup where 1=1 ";
		if (openid != null && openid != "") {
			hql += " and openId ='" + openid + "'";
		}
		Query query = getCurrentSession().createQuery(hql);
		List<ActivitySignup> list = query.list();
		return list;
	}
}
