package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.Comment;

public interface ICommentDao extends IOperations<Comment> {

	public List<Comment> getList(String columnKey, Long itemId, Long status);
}
