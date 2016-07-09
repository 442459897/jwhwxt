package com.muran.dto;

import java.util.List;


public class WxMenu implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<WxButton> button;

	/**
	 * @return the button
	 */
	public List<WxButton> getButton() {
		return button;
	}

	/**
	 * @param button the button to set
	 */
	public void setButton(List<WxButton> button) {
		this.button = button;
	}
}
