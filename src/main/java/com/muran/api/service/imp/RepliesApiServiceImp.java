package com.muran.api.service.imp;

import java.util.Date;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.api.Context;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.RepliesApiService;
import com.muran.application.GlobalConfig;
import com.muran.dao.IReplyDao;
import com.muran.dao.IWeChatUserDao;
import com.muran.dto.AddReply;
import com.muran.dto.ReplyWxInfo;
import com.muran.model.Reply;
import com.muran.model.WeChatUser;

@Service
public class RepliesApiServiceImp implements RepliesApiService {

	@Resource(name = "ReplyDao")
	private IReplyDao dao;
	
	@Resource(name = "WeChatUserDao")
	private IWeChatUserDao userDao;

	@Override
	@Transactional
	public Response reply(AddReply reply, Context context) {
		// TODO Auto-generated method stub
		Reply replyInfo = new Reply();
		replyInfo.setContent(reply.getContent());
		replyInfo.setEnable(true);
		replyInfo.setMessage(reply.getMessage());

		replyInfo.setReply(reply.getReply());
		replyInfo.setReplyTime(new Date());
		replyInfo.setReplyType(reply.getReplyType());// 0 居委会 1 微信用户
		replyInfo.setType(reply.getType());// 分类0 留言 1 我有话说
		if (reply.getReplyType() == 0) {
			replyInfo.setUsername(context.getUsername());
			replyInfo.setStatus(1l);// 居委会直接审核通过
		} else if (reply.getReplyType() == 1) {
			replyInfo.setOpenId(context.getOpenId());
			replyInfo.setStatus(0l);
		}
		replyInfo = dao.merge(replyInfo);
		//返回信息
		ReplyWxInfo info = new ReplyWxInfo();
		info.setAutoId(replyInfo.getAutoId());
		info.setContent(replyInfo.getContent());
		info.setMessage(replyInfo.getMessage());
		info.setReplyTime(replyInfo.getReplyTime());
		info.setReplyType(replyInfo.getReplyType());
		info.setType(replyInfo.getType());
		if (replyInfo.getReplyType() == 1) {
			WeChatUser user = new WeChatUser();
			user = userDao.getByOpenId(replyInfo.getOpenId());
			info.setHeadImg(user.getHeadImg());
			info.setName(user.getNickName());
		} else {
			info.setHeadImg(GlobalConfig.KEY_JWH_HEADIMG);
			info.setName(GlobalConfig.KEY_JWH_NAME);
		}
		
		return Response.ok().entity(info).build();
	}

	@Override
	@Transactional
	public Response auditReply(Long autoId, Long status, Context context) {
		// TODO Auto-generated method stub
		Reply replyInfo = new Reply();
		replyInfo = dao.findOne(autoId);
		if (replyInfo == null) {
			throw new ServerException(Code.BadRequestParams, "回复信息不存在！");
		}
		replyInfo.setStatus(status);
		replyInfo = dao.update(replyInfo);
		return Response.ok().build();
	}
}
