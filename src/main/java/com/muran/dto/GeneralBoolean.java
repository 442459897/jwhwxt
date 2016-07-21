package com.muran.dto;

public class GeneralBoolean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Boolean data;

	/**
	 * @return the data
	 */
	public Boolean getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Boolean data) {
		this.data = data;
	}

	/**
	 * @param data
	 */
	public GeneralBoolean(Boolean data) {
		super();
		this.data = data;
	}
}
