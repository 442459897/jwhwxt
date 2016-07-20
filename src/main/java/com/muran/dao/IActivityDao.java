package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.dto.ActivityInfo;
import com.muran.dto.SignupWxInfo;
import com.muran.model.Activity;

import com.muran.util.Data;

/**
 * @author jerry.zheng
 * @version 创建时间：2016年7月12日 下午2:04:24 类说明：活动Dao
 * 
 */
public interface IActivityDao extends IOperations<Activity> {
	public Data<Activity> getActivityPageList(Integer pageSize,
			Integer pageIndex, Long startTime, Long endTime, String title,
			String keyword, String status);

	public List<ActivityInfo> getActivityWxList(Integer num, String upOrDown,
			Long time, String title, String keyword);

	public List<SignupWxInfo> getSignupInfo(Long autoId, Integer num,
			String upOrDown, Long time);

	public List<Activity> getRandomList(int num);
	
	
	public List<ActivityInfo> getActivityWxListByOpenId(String openid);

}
