package com.muran.dto;

public class FileObject implements java.io.Serializable {
	private String data;

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @param data
	 */
	public FileObject(String data) {
		super();
		this.data = data;
	}
}
