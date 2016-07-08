/**
 * 
 */
package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;

import com.muran.dao.imp.AbstractHibernateDao;
import com.muran.dao.IGroupMenuDao;
import com.muran.model.GroupMenu;

/**
 * @author wxz
 * 
 */
@SuppressWarnings("unchecked")
public class GroupMenuDao extends AbstractHibernateDao<GroupMenu> implements
		IGroupMenuDao {

	/**
	 * 
	 */
	public GroupMenuDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(GroupMenu.class);
	}

	@Override
	public List<GroupMenu> getGroupMenusByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		String hql = " from GroupMenu where groupId=" + groupId;
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void deleteGroupMenusByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		String hql = "delete GroupMenu where groupId=" + groupId;
		getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public String getRelationRoles(Long menuId, Long groupId) {
		// TODO Auto-generated method stub
		String hql = " from GroupMenu where groupId=" + groupId
				+ " and menuId=" + menuId;
		Query query = getCurrentSession().createQuery(hql);
		List<GroupMenu> groupMenus = query.list();
		if (groupMenus != null && groupMenus.size() > 0) {
			return groupMenus.get(0).getRoleKey();
		}
		return "";
	}

}
