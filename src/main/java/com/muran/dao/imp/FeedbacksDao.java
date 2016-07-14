package com.muran.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.muran.dao.IFeedbacksDao;
import com.muran.model.Activity;
import com.muran.model.FeedBack;
import com.muran.util.Data;
import com.muran.util.DateUtil;

/**
 * @author jerry.zheng
 * @version 创建时间：2016年7月13日 下午4:56:30 类说明
 */
@SuppressWarnings("unchecked")
@Repository("FeedbacksDao")
public class FeedbacksDao extends AbstractHibernateDao<FeedBack>implements IFeedbacksDao {

	public FeedbacksDao() {
		super();
		setClazz(FeedBack.class);
	}

	@Override
	public List<FeedBack> getFeedbackInfo(Long num, String upOrDown, Long time) {
		String hql = " from FeedBack where 1=1 ";

		if (time != null) {

			if (upOrDown.equalsIgnoreCase("up")) {
				hql += " and sayTime<'" + DateUtil.timestampToDateStr(time.toString()) + "'";
			} else if (upOrDown.equalsIgnoreCase("down")) {
				hql += " and sayTime>'" + DateUtil.timestampToDateStr(time.toString()) + "'";
			}
		}
		hql+=" order by sayTime DESC";
		Query query = getCurrentSession().createQuery(hql);
		query.setFirstResult(1); 
		query.setMaxResults(Integer.parseInt(num.toString())); 
		List<FeedBack> list = query.list();
		return list;
	}

	@Override
	public Data<FeedBack> getFeedbackInfoPageList(Integer pageSize, Integer pageIdex, Long startTime, Long endTime) {
		String hql = " from FeedBack where 1=1 ";

		if (startTime != null) {
			hql += " and sayTime>'" + DateUtil.timestampToDateStr(startTime.toString()) + "'";
		}
		if (endTime != null) {
			hql += " and sayTime<'" + DateUtil.timestampToDateStr(endTime.toString()) + "'";
		}
		hql+=" order by sayTime DESC";
		Query query = getCurrentSession().createQuery(hql);

		List<FeedBack> list = query.list();

		Data<FeedBack> data = new Data<FeedBack>();

		int totalRecord = list.size();
		query.setFirstResult((pageIdex - 1) * pageSize);
		query.setMaxResults(pageSize);
		list = query.list();

		data.setPageIndex(pageIdex);
		data.setPageSize(pageSize);
		data.setTotalRecord(totalRecord);

		data.setData(list);

		return data;
	}
}
