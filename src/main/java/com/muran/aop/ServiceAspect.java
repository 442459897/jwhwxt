package com.muran.aop;

import com.muran.api.Context;
import com.muran.api.Session;
import com.muran.api.exception.ServerException;
import com.muran.service.AbstractService;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import com.muran.aop.annotation.ServiceAOP;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

@Aspect
public class ServiceAspect {
    private final static Logger log = Logger.getLogger(ServiceAspect.class);


    @Around(value = "@annotation(com.muran.aop.annotation.ServiceAOP) && @annotation(annotation)")
    public Object around(ProceedingJoinPoint joinPoint,
                         ServiceAOP annotation) throws Throwable {
        log.info("aop: " + joinPoint.getSignature());
        AbstractService service = (AbstractService) joinPoint.getTarget();
        Object[] params = joinPoint.getArgs();
        Context context = null;
        for (Object param : params) {
            if (param instanceof Context) {
                context = (Context) param;
                if (context == null) throw new ServerException(500, "未找到上下文信息");
                if (annotation.requiredLogin() && !service.authentication(context)) {
                    throw new ServerException(401, "用户未登录");
                }
            }
        }
        Object object = joinPoint.proceed();
        //当操作正常返回的时候,更新session信息.
        Session session = context.getSession();
        session.setLastTouchTime(new Date());
        return object;
    }

}
