package com.muran.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_COLUMN_ITEM")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class ColumnItem implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ColumnItem() {
		// TODO Auto-generated constructor stub
	}
	
	private long autoId;
	private String name;
	private String columnKey;
	private String type;
	private boolean isPoster;
	private boolean isShowPoster;
	private String posterUrl;
	private long parentId;
	private String url;
	private String outUrl;
	private Date modifyTime;
	private String modifyMan;

	/**
	 * @return the autoId
	 */
	@Id
	@GeneratedValue
	@Column(name = "autoId", unique = true, nullable = false)
	public long getAutoId() {
		return autoId;
	}
	/**
	 * @param autoId the autoId to set
	 */
	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}
	/**
	 * @return the name
	 */
	@Column(name = "name", length = 100)
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
	 * @return the columnKey
	 */
	@Column(name = "columnKey", length = 100)
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
	 * @return the type
	 */
	@Column(name = "type", length = 100)
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
	 * @return the isPoster
	 */
	@Column(name = "isPoster")
	public boolean isPoster() {
		return isPoster;
	}
	/**
	 * @param isPoster the isPoster to set
	 */
	public void setPoster(boolean isPoster) {
		this.isPoster = isPoster;
	}
	/**
	 * @return the isShowPoster
	 */
	@Column(name = "isShowPoster")
	public boolean isShowPoster() {
		return isShowPoster;
	}
	/**
	 * @param isShowPoster the isShowPoster to set
	 */
	public void setShowPoster(boolean isShowPoster) {
		this.isShowPoster = isShowPoster;
	}
	/**
	 * @return the posterUrl
	 */
	@Column(name = "posterUrl", length = 300)
	public String getPosterUrl() {
		return posterUrl;
	}
	/**
	 * @param posterUrl the posterUrl to set
	 */
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	/**
	 * @return the parentId
	 */
	@Column(name = "parentId")
	public long getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the url
	 */
	@Column(name = "url", length = 300)
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
	 * @return the outUrl
	 */
	@Column(name = "outUrl", length = 500)
	public String getOutUrl() {
		return outUrl;
	}
	/**
	 * @param outUrl the outUrl to set
	 */
	public void setOutUrl(String outUrl) {
		this.outUrl = outUrl;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the modifyMan
	 */
	public String getModifyMan() {
		return modifyMan;
	}
	/**
	 * @param modifyMan the modifyMan to set
	 */
	public void setModifyMan(String modifyMan) {
		this.modifyMan = modifyMan;
	}
	/**
	 * @param autoId
	 * @param name
	 * @param columnKey
	 * @param type
	 * @param isPoster
	 * @param isShowPoster
	 * @param posterUrl
	 * @param parentId
	 * @param url
	 * @param outUrl
	 * @param modifyTime
	 * @param modifyMan
	 */
	public ColumnItem(long autoId, String name, String columnKey, String type,
			boolean isPoster, boolean isShowPoster, String posterUrl,
			long parentId, String url, String outUrl, Date modifyTime,
			String modifyMan) {
		super();
		this.autoId = autoId;
		this.name = name;
		this.columnKey = columnKey;
		this.type = type;
		this.isPoster = isPoster;
		this.isShowPoster = isShowPoster;
		this.posterUrl = posterUrl;
		this.parentId = parentId;
		this.url = url;
		this.outUrl = outUrl;
		this.modifyTime = modifyTime;
		this.modifyMan = modifyMan;
	}
	
	

}
