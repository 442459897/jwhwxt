package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.Comment;
import com.muran.util.Data;

public interface ICommentDao extends IOperations<Comment> {

	public List<Comment> getList(String columnKey, Long itemId, Long status);

	public List<Comment> getList(String columnKey, Long itemId, Long num,
			String upOrDown, Long time, Long status);

	public Data<Comment> getCommentInfoPageList(String columnKey, Long itemId,
			Integer pageSize, Integer pageIdex, String itemTitle,
			Long startTime, Long endTime, String status);
}
