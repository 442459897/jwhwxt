package com.muran.api;

import com.muran.api.exception.ServerException;

import java.util.Date;

/**
 * Created by Steven on 4/29/16.
 * 模拟session
 */
public class Session {
    private String id;
    private Object UserInfo;
    private Date createTime;
    private Date lastTouchTime;
    ClientInfo clientInfo;

    private final static int validTimeInterval = 10 * 60 * 1000;

    public boolean isValid() {
        return (new Date().getTime() - lastTouchTime.getTime()) < validTimeInterval;//十分钟有效
    }

    public Session() {
    }

    public Session(String id) {
        this.id = id;
        this.createTime = new Date();
        this.lastTouchTime = new Date();
    }

    /**
     * 这个是session建立的时候的客户端信息.
     *
     * @return
     */
    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getUserInfo() {
        if(UserInfo==null) throw new ServerException(401,"请重新登录");
        return UserInfo;
    }

    public void setUserInfo(Object userInfo) {
        UserInfo = userInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTouchTime() {
        return lastTouchTime;
    }

    public void setLastTouchTime(Date lastTouchTime) {
        this.lastTouchTime = lastTouchTime;
    }
}
