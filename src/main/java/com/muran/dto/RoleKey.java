package com.muran.dto;

import java.io.Serializable;

public class RoleKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String autoId;
	private String roleName;
	private String keyCode;
	private boolean enable;//是否禁用
	
	public RoleKey(){
		
	}
	
	/**
	 * @return the autoId
	 */
	public String getAutoId() {
		return autoId;
	}
	/**
	 * @param autoId the autoId to set
	 */
	public void setAutoId(String autoId) {
		this.autoId = autoId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the keyCode
	 */
	public String getKeyCode() {
		return keyCode;
	}
	/**
	 * @param keyCode the keyCode to set
	 */
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
