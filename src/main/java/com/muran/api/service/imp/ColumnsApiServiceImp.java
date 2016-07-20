package com.muran.api.service.imp;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider.General;
import org.hibernate.mapping.Array;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.popular.api.MenuAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.token.Token;
import weixin.popular.util.JsonUtil;

import com.muran.api.Context;
import com.muran.api.WeChatApi;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.AbstractService;
import com.muran.api.service.ColumnsApiService;
import com.muran.application.GlobalConfig;
import com.muran.dao.IArticleDao;
import com.muran.dao.IColumnItemDao;
import com.muran.dto.ColumnPosterInfo;
import com.muran.dto.GeneralString;
import com.muran.dto.WxButton;
import com.muran.dto.WxMenu;
import com.muran.dto.WxSubButton;
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
		GeneralString str=new GeneralString();
		str.setValue(item.getOutUrl());
		
		return Response.ok().entity(str).build();
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
		item.setUrl(outUrl);
		item = dao.update(item);
		
		//处理菜单
		
		if (WeChatApi.token == null || System.currentTimeMillis() > WeChatApi.tokenExpiresTime) {
			WeChatApi.token = TokenAPI.token(GlobalConfig.KEY_APPID,
					GlobalConfig.KEY_APP_SECRET);

			if (WeChatApi.token.isSuccess()) {
				WeChatApi.tokenExpiresTime = System.currentTimeMillis()
						+ (WeChatApi.token.getExpires_in() - 200) * 1000;// token创建时间
																// 提前200秒过期
																// 精确到毫秒
			} else {
				throw new ServerException(Code.BadRequestParams, "token获取失败！");
			}
		}
		
		WxMenu menu = getWxMenu();
		String menuJson = JsonUtil.toJSONString(menu);
		log.info("创建菜单的json串：" + menuJson);
		// 调用微信接口
		BaseResult result = MenuAPI.menuCreate(WeChatApi.token.getAccess_token(), menuJson);
		log.info("isSuccess：" + result.isSuccess());
		if (!result.isSuccess()) {
			// 失败 返回失败信息
			throw new ServerException(Code.BadRequestParams, "创建菜单失败！");
		}
		
		
		GeneralString str=new GeneralString();
		str.setValue(item.getOutUrl());
		
		//修改菜单
		return Response.ok().entity(str).build();
	}
	
	public WxMenu getWxMenu() {
		// TODO Auto-generated method stub
		List<ColumnItem> listParent = new ArrayList<ColumnItem>();
		List<WxButton> listButtons = new ArrayList<WxButton>();
		listParent = dao.getList(Long.valueOf("0"));
		for (ColumnItem columnItem : listParent) {
			// 新建
			WxButton button = new WxButton();
			button.setName(columnItem.getName());
			List<ColumnItem> listChild = dao.getList(columnItem.getAutoId());

			List<WxSubButton> listSubButtons = new ArrayList<WxSubButton>();
			for (ColumnItem columnItem2 : listChild) {
				WxSubButton subButton = new WxSubButton();
				subButton.setName(columnItem2.getName());
				subButton.setType(columnItem2.getType());
				subButton.setUrl(columnItem2.getUrl());
				listSubButtons.add(subButton);
			}
			button.setSub_button(listSubButtons);
			listButtons.add(button);
		}
		WxMenu menu = new WxMenu();
		menu.setButton(listButtons);
		return menu;
	}

}
