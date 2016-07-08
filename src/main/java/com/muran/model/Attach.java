package com.muran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_ATTACH")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class Attach implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Attach() {
		// TODO Auto-generated constructor stub
	}

	private Long autoId ;
	private String columnKey ;
	private Long itemId ;
	private String url ;
	private String extension ;
	private Boolean enable;
	/**
	 * @return the autoId
	 */
	@Id
	@GeneratedValue
	@Column(name = "autoId", unique = true, nullable = false)
	public Long getAutoId() {
		return autoId;
	}
	/**
	 * @param autoId the autoId to set
	 */
	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}
	/**
	 * @return the columnKey
	 */
	@Column(name = "columnKey", length = 50)
	public String getColumnKey() {
		return columnKey;
	}
	/**
	 * @param columnKey the columnKey to set
	 */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	/**
	 * @return the itemId
	 */
	@Column(name = "itemId")
	public Long getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the url
	 */
	@Column(name = "url",length=300)
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the extension
	 */
	@Column(name = "extension",length=20)
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * @return the enable
	 */
	@Column(name = "enable")
	public Boolean getEnable() {
		return enable;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	/**
	 * @param autoId
	 * @param columnKey
	 * @param itemId
	 * @param url
	 * @param extension
	 * @param enable
	 */
	public Attach(Long autoId, String columnKey, Long itemId, String url,
			String extension, Boolean enable) {
		super();
		this.autoId = autoId;
		this.columnKey = columnKey;
		this.itemId = itemId;
		this.url = url;
		this.extension = extension;
		this.enable = enable;
	}

}
