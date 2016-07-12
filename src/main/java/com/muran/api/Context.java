package com.muran.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Steven on 4/29/16.
 * 请求的上下文信息,每次都出去服务层
 */
public class Context {
    private Session session;
    private ClientInfo clientInfo;
    private Map<String,Object> keyValues = new HashMap<String,Object>();
    
    private String userToken;
    private String username;
    
    private String sessionId;
    private Boolean sessionIsExpire;
    private String openId;
    
    private String userSys;

    public void put(String key,Object value){
        keyValues.put(key,value);
    }
    public Object get(String key){
        return keyValues.get(key);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public Map<String, Object> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(Map<String, Object> keyValues) {
        this.keyValues = keyValues;
    }
	/**
	 * @return the userToken
	 */
	public String getUserToken() {
		return userToken;
	}
	/**
	 * @param userToken the userToken to set
	 */
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * @return the userSys
	 */
	public String getUserSys() {
		return userSys;
	}
	/**
	 * @param userSys the userSys to set
	 */
	public void setUserSys(String userSys) {
		this.userSys = userSys;
	}
	/**
	 * @return the sessionIsExpire
	 */
	public Boolean getSessionIsExpire() {
		return sessionIsExpire;
	}
	/**
	 * @param sessionIsExpire the sessionIsExpire to set
	 */
	public void setSessionIsExpire(Boolean sessionIsExpire) {
		this.sessionIsExpire = sessionIsExpire;
	}
}
