package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.IUserDao;
import com.muran.model.User;
import com.muran.util.dataVerify.MobileNumVerify;

@SuppressWarnings("unchecked")
@Repository("UserDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {
	public UserDao() {
		super();
		setClazz(User.class);
	}

	@Override
	public User getUserByUsername(String username, String userSys) {
		String hql = "from User as user where user.username=:username and user.userSys=:userSys";
		Query query = getCurrentSession().createQuery(hql);
		query.setString("username", username);
		query.setString("userSys", userSys);
		List<User> list = query.list();
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public User getUserByPhone(String phone, String userSys) {
		String hql = "from User as user where user.mobile=:mobile and user.userSys=:userSys";
		Query query = getCurrentSession().createQuery(hql);
		query.setString("mobile", phone);
		query.setString("userSys", userSys);
		List<User> list = query.list();
		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public User getUser(String usernameOrPhone, String userSys) {
		User user = null;
		MobileNumVerify mobileVerify = MobileNumVerify.getInstance();
		if (mobileVerify.verify(usernameOrPhone)) {
			user = getUserByPhone(usernameOrPhone, userSys);
		} else {
			user = getUserByUsername(usernameOrPhone, userSys);
		}
		return user;
	}

	public int updateMobile(String mobile, String username, String userSys) {
		String hql = "update User set mobile=:mobile where username=:username and userSys=:userSys";
		Query query = getCurrentSession().createQuery(hql);
		query.setString("mobile", mobile);
		query.setString("userSys", userSys);
		query.setString("username", username);
		int i = query.executeUpdate();
		return i;
	}

	@Override
	public int updatePassword(String username, String newPassword,
			String userSys) {
		// TODO Auto-generated method stub
		String hql = "update User set password=:password where username=:username and userSys=:userSys";
		Query query = getCurrentSession().createQuery(hql);
		query.setString("password", newPassword);
		query.setString("userSys", userSys);
		query.setString("username", username);
		int i = query.executeUpdate();
		return i;
	}

	@Override
	public int updatePwdByMobile(String mobile, String newPassword,
			String userSys) {
		// TODO Auto-generated method stub
		String hql = "update User set password=:password where mobile=:mobile and userSys=:userSys";
		Query query = getCurrentSession().createQuery(hql);
		query.setString("password", newPassword);
		query.setString("userSys", userSys);
		query.setString("mobile", mobile);
		int i = query.executeUpdate();
		return i;
	}

}
