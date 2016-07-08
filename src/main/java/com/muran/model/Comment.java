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
@Table(name = "TB_ARTICLE_COMMENT")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class Comment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	private Long autoId;
	private String columnKey;
	private Long itemId;
	private String content;
	private String openId;
	private Date commentTime = new Date();
	private Long status;
	private Boolean enable = true;

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
	 * @param autoId
	 *            the autoId to set
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
	 * @param columnKey
	 *            the columnKey to set
	 */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	/**
	 * @return the itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the content
	 */
	@Column(name = "content", length = 500)
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the openId
	 */
	@Column(name = "openId", length = 50)
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId
	 *            the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * @return the commentTime
	 */
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getCommentTime() {
		return commentTime;
	}

	/**
	 * @param commentTime
	 *            the commentTime to set
	 */
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	/**
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}

	/**
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * @param autoId
	 * @param columnKey
	 * @param itemId
	 * @param content
	 * @param openId
	 * @param commentTime
	 * @param status
	 * @param enable
	 */
	public Comment(Long autoId, String columnKey, Long itemId, String content,
			String openId, Date commentTime, Long status, Boolean enable) {
		super();
		this.autoId = autoId;
		this.columnKey = columnKey;
		this.itemId = itemId;
		this.content = content;
		this.openId = openId;
		this.commentTime = commentTime;
		this.status = status;
		this.enable = enable;
	}

}
