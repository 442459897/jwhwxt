package com.muran.dao.imp;

import org.springframework.stereotype.Repository;

import com.muran.dao.IAttachDao;
import com.muran.model.Attach;

@SuppressWarnings("unchecked")
@Repository("AttachDao")
public class AttachDao extends AbstractHibernateDao<Attach> implements
		IAttachDao {

	public AttachDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(Attach.class);
	}

}
