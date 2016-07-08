package com.muran.api.service.imp;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.service.ActivitiesApiService;
import com.muran.dto.AddActivity;
import com.muran.dto.SignupActivity;

@Service
public class ActivitiesApiServiceImp implements ActivitiesApiService {

	@Override
	public Response addActivity(AddActivity activity, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteActivity(Long autoId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getActivity(Long autoId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getActivityPageList(Integer pageSize, Integer pageIdex,
			Long startTime, Long endTime, String title, String keyword,
			String status, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getActivityWxList(Integer num, String upOrDown, Long time,
			String title, String keyword, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getSignupInfo(Long autoId, Integer num, String upOrDown,
			Long time, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getSignupInfoPageList(Long autoId, Integer pageSize,
			Integer pageIdex, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response signupActivity(Long autoId, SignupActivity signupinfo,
			Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response backActivity(Long autoId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response publishActivity(Long autoId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateActivity(Long autoId, AddActivity activity,
			Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
