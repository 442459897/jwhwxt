package com.muran.api.service.imp;

import java.util.Date;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.muran.api.Context;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.AdminsApiService;
import com.muran.dao.IAdminDao;
import com.muran.dao.IUserDao;
import com.muran.dao.IUserTokenDao;
import com.muran.dto.AddAdmin;
import com.muran.model.Admin;
import com.muran.model.User;
import com.muran.util.Data;
import com.muran.util.PasswordHash;

@Service
public class AdminsApiServiceImp implements AdminsApiService {

	private final static Logger log = Logger.getLogger(UserLoginService.class);
	@Resource(name = "UserTokenDao")
	private IAdminDao adminDao;
	@Resource(name = "UserDao")
	private IUserDao userDao;

	@Override
	public Response addAdmin(AddAdmin admin, Context context) {
		// TODO Auto-generated method stub
		// 检查用户信息是否存在
		User user = userDao.getUserByUsername(admin.getUsername(), "admin");
		if (user != null) {
			throw new ServerException(Code.UsernameHasExsited, "用户名已存在！");
		}

		Admin adminUser = new Admin();
		adminUser.setCreateTime(new Date());
		adminUser.setCreateUser(context.getUsername());
		adminUser.setEmail(admin.getEmail());
		adminUser.setEnable(true);
		adminUser.setGender(admin.getGender());
		adminUser.setIdNumber(admin.getIdNumber());
		adminUser.setMobile(admin.getMobile());
		adminUser.setModifyTime(new Date());
		adminUser.setModifyUser(context.getUsername());
		adminUser.setName(admin.getName());
		adminUser.setUsername(admin.getUsername());

		adminUser = adminDao.merge(adminUser);

		user = new User();
		user.setCreateTime(new Date());
		user.setMobile("");
		user.setModifyTime(new Date());
		user.setPassword(PasswordHash.createHash("88888888"));
		user.setUsername(admin.getUsername());
		user.setUserSys("admin");
		user = userDao.merge(user);

		return Response.ok().entity(adminUser).build();
	}

	@Override
	public Response deleteAdminInfo(Long autoId, Context context) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.findOne(autoId);
		if (admin == null) {
			throw new ServerException(Code.UserNoExisted, "用户不存在！");
		}

		User user = userDao.getUserByUsername(admin.getUsername(), "admin");
		if (user == null) {
			throw new ServerException(Code.UserNoExisted, "用户不存在！");
		}
		adminDao.deleteById(autoId);
		userDao.deleteById(user.getAutoId());
		return Response.ok().build();
	}

	@Override
	public Response getAdminInfo(Long autoId, Context context) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.findOne(autoId);
		return Response.ok().entity(admin).build();
	}

	@Override
	public Response getAdminPageList(Integer pageSize, Integer pageIdex,
			String name, Context context) {
		// TODO Auto-generated method stub
		Data<Admin> data = adminDao.getAdminPageList(pageSize, pageIdex, name);
		return Response.ok().entity(data).build();
	}

	@Override
	public Response updateAdmin(Long autoId, String name, Boolean gender,
			String mobile, String email, String idNumber, Context context) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.findOne(autoId);
		if (admin == null) {
			throw new ServerException(Code.UserNoExisted, "用户不存在！");
		}
		admin.setName(name);
		admin.setGender(gender);
		admin.setEmail(email);
		admin.setMobile(mobile);
		admin.setIdNumber(idNumber);
		admin = adminDao.update(admin);
		return Response.ok().entity(admin).build();
	}

}
