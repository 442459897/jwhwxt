package com.muran.dto;

import java.util.List;


public class WxButton implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private List<WxSubButton> sub_button;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sub_button
	 */
	public List<WxSubButton> getSub_button() {
		return sub_button;
	}
	/**
	 * @param sub_button the sub_button to set
	 */
	public void setSub_button(List<WxSubButton> sub_button) {
		this.sub_button = sub_button;
	}
}
