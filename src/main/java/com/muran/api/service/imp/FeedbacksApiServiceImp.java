package com.muran.api.service.imp;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.api.Context;
import com.muran.api.service.FeedbacksApiService;
import com.muran.dto.AddFeedback;

@Service
public class FeedbacksApiServiceImp implements FeedbacksApiService {

	@Override
	@Transactional
	public Response getFeedbackInfo(Long num, String upOrDown, Long time,
			Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Response getFeedbackInfoPageList(Integer pageSize, Integer pageIdex,
			Long startTime, Long endTime, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Response submitFeedback(AddFeedback feedback, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
