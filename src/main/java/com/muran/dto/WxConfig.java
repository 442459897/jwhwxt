package com.muran.dto;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

@ApiModel
public class WxConfig {

	private boolean debug;
	private String appId;
    private int timestamp;
    private String noncestr;
    private String signature; 
	private List<String> jsApiList = new ArrayList<String>();
	/**
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}
	/**
	 * @param debug the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * @return the timestamp
	 */
	public int getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the noncestr
	 */
	public String getNoncestr() {
		return noncestr;
	}
	/**
	 * @param noncestr the noncestr to set
	 */
	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @return the jsApiList
	 */
	public List<String> getJsApiList() {
		return jsApiList;
	}
	/**
	 * @param jsApiList the jsApiList to set
	 */
	public void setJsApiList(List<String> jsApiList) {
		this.jsApiList = jsApiList;
	}
	
}
