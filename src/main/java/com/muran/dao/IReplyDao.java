package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.Reply;

public interface IReplyDao extends IOperations<Reply> {

	//public List<ReplyWxInfo> getReplyInfo(Long type, Long message);
	
	public List<Reply> getReplyList(Long type, Long message, Long status);
}
