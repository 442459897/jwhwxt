package com.muran.dao.imp;

import com.muran.dao.IColumnConfigDao;
import com.muran.model.ColumnConfig;
import com.muran.model.ColumnItem;
import org.springframework.stereotype.Repository;

/**
 * Created by wxz on 16/10/17.
 */
@Repository("ColumnConfigDao")
@SuppressWarnings("unchecked")
public class ColumnConfigDao extends AbstractHibernateDao<ColumnConfig> implements
        IColumnConfigDao{
    public ColumnConfigDao() {
        super();
        setClazz(ColumnConfig.class);
    }
}
