package com.muran.dao.imp;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.muran.dao.IUserTokenDao;
import com.muran.model.UserToken;
@SuppressWarnings("unchecked")
public class UserTokenDao extends AbstractHibernateDao<UserToken> implements
		IUserTokenDao {
	public UserTokenDao() {
		super();
		setClazz(UserToken.class);
	}

	@Override
	public void saveOrUpdate(UserToken ut) {
		create(ut.getUserToken(), ut.getTokenSecret());
	}

	@Override
	public void create(String token, String secrect, boolean newSession) {
		String str[] = token.split("_");
		String username = str[0];
		String userSys = str[2];
		Session session = newSession ? newSession() : getCurrentSession();
		// if (newSession)
		// session.beginTransaction();
		// String sql1 = "update tb_user_token set enable=0  where  username='"
		// + username + "'" + " and userSys='" + userSys
		// + "' and userToken!='" + token + "'";
		String sql2 = "insert into tb_user_token(username,userToken,userSys,tokenSecret,enable) values('"
				+ username
				+ "','"
				+ token
				+ "','"
				+ userSys
				+ "','"
				+ secrect
				+ "',1)";
		// session.createSQLQuery(sql1).executeUpdate();
		session.createSQLQuery(sql2).executeUpdate();
		if (newSession) {
			// session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public void setDisnableIfExsited(long userId) {
		String hql = "update UserToken set enable=:enable1 where userId=:userId and enable=:enable2";
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		query.setBoolean("enable1", false);
		query.setBoolean("enable2", true);
		query.setLong("userId", userId);
		query.executeUpdate();
	}

	@Override
	public void setDisnableState(String token, boolean newSession) {
		// TODO Auto-generated method stub
		String hql = "update UserToken set enable=:enable where userToken=:token";
		Session session = newSession ? newSession() : getCurrentSession();
		// if (newSession)
		// session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setBoolean("enable", false);
		query.setString("token", token);
		query.executeUpdate();
		if (newSession) {
			// session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public void setUserDisnableState(String username) {
		// TODO Auto-generated method stub
		String hql = "update UserToken set enable=:enable where username=:username";
		Session session = getCurrentSession();
		Query query = session.createQuery(hql);
		query.setBoolean("enable", false);
		query.setString("username", username);
		query.executeUpdate();
	}

	@Override
	public UserToken getUserTokenByToken(String token) {
		// TODO Auto-generated method stub
		String hql = "from UserToken where userToken=:token and enable=:enable";
		Query query = getCurrentSession().createQuery(hql);
		query.setBoolean("enable", true);
		query.setString("token", token);
		List<UserToken> list = query.list();
		if (list != null && list.size() > 0) {
			UserToken userToken = list.get(0);
			if (userToken.isEnable())
				return userToken;
		}
		return null;
	}

	@Override
	public void setDisnableState(String token) {
		// TODO Auto-generated method stub
		setDisnableState(token, false);
	}

	@Override
	public void create(String token, String secrect) {
		// TODO Auto-generated method stub
		create(token, secrect, false);
	}

	@Override
	public void updateUserTokenDisnable(String token) {
		// TODO Auto-generated method stub
		String str[] = token.split("_");
		String username = str[0];
		String userSys = str[2];
		String sql1 = "update tb_user_token set enable=0  where  username='"
				+ username + "'" + " and userSys='" + userSys + "'";
		getCurrentSession().createSQLQuery(sql1).executeUpdate();
	}

	@Override
	public void createUserToken(String token, String secrect) {
		// TODO Auto-generated method stub
		String str[] = token.split("_");
		String username = str[0];
		String userSys = str[2];
		String sql2 = "insert into tb_user_token(username,userToken,userSys,tokenSecret,enable) values('"
				+ username
				+ "','"
				+ token
				+ "','"
				+ userSys
				+ "','"
				+ secrect
				+ "',1)";
		getCurrentSession().createSQLQuery(sql2).executeUpdate();
	}

	@Override
	public void updateUserTokenDisnable(String username, String userSys) {
		// TODO Auto-generated method stub
		String sql1 = "update tb_user_token set enable=0  where  username='"
				+ username + "'" + " and userSys='" + userSys + "'";
		getCurrentSession().createSQLQuery(sql1).executeUpdate();
	}

}
