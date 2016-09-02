package com.muran.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
public class WxSubButton implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String name;
	private String url;
	private String key;
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
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
	 * @return the url
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
