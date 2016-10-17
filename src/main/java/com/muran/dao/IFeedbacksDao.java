package com.muran.dao;

import java.util.List;

import com.muran.dao.operation.IOperations;
import com.muran.model.FeedBack;
import com.muran.util.Data;

/**
 * @author jerry.zheng
 * @version 创建时间：2016年7月13日 下午4:55:29 类说明
 */
public interface IFeedbacksDao extends IOperations<FeedBack> {
    public List<FeedBack> getFeedbackInfo(Long num, String upOrDown, Long time);

    public List<FeedBack> getFeedbackInfo(Long num, String upOrDown, Long time, String openId);

    public List<FeedBack> getFeedbackInfo(Long num, String upOrDown, Long time, Integer status, String openId);

    public Data<FeedBack> getFeedbackInfoPageList(Integer pageSize, Integer pageIdex, Long startTime, Long endTime);

}
