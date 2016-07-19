package com.muran.api.service.imp;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.bean.sns.SnsToken;
import weixin.popular.bean.token.Token;
import weixin.popular.bean.user.User;

import com.muran.api.service.AbstractService;
import com.muran.api.service.IWeChatUserService;
import com.muran.dao.IWeChatUserDao;
import com.muran.dto.WxConfig;
import com.muran.model.WeChatUser;
import com.muran.util.WxConfigUtil;

@Service("WeChatUserService")
public class WeChatUserService extends AbstractService implements
		IWeChatUserService {

	@Resource(name = "WeChatUserDao")
	private IWeChatUserDao dao;

	@Override
	@Transactional
	public boolean IsUserExistOrExpire(String sessionId) {
		// TODO Auto-generated method stub
		WeChatUser user = new WeChatUser();
		user = dao.getBySessionId(sessionId);
		if (user == null) {
			return false;
		}
		if (System.currentTimeMillis() > user.getExpireTime().getTime()) {
			// 此用户信息已过期
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public WeChatUser updateOrCreateWeChatUser(User user,Token token,SnsToken snsToken) {
		// TODO Auto-generated method stub

		WeChatUser weUser = new WeChatUser();
		weUser = dao.getByOpenId(user.getOpenid());
		if (weUser == null) {
			weUser = new WeChatUser();
			weUser.setExpireTime(new Date(System.currentTimeMillis()
					+ WxConfigUtil.sessionExpireTime * 1000));
			weUser.setHeadImg(user.getHeadimgurl());
			weUser.setNickName(user.getNickname());
			weUser.setOpenId(user.getOpenid());
			weUser.setSessionId(UUID.randomUUID().toString());// 生成随即的sesionid
			weUser.setWatched(user.getSubscribe() == 0 ? false : true);
			weUser.setSnsToken(snsToken.getAccess_token());
			weUser.setToken(token.getAccess_token());
			weUser = dao.merge(weUser);
			return weUser;
		}

		weUser.setExpireTime(new Date(System.currentTimeMillis()
				+ WxConfigUtil.sessionExpireTime * 1000));
		weUser.setHeadImg(user.getHeadimgurl());
		weUser.setNickName(user.getNickname());
		weUser.setOpenId(user.getOpenid());
		weUser.setSessionId(UUID.randomUUID().toString());// 生成随即的sesionid
		weUser.setWatched(user.getSubscribe() == 0 ? false : true);
		weUser.setSnsToken(snsToken.getAccess_token());
		weUser.setToken(token.getAccess_token());
		weUser = dao.update(weUser);
		return weUser;

	}

	@Override
	@Transactional
	public WeChatUser createWeChatUser(User user) {
		// TODO Auto-generated method stub
		WeChatUser weUser = new WeChatUser();
		weUser.setExpireTime(new Date(System.currentTimeMillis()
				+ WxConfigUtil.sessionExpireTime * 1000));
		weUser.setHeadImg(user.getHeadimgurl());
		weUser.setNickName(user.getNickname());
		weUser.setOpenId(user.getOpenid());
		weUser.setSessionId(UUID.randomUUID().toString());// 生成随即的sesionid
		weUser.setWatched(user.getSubscribe() == 0 ? false : true);
		weUser = dao.merge(weUser);
		return weUser;
	}

	@Override
	@Transactional
	public WeChatUser getWeChatUser(String sessionId) {
		// TODO Auto-generated method stub
		WeChatUser weUser = new WeChatUser();
		weUser = dao.getBySessionId(sessionId);
		return weUser;
	}

	@Override
	@Transactional
	public WeChatUser getUserExistAndNoExpire(String sessionId) {
		// TODO Auto-generated method stub
		WeChatUser user = new WeChatUser();
		user = dao.getBySessionId(sessionId);
		if (user == null) {
			return null;
		}
		if (System.currentTimeMillis() > user.getExpireTime().getTime()) {
			// 此用户信息已过期
			return null;
		}
		return user;
	}

}
