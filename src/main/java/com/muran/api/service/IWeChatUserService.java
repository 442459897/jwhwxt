package com.muran.api.service;

import com.muran.model.WeChatUser;

import weixin.popular.bean.sns.SnsToken;
import weixin.popular.bean.token.Token;
import weixin.popular.bean.user.User;

public interface IWeChatUserService {

	public boolean IsUserExistOrExpire(String sessionId);
	
	public WeChatUser updateOrCreateWeChatUser(User user,Token token,SnsToken snsToken);
	
	public WeChatUser createWeChatUser(User user);
	
	public WeChatUser getWeChatUser(String sessionId);
	
	public WeChatUser getUserExistAndNoExpire(String sessionId);
}
