package com.muran.dto;

public class SignupStatus implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isSignup;
	
	private boolean  enable;
	
	private String showInfo;

	/**
	 * @return the isSignup
	 */
	public boolean isSignup() {
		return isSignup;
	}

	/**
	 * @param isSignup the isSignup to set
	 */
	public void setSignup(boolean isSignup) {
		this.isSignup = isSignup;
	}

	/**
	 * @return the showInfo
	 */
	public String getShowInfo() {
		return showInfo;
	}

	/**
	 * @param showInfo the showInfo to set
	 */
	public void setShowInfo(String showInfo) {
		this.showInfo = showInfo;
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
