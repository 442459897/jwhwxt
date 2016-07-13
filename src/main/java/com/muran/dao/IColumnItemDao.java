package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.ColumnItem;

public interface IColumnItemDao extends IOperations<ColumnItem> {
	public List<ColumnItem> getList(Long parentId);
	
	public ColumnItem getColumnItemByKey(String columnKey);
	
	public List<ColumnItem> getPosterColumnList();
	
	
	
	
}
