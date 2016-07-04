package com.muran.api.exception.handler;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.muran.api.exception.ServerException;
import com.muran.dto.Error;
import org.apache.log4j.Logger;

/**
 * 统一异常处理器
 */
@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Exception> {
    private static final Logger log = Logger
            .getLogger(ExceptionMapperSupport.class);

    /**
     * 异常处理
     *
     * @param ex
     * @return 异常处理后的Response对象
     */
    public Response toResponse(Exception ex) {
        log.info("拦截到异常: " + ex.getClass().getSimpleName());
        ServerException be = null;
        if (ex instanceof ServerException) {
            be = (ServerException) ex;
        } else if (ex instanceof WebApplicationException) {
            final WebApplicationException webApplicationException = (WebApplicationException) ex;
            be = new ServerException(webApplicationException.getResponse().getStatus(),webApplicationException.getMessage(),webApplicationException);
        } else {
            be = new ServerException(500, "系统正在维护,请稍后再试",ex);
        }
        if (be.getThrowable() != null) {
            log.error("服务器异常,请运维处理:");
            be.getThrowable().printStackTrace();
            StackTraceElement[] error = be.getThrowable().getStackTrace();
            for(StackTraceElement element : error){
                log.error(element.toString());
            }
        }

        return Response
                .ok(new Error().code(be.getCode()).info(be.getInfo()),
                        MediaType.APPLICATION_JSON).status(be.getCode())
                .build();
    }
}
