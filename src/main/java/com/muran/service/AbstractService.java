package com.muran.service;

import com.muran.api.Context;
import com.muran.api.Session;
import com.muran.api.exception.ServerException;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class AbstractService {


    protected Logger log ;

    public AbstractService() {
        log = Logger.getLogger(this.getClass());
    }


    /**
     * 用于判断必填参数是否为空,如果存在kong参数,抛出400异常
     * @param para
     */
    protected void assertNull(Object ... para){
        for(Object o : para){
            if(o == null) throw new ServerException(400,"请检查入参Key是否正确或必填参数的Value是否为空.");
        }
    }

    /**
     * 用于判断用户是否登录,是否有权限操作.
     */
    public boolean authentication(Context context){
        Session session = context.getSession();
        if(session == null) return  false;
        if(session.getUserInfo() == null) return false;
        return true;
    }
}