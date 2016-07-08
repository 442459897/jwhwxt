package com.muran.api.service.imp;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.muran.aop.annotation.BussAnnotation;
import com.muran.api.service.AbstractService;
import com.muran.api.service.IUsernameService;
import com.muran.dao.IUserDao;
import com.muran.model.User;

@Service("UsernameService")
public class UsernameService extends AbstractService implements
		IUsernameService {

	private final static Logger log = Logger.getLogger(UsernameService.class);
	@Resource(name = "UserDao")
	private IUserDao userDao;

	@Override
	@BussAnnotation(bussName = "检查用户名", login = false, role = "")
	public int checkUserName(String username, String userSys) {

		int i = 0;
		User user = userDao.getUser(username, userSys);
		if (user != null) {// 用户已存在
			i = 1;
		}
		return i;
	}
}
