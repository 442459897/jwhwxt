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
@Table(name = "TB_REPLY")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class Reply implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	private Long autoId;
	private Long type;// 0 留言 1 我有话说
	private String content;
	private Long message;// 对象id
	private Long reply;// 回复id
	private Long replyType;// 回复方 0：居委会 1:用户
	private String username;
	private String openId;
	private Long status;
	private Boolean enable;
	private Date replyTime = new Date();
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
	 * @return the type
	 */
	public Long getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Long type) {
		this.type = type;
	}
	/**
	 * @return the content
	 */
	@Column(name = "content", length = 200)
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the message
	 */
	public Long getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(Long message) {
		this.message = message;
	}
	/**
	 * @return the reply
	 */
	public Long getReply() {
		return reply;
	}
	/**
	 * @param reply the reply to set
	 */
	public void setReply(Long reply) {
		this.reply = reply;
	}
	/**
	 * @return the replyType
	 */
	public Long getReplyType() {
		return replyType;
	}
	/**
	 * @param replyType the replyType to set
	 */
	public void setReplyType(Long replyType) {
		this.replyType = replyType;
	}
	/**
	 * @return the username
	 */
	@Column(name = "username", length = 50)
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the openId
	 */
	@Column(name = "openId", length = 50)
	public String getOpenId() {
		return openId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
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
	 * @param enable the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	/**
	 * @return the replyTime
	 */
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getReplyTime() {
		return replyTime;
	}
	/**
	 * @param replyTime the replyTime to set
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	/**
	 * @param autoId
	 * @param type
	 * @param content
	 * @param message
	 * @param reply
	 * @param replyType
	 * @param username
	 * @param openId
	 * @param status
	 * @param enable
	 * @param replyTime
	 */
	public Reply(Long autoId, Long type, String content, Long message,
			Long reply, Long replyType, String username, String openId,
			Long status, Boolean enable, Date replyTime) {
		super();
		this.autoId = autoId;
		this.type = type;
		this.content = content;
		this.message = message;
		this.reply = reply;
		this.replyType = replyType;
		this.username = username;
		this.openId = openId;
		this.status = status;
		this.enable = enable;
		this.replyTime = replyTime;
	}

}
