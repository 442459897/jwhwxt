package com.muran.dao;

import com.muran.dao.operation.IOperations;
import com.muran.model.Admin;
import com.muran.util.Data;

public interface IAdminDao extends IOperations<Admin> {
	
	public Data<Admin> getAdminPageList(Integer pageSize, Integer pageIdex,
			String name);

}
