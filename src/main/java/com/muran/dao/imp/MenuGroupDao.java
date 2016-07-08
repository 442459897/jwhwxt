/**
 * 
 */
package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;

import com.muran.dao.imp.AbstractHibernateDao;
import com.muran.dao.IMenuGroupDao;
import com.muran.model.MenuGroup;

/**
 * @author wxz
 * 
 */
@SuppressWarnings("unchecked")
public class MenuGroupDao extends AbstractHibernateDao<MenuGroup> implements
		IMenuGroupDao {

	public MenuGroupDao() {
		super();
		setClazz(MenuGroup.class);
	}

	@Override
	public List<MenuGroup> getMenuGroupsByUsername(String username) {
		// TODO Auto-generated method stub
//		String sql = "SELECT * FROM tb_menugroup where autoId in(SELECT groupId FROM tb_user_menugroup where username='"
//				+ username + "')";
//		Query query = getCurrentSession().createSQLQuery(sql);
		
		String hql = " FROM MenuGroup where autoId in(SELECT groupId FROM UserMenuGroup where username='"
				+ username + "')";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<MenuGroup> getList(String code) {
		// TODO Auto-generated method stub
		String hql = " from MenuGroup where 1=1 ";
		if (code != null && !code.equals("")) {
			hql += " and code='" + code + "'";
		}
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<MenuGroup> getMenuGroupListByCode(String code) {
		// TODO Auto-generated method stub
		String hql = " from MenuGroup where code='" + code + "'";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

}
