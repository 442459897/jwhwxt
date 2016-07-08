package com.muran.api.service.imp;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.service.CommentsApiService;
import com.muran.dto.AddComment;

@Service
public class CommentsApiServiceImp implements CommentsApiService {

	@Override
	public Response auditComment(Long autoId, Long status, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getCommentInfo(String columnKey, Long itemId, Long num,
			String upOrDown, Long time, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getCommentInfoPageList(String columnKey, Long itemId,
			Integer pageSize, Integer pageIdex, String itemTitle,
			Long startTime, Long endTime, String status, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response submitComment(AddComment signupinfo, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
