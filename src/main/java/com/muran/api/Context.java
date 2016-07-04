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
}
