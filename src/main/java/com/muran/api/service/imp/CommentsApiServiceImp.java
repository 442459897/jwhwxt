package com.muran.api.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.CommonToken;

import com.muran.api.Context;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.CommentsApiService;
import com.muran.application.GlobalConfig;
import com.muran.dao.ICommentDao;
import com.muran.dao.IReplyDao;
import com.muran.dao.IWeChatUserDao;
import com.muran.dto.AddComment;
import com.muran.dto.CommentSampleInfo;
import com.muran.dto.CommentWxInfo;
import com.muran.dto.ReplyWxInfo;
import com.muran.model.Comment;
import com.muran.model.Reply;
import com.muran.model.WeChatUser;
import com.muran.util.Data;

@Service
public class CommentsApiServiceImp implements CommentsApiService {

	@Resource(name = "CommentDao")
	private ICommentDao dao;

	@Resource(name = "WeChatUserDao")
	private IWeChatUserDao userDao;

	@Resource(name = "ReplyDao")
	private IReplyDao replyDao;

	@Override
	@Transactional
	public Response auditComment(Long autoId, Long status, Context context) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment = dao.findOne(autoId);
		if (comment == null) {
			throw new ServerException(Code.BadRequestParams, "留言评论信息不存在！");
		}
		comment.setStatus(status);
		return Response.ok().build();
	}

	@Override
	@Transactional
	public Response getCommentInfo(String columnKey, Long itemId, Long num,
			String upOrDown, Long time, Context context) {
		// TODO Auto-generated method stub
		List<CommentWxInfo> listReturn = new ArrayList<CommentWxInfo>();
		List<Comment> list = new ArrayList<Comment>();
		list = dao.getList(columnKey, itemId, num, upOrDown, time, 1l);// 取已审核的留言评论信息
		if (list != null && list.size() > 0) {
			for (Comment comment : list) {
				CommentWxInfo info = new CommentWxInfo();
				info.setAutoId(comment.getAutoId());
				info.setColumnKey(comment.getColumnKey());
				info.setCommentTime(comment.getCommentTime());
				info.setContent(comment.getContent());
				info.setItemId(comment.getItemId());
				info.setReplies(getWxList(0l, comment.getAutoId(), 1l));// 取留言评论
																		// 已审核的回复
				info.setStatus(comment.getStatus());

				WeChatUser user = new WeChatUser();
				user = userDao.getByOpenId(comment.getOpenId());
				info.setHeadImg(user.getHeadImg());
				info.setNickName(user.getNickName());

				listReturn.add(info);
			}
		}
		return Response.ok().entity(listReturn).build();
	}

	@Override
	@Transactional
	public Response getCommentInfoPageList(String columnKey, Long itemId,
			Integer pageSize, Integer pageIdex, String itemTitle,
			Long startTime, Long endTime, String status, Context context) {
		// TODO Auto-generated method stub
		Data<Comment> data = dao.getCommentInfoPageList(columnKey, itemId,
				pageSize, pageIdex, itemTitle, startTime, endTime, status);

		Data<CommentSampleInfo> dataReturn = new Data<CommentSampleInfo>();
		dataReturn.setPageIndex(data.getPageIndex());
		dataReturn.setPageSize(data.getPageSize());
		dataReturn.setTotalRecord(data.getTotalRecord());

		List<CommentSampleInfo> listReturn = new ArrayList<CommentSampleInfo>();
		if (data.getData() != null && data.getData().size() > 0) {
			for (Comment comment : data.getData()) {
				CommentSampleInfo info = new CommentSampleInfo();
				info.setAutoId(comment.getAutoId());
				info.setColumnKey(comment.getColumnKey());
				info.setColumnName("");
				info.setCommentTime(comment.getCommentTime());
				info.setContent(comment.getContent());

				info.setItemId(comment.getItemId());
				info.setItemTitle("");

				info.setReplies(getWxList(0l, comment.getAutoId(), null));
				info.setStatus(comment.getStatus());

				WeChatUser user = new WeChatUser();
				user = userDao.getByOpenId(comment.getOpenId());
				info.setHeadImg(user.getHeadImg());
				info.setNickName(user.getNickName());
				listReturn.add(info);

			}
		}

		dataReturn.setData(listReturn);
		return Response.ok().entity(dataReturn).build();
	}

	@Override
	@Transactional
	public Response submitComment(AddComment signupinfo, Context context) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setColumnKey(signupinfo.getColumnKey());
		comment.setCommentTime(new Date());
		comment.setEnable(true);
		comment.setItemId(signupinfo.getItemId());
		comment.setOpenId(context.getOpenId());
		comment.setStatus(0l);
		comment = dao.merge(comment);

		CommentWxInfo info = new CommentWxInfo();
		info.setAutoId(comment.getAutoId());
		info.setColumnKey(comment.getColumnKey());
		info.setCommentTime(comment.getCommentTime());
		info.setContent(comment.getContent());
		info.setItemId(comment.getItemId());
		info.setReplies(null);// 取留言评论
		info.setStatus(comment.getStatus());

		WeChatUser user = new WeChatUser();
		user = userDao.getByOpenId(comment.getOpenId());
		info.setHeadImg(user.getHeadImg());
		info.setNickName(user.getNickName());

		return Response.ok().entity(info).build();
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

}
