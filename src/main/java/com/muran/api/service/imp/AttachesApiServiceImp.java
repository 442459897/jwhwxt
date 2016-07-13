package com.muran.api.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.api.Context;
import com.muran.api.service.AttachesApiService;
import com.muran.dao.IAttachDao;
import com.muran.model.Attach;

@Service
public class AttachesApiServiceImp implements AttachesApiService {

	@Resource(name = "AttachDao")
	IAttachDao dao;

	@Override
	@Transactional
	public Response getAttachInfo(String columnKey, Integer itemId,
			Context context) {
		// TODO Auto-generated method stub
		List<Attach> list = new ArrayList<Attach>();
		list = dao.getList(columnKey, Long.valueOf(itemId));
		return Response.ok().entity(list).build();
	}

}
