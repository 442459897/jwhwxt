package com.muran.api.service.imp;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.service.FeedbacksApiService;
import com.muran.dto.AddFeedback;

@Service
public class FeedbacksApiServiceImp implements FeedbacksApiService {

	@Override
	public Response getFeedbackInfo(Long num, String upOrDown, Long time,
			Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getFeedbackInfoPageList(Integer pageSize, Integer pageIdex,
			Long startTime, Long endTime, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response submitFeedback(AddFeedback feedback, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
