package com.muran.api.service.imp;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.service.AdminsApiService;
import com.muran.dto.AddAdmin;

@Service
public class AdminsApiServiceImp implements AdminsApiService {

	@Override
	public Response addAdmin(AddAdmin admin, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteAdminInfo(Long autoId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getAdminInfo(Long autoId, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getAdminPageList(Integer pageSize, Integer pageIdex,
			String name, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateAdmin(Long autoId, String name, Boolean gender,
			String mobile, String email, String idNumber, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
