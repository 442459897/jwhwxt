package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import com.muran.dao.IActivityDao;
import com.muran.dto.ActivityInfo;
import com.muran.dto.SignupWxInfo;
import com.muran.model.Activity;
import com.muran.util.Data;
import com.muran.util.DateUtil;

/**
 * @author jerry.zheng
 * @version 创建时间：2016年7月12日 下午2:11:59 类说明
 */
@SuppressWarnings("unchecked")
@Repository("ActivityDao")
public class ActivityDao extends AbstractHibernateDao<Activity> implements
		IActivityDao {

	public ActivityDao() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(Activity.class);
	}

	@Override
	public Data<Activity> getActivityPageList(Integer pageSize,
			Integer pageIndex, Long startTime, Long endTime, String title,
			String keyword, String status) {
		// TODO Auto-generated method stub
		String hql = " from Activity where 1=1 ";
		if (title != null && !title.equals("")) {
			hql += " and title like '%" + title + "%'";
		}
		if (keyword != null && !keyword.equals("")) {
			hql += " and keywords like '%" + keyword + "%'";
		}
		if (status != null && !status.equals("")) {
			hql += " and status = '" + status + "'";
		}
		if (startTime != null) {
			hql += " and publishTime>'"
					+ DateUtil.timestampToDateStr(startTime.toString()) + "'";
		}
		if (endTime != null) {
			hql += " and publishTime<'"
					+ DateUtil.timestampToDateStr(endTime.toString()) + "'";
		}
		
		hql+=" order by publishTime desc, modifyTime desc ";

		Query query = getCurrentSession().createQuery(hql);

		List<Activity> list = query.list();

		Data<Activity> data = new Data<Activity>();

		int totalRecord = list.size();
		query.setFirstResult((pageIndex - 1) * pageSize);
		query.setMaxResults(pageSize);
		list = query.list();
		
		data.setPageIndex(pageIndex);
		data.setPageSize(pageSize);
		data.setTotalRecord(totalRecord);

		data.setData(list);

		return data;
	}

	@Override
	public List<ActivityInfo> getActivityWxList(Integer num, String upOrDown,
			Long time, String title, String keyword) {
		// TODO Auto-generated method stub
		String hql = "SELECT a.autoId,a.title,a.overurl as overUrl,a.hoster,a.startTime,a.endTime,a.location,a.publishTime,a.content,a.signupTop,a.status,a.signStartTime,a.signupEndTime,case when b.signNum is null then 0 else b.signNum end signNum,case when c.commentNum is null then 0 else c.commentNum end commentNum FROM jwhwxt.tb_activity a "
				+ " left join (select count(activity)as signNum,activity from tb_activity_signup group by activity) b on b.activity=a.autoID "
				+ " left join (select count(itemId)as commentNum,itemId from tb_article_comment where columnKey='column_activities' group by itemId)c on c.itemId=a.autoId"
				+ " where 1=1 and a.status=1 ";
		if (title != null && !title.equals("")) {
			hql += " and title like '%" + title + "%'";
		}
		if (keyword != null && !keyword.equals("")) {
			hql += " and a.keywords like '%" + keyword + "%'";
		}
			
		if (time != null) {

			if (upOrDown.equalsIgnoreCase("up")) {
				hql += " and a.publishTime<'"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			} else if (upOrDown.equalsIgnoreCase("down")) {
				hql += " and a.publishTime>'"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			}
		}
		hql += " order by a.publishtime desc limit 0," + num;
		Query query = getCurrentSession().createSQLQuery(hql)
				.setResultTransformer(
						Transformers.aliasToBean(ActivityInfo.class));
		List<ActivityInfo> list = query.list();

		return list;
	}

	@Override
	public List<SignupWxInfo> getSignupInfo(Long autoId, Integer num,
			String upOrDown, Long time) {
		// TODO Auto-generated method stub
		String hql = "select a.activity,w.nickName,w.headImg,a.signupTime from tb_activity_signup a "
				+ " left join tb_wechat_user w on a.openId=w.openId"
				+ " where 1=1 ";
		if (autoId != null) {
			hql += " and activity =" + autoId;
		}

		if (time != null) {

			if (upOrDown.equalsIgnoreCase("up")) {
				hql += " and signuptime<'"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			} else if (upOrDown.equalsIgnoreCase("down")) {
				hql += " and signuptime>'"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			}
		}

		hql += " order by signuptime desc limit 0," + num;
		Query query = getCurrentSession().createSQLQuery(hql)
				.setResultTransformer(
						Transformers.aliasToBean(SignupWxInfo.class));
		List<SignupWxInfo> list = query.list();

		return list;
	}

	@Override
	public List<Activity> getRandomList(int num) {
		// TODO Auto-generated method stub
		String hql = " from Activity where 1=1 ";
		hql += " order by rand() ";
		Query query = getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(num);
		return query.list();
	}

	@Override
	public  List<ActivityInfo> getActivityWxListByOpenId(Integer num, String upOrDown,
			Long time,String openid) {
		String hql = "SELECT a.autoId,a.title,a.overurl as overUrl,a.hoster,a.startTime,a.endTime,a.location,a.publishTime,a.content,a.signupTop,a.status,a.signupStartTime,a.signupEndTime,case when b.signNum is null then 0 else b.signNum end signNum,case when c.commentNum is null then 0 else c.commentNum end commentNum FROM jwhwxt.tb_activity a "
				+ " left join (select count(activity)as signNum,activity from tb_activity_signup group by activity) b on b.activity=a.autoID "
				+ " left join (select count(itemId)as commentNum,itemId from tb_article_comment where columnKey='column_activities' group by itemId)c on c.itemId=a.autoId"
				+ " left join tb_activity_signup s on s.activity=a.autoId	"
				+ " where 1=1 and a.status=1  ";
		if (openid != null && !openid.equals("")) {
			hql += " and s.openid='"+openid+"'";
		}
		if (time != null) {

			if (upOrDown.equalsIgnoreCase("up")) {
				hql += " and a.publishTime<'"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			} else if (upOrDown.equalsIgnoreCase("down")) {
				hql += " and a.publishTime>'"
						+ DateUtil.timestampToDateStr(time.toString()) + "'";
			}
		}

		hql += " order by a.publishtime desc limit 0," + num;
		Query query = getCurrentSession().createSQLQuery(hql)
				.setResultTransformer(
						Transformers.aliasToBean(ActivityInfo.class));
		List<ActivityInfo> list = query.list();

		return list;
	}

}
