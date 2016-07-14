/**
 * 
 */
package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.IRoleRelationDao;
import com.muran.model.RoleRelation;
import com.muran.util.Data;
import com.muran.util.DateUtil;

/**
 * @author wxz
 * 
 */
@SuppressWarnings("unchecked")
@Repository("RoleRelationDao")
public class RoleRelationDao extends AbstractHibernateDao<RoleRelation>
		implements IRoleRelationDao {

	public RoleRelationDao() {
		super();
		setClazz(RoleRelation.class);
	}

	@Override
	public List<RoleRelation> getList(String clientSys, String clientOperKey,
			String clientOperName, String serverRoleKey, String serverRoleName) {
		// TODO Auto-generated method stub
		Query query = getQuery(clientSys, clientOperKey, clientOperName,
				serverRoleKey, serverRoleName);
		List<RoleRelation> list = query.list();
		return list;
	}

	@Override
	public Data<RoleRelation> getPageList(Integer pageIndex, Integer pageSize,
			String clientSys, String clientOperKey, String clientOperName,
			String serverRoleKey, String serverRoleName) {
		// TODO Auto-generated method stub
		Query query = getQuery(clientSys, clientOperKey, clientOperName,
				serverRoleKey, serverRoleName);
		List<RoleRelation> list = query.list();

		int totalRecord = list == null ? 0 : list.size();
		query.setFirstResult((pageIndex - 1) * pageSize);
		query.setMaxResults(pageSize);
		list = query.list();

		Data<RoleRelation> data = new Data<RoleRelation>();
		data.setPageIndex(pageIndex);
		data.setPageSize(pageSize);
		data.setTotalRecord(totalRecord);
		data.setData(list);

		return data;
	}

	private Query getQuery(String clientSys, String clientOperKey,
			String clientOperName, String serverRoleKey, String serverRoleName) {
		String hql = " from RoleRelation where 1=1 ";
		if (!DateUtil.StringIsNull(clientSys)) {
			hql += " and clientSys='" + clientSys + "'";
		}
		if (!DateUtil.StringIsNull(clientOperKey)) {
			hql += " and clientOperKey like '%" + clientOperKey + "%'";
		}
		if (!DateUtil.StringIsNull(clientOperName)) {
			hql += " and clientOperName like '%" + clientOperName + "%'";
		}
		if (!DateUtil.StringIsNull(serverRoleKey)) {
			hql += " and serverRoleKey like '%" + serverRoleKey + "%'";
		}
		if (!DateUtil.StringIsNull(serverRoleName)) {
			hql += " and serverRoleName like '%" + serverRoleName + "%'";
		}
		hql += " order by autoId desc";

		Query query = getCurrentSession().createQuery(hql);

		return query;

	}

	@Override
	public RoleRelation getRoleRelationByClientKey(String clientOperKey) {
		// TODO Auto-generated method stub
		String hql = " from RoleRelation where clientOperKey='" + clientOperKey
				+ "'";
		Query query=getCurrentSession().createQuery(hql);
		
		List<RoleRelation> list=query.list();
		
		if (list!=null&&list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}

}
