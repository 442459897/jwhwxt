package com.muran.api.service.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.api.Context;
import com.muran.api.exception.AssertNull;
import com.muran.api.service.FeedbacksApiService;
import com.muran.application.GlobalConfig;
import com.muran.dao.IFeedbacksDao;
import com.muran.dao.IReplyDao;
import com.muran.dao.IUserDao;
import com.muran.dao.IWeChatUserDao;
import com.muran.dao.imp.UserDao;
import com.muran.dto.AddFeedback;
import com.muran.dto.FeedBackInfo;
import com.muran.dto.ReplyWxInfo;
import com.muran.model.FeedBack;
import com.muran.model.Reply;
import com.muran.model.WeChatUser;
import com.muran.util.Data;

@Service
public class FeedbacksApiServiceImp implements FeedbacksApiService {

	@Resource(name = "FeedbacksDao")
	private IFeedbacksDao feedBackdao;
	@Resource(name = "WeChatUserDao")
	private IWeChatUserDao weuserDao;
	@Resource(name = "ReplyDao")
	private IReplyDao replyDao;
	@Resource(name = "WeChatUserDao")
	private IWeChatUserDao userDao;

	@Override
	@Transactional
	public Response getFeedbackInfo(Long num, String upOrDown, Long time, Context context) {
		if (num == null) {
			num = (long) 10;
		}
		List<FeedBack> list = feedBackdao.getFeedbackInfo(num, upOrDown, time);
		List<FeedBackInfo> result = new ArrayList<FeedBackInfo>();
		if (list != null && list.size() > 0) {
			for (FeedBack feedBack : list) {
				FeedBackInfo feedBackInfo = new FeedBackInfo();
				feedBackInfo.setAutoId(feedBack.getAutoId());
				feedBackInfo.setContent(feedBack.getContent());
				feedBackInfo.setImage(feedBack.getImage());
				feedBackInfo.setMobile(feedBack.getMobile());
				feedBackInfo.setSayTime(feedBack.getSayTime());

				WeChatUser user = new WeChatUser();
				user = weuserDao.getByOpenId(context.getOpenId());
				feedBackInfo.setHeadImg(user.getHeadImg());
				feedBackInfo.setNickName(user.getNickName());

				// 回复list
				feedBackInfo.setReplies(getWxList(1L, feedBack.getAutoId(), 1L));

				result.add(feedBackInfo);

			}
		}

		return Response.ok().entity(result).build();
	}

	private List<ReplyWxInfo> getWxList(Long type, Long message, Long status) {
		List<ReplyWxInfo> listReturn = new ArrayList<ReplyWxInfo>();
		List<Reply> list = new ArrayList<Reply>();
		list = replyDao.getReplyList(type, message, status);
		if (list != null && list.size() > 0) {
			for (Reply reply : list) {
				ReplyWxInfo info = new ReplyWxInfo();
				info.setAutoId(reply.getAutoId());
				info.setContent(reply.getContent());
				info.setMessage(reply.getMessage());
				info.setReplyTime(reply.getReplyTime());
				info.setReplyType(reply.getReplyType());
				info.setType(reply.getType());
				if (reply.getReplyType() == 1) {
					WeChatUser user = new WeChatUser();
					user = userDao.getByOpenId(reply.getOpenId());
					info.setHeadImg(user.getHeadImg());
					info.setName(user.getNickName());
				} else {
					info.setHeadImg(GlobalConfig.KEY_JWH_HEADIMG);
					info.setName(GlobalConfig.KEY_JWH_NAME);
				}
				listReturn.add(info);
			}
		}
		return listReturn;

	}

	@Override
	@Transactional
	public Response getFeedbackInfoPageList(Integer pageSize, Integer pageIdex, Long startTime, Long endTime,
			Context context) {
		AssertNull.assertNull(pageIdex, pageSize);
		Data<FeedBack> data = feedBackdao.getFeedbackInfoPageList(pageSize, pageIdex, startTime, endTime);

		return Response.ok().entity(data).build();
	}

	@Override
	@Transactional
	public Response submitFeedback(AddFeedback feedback, Context context) {
		AssertNull.assertNull(feedback.getContent());
		FeedBack model = new FeedBack(null, context.getOpenId(), true, new Date(), feedback.getContent(),
				feedback.getImage(), feedback.getMobile());
		model = feedBackdao.merge(model);

		return Response.ok().entity(model).build();
	}

}
