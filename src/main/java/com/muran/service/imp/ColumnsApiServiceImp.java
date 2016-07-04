package com.muran.service.imp;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.service.ColumnsApiService;
import com.muran.dto.ColumnPosterInfo;
import com.muran.model.WeChatUser;
import com.muran.service.AbstractService;

@Service
public class ColumnsApiServiceImp extends AbstractService implements ColumnsApiService {
	

	@Override
	public Response getColumnPosterInfo(String columnKey, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getColumnPosterInfoList(Context context) {
		// TODO Auto-generated method stub
		WeChatUser user=new WeChatUser();
		user.setAutoId(1);
		user.setHeadImg("img");
		user.setNickName("name");
		user.setWatched(true);	
		try {
			return Response.status(Status.FOUND).location(new URI("http://n2c.mrshare.cn")).build();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Status.NOT_FOUND).build();
		}
		
		//return Response.status(Status.FOUND).location(new URI("http://nc.mrshare.cn")).build();
	}

	@Override
	public Response getCommunityUrl(Context context) {
		// TODO Auto-generated method stub	
		return Response.ok().entity("测试一下！").build();
	}

	@Override
	public Response setColumnPosterInfo(String columnKey, Boolean isShowPoster,
			String posterUrl, Context context) {
		// TODO Auto-generated method stub
		ColumnPosterInfo info=new ColumnPosterInfo();
		info.setColumnKey("11111");
		info.setIsShowPoster(true);
		info.setName("name");
		info.setPosterUrl("sss");
		return null;
	}

	@Override
	public Response setCommunityUrl(String outUrl, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

}
