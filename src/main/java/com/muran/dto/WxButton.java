package com.muran.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
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
	@JsonInclude(JsonInclude.Include.NON_NULL)
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
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public List<WxSubButton> getSub_button() {
		return sub_button;
	}
	/**
	 * @param sub_button the sub_button to set
	 */
	public void setSub_button(List<WxSubButton> sub_button) {
		this.sub_button = sub_button;
	}
	
	private String type;
	private String url;
	private String key;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getUrl() {
		return url;
	}

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
