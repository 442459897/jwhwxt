package com.muran.api.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muran.api.Context;
import com.muran.api.exception.AssertNull;
import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.api.service.ActivitiesApiService;
import com.muran.dao.IActivityDao;
import com.muran.dao.IActivitySignUpDao;
import com.muran.dto.ActivityInfo;
import com.muran.dto.AddActivity;
import com.muran.dto.SignupActivity;
import com.muran.dto.SignupWxInfo;
import com.muran.model.Activity;
import com.muran.model.ActivitySignup;
import com.muran.util.Data;

@Service
public class ActivitiesApiServiceImp implements ActivitiesApiService {

	private final static Logger log = Logger.getLogger(ActivitiesApiServiceImp.class);
	@Resource(name = "ActivityDao")
	private IActivityDao activityDao;

	@Resource(name = "ActivitySignupDao")
	private IActivitySignUpDao signupDao;

	/**
	 * 
	 * 添加活动
	 **/
	@Override
	@Transactional
	public Response addActivity(AddActivity activity, Context context) {
		// TODO Auto-generated method stub
		Activity model = new Activity();
		AssertNull.assertNull(activity.getTitle(), activity.getKeywords(), activity.getStartTime(),
				activity.getEndTime(), activity.getSignupEndTime(), activity.getCoverUrl(),
				activity.getSignupTop(), activity.getHoster(),activity.getContent());
		model.setTitle(activity.getTitle());
		model.setContent(activity.getContent());
		model.setStartTime(activity.getStartTime());
		model.setEndTime(activity.getEndTime());
		model.setLocation(activity.getLocation());
		model.setKeywords(activity.getKeywords());
		model.setSignupEndTime(activity.getSignupEndTime());
		model.setOverUrl(activity.getCoverUrl());
		model.setSignupTop(activity.getSignupTop().longValue());
		model.setHoster(activity.getHoster());
		model.setStatus(Long.parseLong(activity.getStatus().toString()));

		model.setCreateTime(new Date());
		model.setCreateUser(context.getUsername());
		model.setEnable(true);

		model = activityDao.merge(model);
		return Response.ok().entity(model).build();
	}

	/**
	 * 根据活动id，删除活动
	 */
	@Override
	@Transactional
	public Response deleteActivity(Long autoId, Context context) {
		// TODO Auto-generated method stub
		Activity model = new Activity();
		model = activityDao.findOne(autoId);
		if (model == null) {
			throw new ServerException(Code.ActivityNoExisted, "活动不存在！");
		}
		activityDao.deleteById(autoId);
		return Response.ok().build();
	}

	/**
	 * 根据id,获取活动信息
	 */
	@Override
	@Transactional
	public Response getActivity(Long autoId, Context context) {
		// TODO Auto-generated method stub
		Activity model = new Activity();
		model = activityDao.findOne(autoId);
		if (model == null) {
			throw new ServerException(Code.ActivityNoExisted, "活动不存在！");
		}
		return Response.ok().entity(model).build();
	}

	/**
	 * 分页查询（后台）
	 */
	@Override
	@Transactional
	public Response getActivityPageList(Integer pageSize, Integer pageIndex, Long startTime, Long endTime, String title,
			String keyword, String status, Context context) {
		// TODO Auto-generated method stub
		AssertNull.assertNull(pageIndex, pageSize);
		Data<Activity> data = activityDao.getActivityPageList(pageSize, pageIndex, startTime, endTime, title, keyword,
				status);
		return Response.ok().entity(data).build();
	}

	/**
	 * 微信端：获取list
	 */
	@Override
	@Transactional
	public Response getActivityWxList(Integer num, String upOrDown, Long time, String title, String keyword,
			Context context) {
		// TODO Auto-generated method stub
		if (num==null) {
			num= 10;
		}
		List<ActivityInfo> list = activityDao.getActivityWxList(num, upOrDown, time, title, keyword);
		return Response.ok().entity(list).build();
	}

	/**
	 * 微信端：获取报名信息
	 */
	@Override
	@Transactional
	public Response getSignupInfo(Long autoId, Integer num, String upOrDown, Long time, Context context) {
		if (num==null) {
			num=10;
		}
		List<SignupWxInfo> list = activityDao.getSignupInfo(autoId, num, upOrDown, time);
		return Response.ok().entity(list).build();
	}

	/**
	 * 后台：获取报名信息分页
	 **/
	@Override
	@Transactional
	public Response getSignupInfoPageList(Long autoId, Integer pageSize, Integer pageIndex, Context context) {
		AssertNull.assertNull(pageIndex, pageSize);
		Data<ActivitySignup> data = signupDao.getActivitySignupPageList(autoId, pageSize, pageIndex);
		return Response.ok().entity(data).build();
	}

