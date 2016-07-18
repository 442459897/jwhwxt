package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.Attach;

public interface IAttachDao extends IOperations<Attach> {

	public List<Attach> getList(String columnKey,Long itemId);
	public void deleteByColumnAndItem(String columnKey,Long itemId);
	
}
