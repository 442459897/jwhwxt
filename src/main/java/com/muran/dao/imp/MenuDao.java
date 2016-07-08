/**
 * 
 */
package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;

import com.muran.dao.imp.AbstractHibernateDao;
import com.muran.dao.IMenuDao;
import com.muran.model.Menu;

/**
 * @author wxz
 * 
 */
@SuppressWarnings("unchecked")
public class MenuDao extends AbstractHibernateDao<Menu> implements IMenuDao {

	public MenuDao() {
		super();
		setClazz(Menu.class);
	}

	@Override
	public List<Menu> getList(Long parentId) {
		// TODO Auto-generated method stub
		String hql = " from Menu where 1=1 ";
		if (parentId != null) {
			hql += " and parentId=" + parentId;
		}
		hql+=" order by menuOrder asc";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<Menu> getListByUsername(String username) {
		// TODO Auto-generated method stub
		String hql = " from Menu where enable=1 and autoId in(select menuId from GroupMenu where groupId in(SELECT groupId FROM UserMenuGroup where username='"
				+ username + "'))";
		hql+=" order by menuOrder asc";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<Menu> getListByUsernameAndType(String username, String type) {
		// TODO Auto-generated method stub
//		String sql = " select * from tb_menu where enable=1 and autoId in(select menuId from tb_menugroup_menu where groupId in(SELECT groupId FROM tb_user_menugroup where username='"
//				+ username + "')) and type='" + type + "'";
//		Query query = getCurrentSession().createSQLQuery(sql);
		String hql = "  from Menu where enable=1 and autoId in(select menuId from GroupMenu where groupId in(SELECT groupId FROM UserMenuGroup where username='"
				+ username + "')) and type='" + type + "'";
		hql+=" order by menuOrder asc";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<Menu> getListByUsernameAndParentId(String username,
			Long parentId) {
		// TODO Auto-generated method stub
//		String sql = " select * from tb_menu where enable=1 and autoId in(select menuId from tb_menugroup_menu where groupId in(SELECT groupId FROM tb_user_menugroup where username='"
//				+ username + "')) and parentId=" + parentId;
//		Query query = getCurrentSession().createSQLQuery(sql);
		String hql = " from Menu where enable=1 and autoId in(select menuId from GroupMenu where groupId in(SELECT groupId FROM UserMenuGroup where username='"
				+ username + "')) and parentId=" + parentId;
		hql+=" order by menuOrder asc";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

}
