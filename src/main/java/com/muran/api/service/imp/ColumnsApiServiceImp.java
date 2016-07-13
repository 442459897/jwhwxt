package com.muran.api.service.imp;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.mapping.Array;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.api.Context;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.AbstractService;
import com.muran.api.service.ColumnsApiService;
import com.muran.dao.IArticleDao;
import com.muran.dao.IColumnItemDao;
import com.muran.dto.ColumnPosterInfo;
import com.muran.model.ColumnItem;
import com.muran.model.WeChatUser;

@Service
public class ColumnsApiServiceImp extends AbstractService implements
		ColumnsApiService {

	@Resource(name = "ColumnItemDao")
	private IColumnItemDao dao;

	@Override
	@Transactional
	public Response getColumnPosterInfo(String columnKey, Context context) {
		// TODO Auto-generated method stub
		ColumnItem item = new ColumnItem();
		item = dao.getColumnItemByKey(columnKey);
		if (item == null) {
			throw new ServerException(Code.BadRequestParams, "栏目信息不存在！");
		}
		ColumnPosterInfo info = new ColumnPosterInfo();
		info.setColumnKey(columnKey);
		info.setIsShowPoster(item.isShowPoster());
		info.setName(item.getName());
		info.setPosterUrl(item.getPosterUrl());
		return Response.ok().entity(info).build();
	}

	@Override
	@Transactional
	public Response getColumnPosterInfoList(Context context) {
		// TODO Auto-generated method stub
		List<ColumnPosterInfo> listReturn = new ArrayList<ColumnPosterInfo>();
		List<ColumnItem> list = new ArrayList<ColumnItem>();
		list = dao.getPosterColumnList();
		if (list != null && list.size() > 0) {
			for (ColumnItem columnItem : list) {
				ColumnPosterInfo info = new ColumnPosterInfo();
				info.setColumnKey(columnItem.getColumnKey());
				info.setIsShowPoster(columnItem.isShowPoster());
				info.setName(columnItem.getName());
				info.setPosterUrl(columnItem.getPosterUrl());
				listReturn.add(info);
			}
		}
		return Response.ok().entity(listReturn).build();
	}

	@Override
	@Transactional
	public Response getCommunityUrl(Context context) {
		// TODO Auto-generated method stub
		ColumnItem item = new ColumnItem();
		item = dao.getColumnItemByKey("column_community");
		if (item == null) {
			throw new ServerException(Code.BadRequestParams, "小区栏目信息不存在！");
		}
		return Response.ok().entity(item.getOutUrl()).build();
	}

	@Override
	@Transactional
	public Response setColumnPosterInfo(String columnKey, Boolean isShowPoster,
			String posterUrl, Context context) {
		// TODO Auto-generated method stub
		ColumnItem item = new ColumnItem();
		item = dao.getColumnItemByKey(columnKey);
		if (item == null) {
			throw new ServerException(Code.BadRequestParams, "栏目信息不存在！");
		}
		item.setColumnKey(columnKey);
		item.setShowPoster(isShowPoster);
		item.setPosterUrl(posterUrl);
		item = dao.update(item);
		
		ColumnPosterInfo info = new ColumnPosterInfo();
		info.setColumnKey(columnKey);
		info.setIsShowPoster(isShowPoster);
		info.setName(item.getName());
		info.setPosterUrl(posterUrl);
		
		return Response.ok().entity(info).build();
	}

	@Override
	@Transactional
	public Response setCommunityUrl(String outUrl, Context context) {
		// TODO Auto-generated method stub
		ColumnItem item = new ColumnItem();
		item = dao.getColumnItemByKey("column_community");
		if (item == null) {
			throw new ServerException(Code.BadRequestParams, "小区栏目信息不存在！");
		}
		item.setOutUrl(outUrl);
		item = dao.update(item);
		
		return Response.ok().entity(item.getOutUrl()).build();
	}

}
