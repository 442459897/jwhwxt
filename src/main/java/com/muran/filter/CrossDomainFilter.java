package com.muran.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;

import org.apache.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;

/**
 * @author Steven 2015年6月11日 设置可以跨域访问
 *         <p>
 *         brower 首先访问的时候用Option方法获取是否允许跨域
 *         当放回200，浏览器会再次发送真正的业务请求，如果option返回不是200
 *         ，有些浏览器（chrome)就不发送业务请求了。所以一定要保证，option返回时200.
 */

public class CrossDomainFilter extends GenericFilterBean {
    private final static Logger log = Logger.getLogger(CrossDomainFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (request.getMethod().equals(HttpMethod.OPTIONS)) {
            log.info("跨域Option调用");
            response.setHeader("Access-Control-Allow-Methods",
                    "POST, GET, OPTIONS, DELETE,PUT");
            response.setHeader("Access-Control-Max-Age", "3600000000000");
            response.setHeader("Access-Control-Allow-Headers",
                    "X-Requested-With,session-id,client-ip,client-key,client-net-env,Content-Type,version,open-id");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
