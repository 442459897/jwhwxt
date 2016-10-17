package com.muran.dao;

import com.muran.dao.operation.IOperations;
import com.muran.model.VisitRecord;

import java.util.List;

/**
 * Created by wxz on 16/10/17.
 */
public interface IVisitRecordDao extends IOperations<VisitRecord> {

    boolean isUserVisitedArticle(String columnKey,Long articleId,String openId);
}
