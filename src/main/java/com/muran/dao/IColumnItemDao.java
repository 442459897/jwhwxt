package com.muran.dao;

import org.springframework.stereotype.Repository;
import com.muran.model.ColumnItem;
import com.muran.dao.operation.IOperations;

@Repository("ColumnItemDao")
public interface IColumnItemDao extends IOperations<ColumnItem>  {

}
