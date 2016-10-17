package com.muran.dao.imp;

import com.muran.dao.IFeedbacksDao;
import com.muran.dao.IVisitRecordDao;
import com.muran.model.FeedBack;
import com.muran.model.VisitRecord;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wxz on 16/10/17.
 */
@SuppressWarnings("unchecked")
@Repository("VisitRecordDao")
public class VisitRecordDao extends AbstractHibernateDao<VisitRecord> implements
        IVisitRecordDao {

    public VisitRecordDao() {
        super();
        setClazz(VisitRecord.class);
    }

    @Override
    public boolean isUserVisitedArticle(String columnKey, Long articleId, String openId) {

        String hql = " from VisitRecord where columnKey='" + columnKey + "' and articleId=" + articleId + " and openId='" + openId + "'";
        Query query = getCurrentSession().createQuery(hql);
        List<VisitRecord> list = query.list();
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }
}
