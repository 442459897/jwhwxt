package com.muran.api.service.imp;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.api.Context;
import com.muran.api.service.RepliesApiService;
import com.muran.dto.AddReply;

@Service
public class RepliesApiServiceImp implements RepliesApiService {

	@Override
	@Transactional
	public Response reply(AddReply reply, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
