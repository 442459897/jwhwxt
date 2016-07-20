/**
 * 
 */
package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;

import com.muran.dao.imp.AbstractHibernateDao;
import com.muran.dao.IUserMenuGroupDao;
import com.muran.model.UserMenuGroup;

/**
 * @author wxz
 * 
 */
@SuppressWarnings("unchecked")
public class UserMenuGroupDao extends AbstractHibernateDao<UserMenuGroup>
		implements IUserMenuGroupDao {

	public UserMenuGroupDao() {
		super();
		setClazz(UserMenuGroup.class);
	}

	@Override
	public List<UserMenuGroup> getUserMenuGroupsByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		String hql = " from UserMenuGroup where groupId=" + groupId;
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void deleteUserMenuGroupByUsername(String username) {
		// TODO Auto-generated method stub
		String hql = " delete UserMenuGroup where username='" + username + "'";
		getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<UserMenuGroup> getUserMenuGroupsByUsername(String username) {
		// TODO Auto-generated method stub
		String hql = " from UserMenuGroup where username='" + username + "'";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public UserMenuGroup getUserMenuGroupByUsernameAndGroupId(String username,
			Long groupId) {
		// TODO Auto-generated method stub
		String hql = " from UserMenuGroup where username='" + username
				+ "' and groupId=" + groupId;
		Query query = getCurrentSession().createQuery(hql);
		List<UserMenuGroup> list = query.list();
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

}
