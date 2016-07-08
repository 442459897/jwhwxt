package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;

import com.muran.dao.imp.AbstractHibernateDao;
import com.muran.dao.IRoleDao;
import com.muran.model.Role;
import com.muran.util.Data;

@SuppressWarnings("unchecked")
public class RoleDao extends AbstractHibernateDao<Role> implements IRoleDao {

	public RoleDao() {
		super();
		// TODO Auto-generated constructor stub
		setClazz(Role.class);
	}

	@Override
	public boolean checkRepeat(Long id, String key, String roleName) {
		// TODO Auto-generated method stub
		String hql = "from Role where  (keyCode='" + key + "'"
				+ " or roleName='" + roleName + "') and autoId<>" + id;
		Query query = getCurrentSession().createQuery(hql);
		List<Role> list = query.list();
		if (list != null && list.size() > 0)
			return true;
		return false;
	}

	@Override
	public Data<Role> getPageList(Integer pageSize, Integer pageIndex,
			String name, String descpt, String roleKey, String category) {
		// TODO Auto-generated method stub
		Query query = getqQuery(name, descpt,roleKey,category);
		List<Role> list = query.list();
		Data<Role> data = new Data<Role>();

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
	public List<Role> getList(String name, String descpt, String roleKey,
			String category) {
		// TODO Auto-generated method stub
		Query query = getqQuery(name, descpt,roleKey,category);
		List<Role> list = query.list();
		if (list != null && list.size() > 0)
			return list;
		return null;
	}

	private Query getqQuery(String name, String descpt,String roleKey,String category) {
		String hql = "from Role where 1=1";
		if (name != null && !name.equals("")) {
			hql = hql + " and roleName like '%" + name + "%'";
		}
		if (descpt != null && !descpt.equals("")) {
			hql = hql + " and descpt like '%" + descpt + "%'";
		}
		if (roleKey != null && !roleKey.equals("")) {
			hql = hql + " and keyCode like '%" + roleKey + "%'";
		}
		if (category != null && !category.equals("")) {
			hql = hql + " and category = '" + category + "'";
		}
		Query query = getCurrentSession().createQuery(hql);
		return query;
	}

	@Override
	public List<Role> getChildList(long parentId) {
		// TODO Auto-generated method stub
		String hql = "from Role where parentId=" + parentId;
		Query query = getCurrentSession().createQuery(hql);
		List<Role> list = query.list();
		if (list != null && list.size() > 0)
			return list;
		return null;
	}

	@Override
	public Role getRoleByKey(String key) {
		// TODO Auto-generated method stub
		String hql = "from Role where keyCode='" + key + "'";
		Query query = getCurrentSession().createQuery(hql);
		List<Role> list = query.list();
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public boolean isRoleOk(String username, String key) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_menu where autoId in(select menuId from tb_menugroup_menu where groupId in(select groupId from tb_user_menugroup where username='"
				+ username + "')) and roleKey like '%," + key + ",%'";
		Query query = getCurrentSession().createSQLQuery(sql);
		List<Role> list = query.list();
		if (list != null && list.size() > 0)
			return true;
		return false;
	}

}
