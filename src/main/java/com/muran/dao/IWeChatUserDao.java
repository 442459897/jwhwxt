package com.muran.dao;

import com.muran.dao.operation.IOperations;
import com.muran.model.WeChatUser;

public interface IWeChatUserDao extends IOperations<WeChatUser> {

	public WeChatUser getBySessionId(String sessionId);
	
	public WeChatUser getByOpenId(String openId);
}
