/**
 * 
 */
package com.muran.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author wxz
 * 
 */
@Entity
@Table(name = "TB_WECHAT_USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "openid" }) })
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class WeChatUser implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public WeChatUser() {
		// TODO Auto-generated constructor stub
	}

	private long autoId;
	private String openId;
	private String nickName;
	private String headImg;
	private boolean watched;
	private String sessionId;
	private Date expireTime;

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
	 * @param autoId
	 *            the autoId to set
	 */
	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}

	/**
	 * @return the openId
	 */
	@Column(name = "openId", length = 100)
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
	 * @return the nickName
	 */
	@Column(name = "nickName", length = 50)
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the headImg
	 */
	@Column(name = "headImg", length = 300)
	public String getHeadImg() {
		return headImg;
	}

	/**
	 * @param headImg
	 *            the headImg to set
	 */
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	/**
	 * @return the watched
	 */
	@Column(name = "watched")
	public boolean isWatched() {
		return watched;
	}

	/**
	 * @param watched
	 *            the watched to set
	 */
	public void setWatched(boolean watched) {
		this.watched = watched;
	}

	/**
	 * @param autoId
	 * @param openId
	 * @param nickName
	 * @param headImg
	 * @param watched
	 */
	public WeChatUser(long autoId, String openId, String nickName,
			String headImg, boolean watched) {
		super();
		this.autoId = autoId;
		this.openId = openId;
		this.nickName = nickName;
		this.headImg = headImg;
		this.watched = watched;
	}

	/**
	 * @return the sessionId
	 */
	@Column(length = 100)
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the expireTime
	 */
	@Column(name = "expireTime")
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime
	 *            the expireTime to set
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

}
