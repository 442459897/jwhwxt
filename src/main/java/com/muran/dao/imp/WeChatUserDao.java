package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.IWeChatUserDao;
import com.muran.model.WeChatUser;

@Repository("WeChatUserDao")
@SuppressWarnings("unchecked")
public class WeChatUserDao extends AbstractHibernateDao<WeChatUser> implements
		IWeChatUserDao {

	@Override
	public WeChatUser getBySessionId(String sessionId) {
		// TODO Auto-generated method stub
		String hql = " from WeChatUser where sessionId='" + sessionId + "'";
		Query query = getCurrentSession().createQuery(hql);
		List<WeChatUser> list = query.list();
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public WeChatUser getByOpenId(String openId) {
		// TODO Auto-generated method stub
		String hql = " from WeChatUser where openId='" + openId + "'";
		Query query = getCurrentSession().createQuery(hql);
		List<WeChatUser> list = query.list();
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

}