	/**
	 * 活动报名
	 */
	@Override
	@Transactional
	public Response signupActivity(Long autoId, SignupActivity signupinfo, Context context) {
		AssertNull.assertNull(signupinfo.getActivity(), signupinfo.getMobile(), context.getOpenId(),
				signupinfo.getName());
		Activity model = new Activity();
		model = activityDao.findOne(autoId);
		if (model == null) {
			throw new ServerException(Code.ActivityNoExisted, "活动不存在！");
		}
		if (model.getSignupTop() <= signupDao.getSignUpNum(autoId)) {
			throw new ServerException(Code.SignUpTopOver, "报名已满");
		}

		ActivitySignup signup = new ActivitySignup();
		// 重复检查
		signup = signupDao.getOneByOpenId(autoId, context.getOpenId());
		if (signup != null) {
			throw new ServerException(Code.DataExisted, "已报名");
		}
		signup = new ActivitySignup();
		signup.setActivity(autoId);
		signup.setGender(signupinfo.getGender());
		signup.setMobile(signupinfo.getMobile());
		signup.setName(signupinfo.getName());
		signup.setOpenId(context.getOpenId());
		signup.setRemark(signupinfo.getRemark());
		signup.setSignupTime(new Date());
		signup = signupDao.merge(signup);

		return Response.ok().entity(signup).build();
	}

	/**
	 * 收回活动
	 */
	@Override
	@Transactional
	public Response backActivity(Long autoId, Context context) {
		// TODO Auto-generated method stub
		Activity model = new Activity();
		model = activityDao.findOne(autoId);
		if (model == null) {
			throw new ServerException(Code.ActivityNoExisted, "活动不存在！");
		}
		model.setStatus(Long.parseLong("2"));
		model.setBackTime(new Date());
		model.setBackMan(context.getUsername());

		model = activityDao.update(model);

		return Response.ok().entity(model).build();
	}

	/**
	 * 发布活动
	 */
	@Override
	@Transactional
	public Response publishActivity(Long autoId, Context context) {
		// TODO Auto-generated method stub
		Activity model = new Activity();
		model = activityDao.findOne(autoId);
		if (model == null) {
			throw new ServerException(Code.ActivityNoExisted, "活动不存在！");
		}
		model.setPublishMan(context.getUsername());
		model.setPublishTime(new Date());
		model.setStatus(Long.parseLong("1"));// 0，1发布，2收回

		model = activityDao.update(model);

		return Response.ok().entity(model).build();
	}

	/**
	 * 更新活动信息
	 */
	@Override
	@Transactional
	public Response updateActivity(Long autoId, AddActivity activity, Context context) {
		AssertNull.assertNull(activity.getTitle(), activity.getClass(), activity.getKeywords(), activity.getStartTime(),
				activity.getEndTime(), activity.getEndTime(), activity.getSignupEndTime(), activity.getCoverUrl(),
				activity.getSignupTop(), activity.getHoster());

		Activity model = new Activity();
		model = activityDao.findOne(autoId);
		if (model == null) {
			throw new ServerException(Code.ActivityNoExisted, "活动不存在！");
		}
		model.setTitle(activity.getTitle());
		model.setContent(activity.getContent());
		model.setStartTime(activity.getStartTime());
		model.setEndTime(activity.getEndTime());
		model.setLocation(activity.getLocation());
		model.setKeywords(activity.getKeywords());
		model.setSignupEndTime(activity.getSignupEndTime());
		model.setOverUrl(activity.getCoverUrl());
		model.setSignupTop(activity.getSignupTop().longValue());
		model.setHoster(activity.getHoster());
		model.setStatus(activity.getStatus().longValue());

		model.setModifyTime(new Date());
		model.setModifyUser(context.getUsername());

		model = activityDao.update(model);

		return Response.ok().entity(model).build();
	}

	@Override
	@Transactional
	public Response getSignupNum(Long autoId) {
		// TODO Auto-generated method stub
		int num=signupDao.getSignUpNum(autoId);
		return Response.ok().entity(num).build();
	}

	@Override
	@Transactional
	public Response getMySignup(Integer num,String upOrDown,Long time,Context context) {
		AssertNull.assertNull(context.getOpenId());
		
		List<ActivityInfo> result=new ArrayList<ActivityInfo>();
		if (num==null) {
			num=10;
		}
		
		result=activityDao.getActivityWxListByOpenId(num, upOrDown, time, context.getOpenId());
		return Response.ok().entity(result).build();
	}

}
