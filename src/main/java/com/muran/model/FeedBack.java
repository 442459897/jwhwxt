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
@Table(name = "TB_FEEDBACK")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class FeedBack implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long autoId;
	private String openId;
	private Boolean enable;
	private Date sayTime = new Date();
	private String content;
	private String image;
	private String mobile;

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
	 * @return the enable
	 */
	@Column(name = "enable")
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
	 * @return the sayTime
	 */
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getSayTime() {
		return sayTime;
	}

	/**
	 * @param sayTime
	 *            the sayTime to set
	 */
	public void setSayTime(Date sayTime) {
		this.sayTime = sayTime;
	}

	/**
	 * @return the content
	 */
	@Column(name = "content", length = 300)
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
	 * @return the image
	 */
	@Column(name = "image", length = 300)
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the mobile
	 */
	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @param autoId
	 * @param openId
	 * @param enable
	 * @param sayTime
	 * @param content
	 * @param image
	 * @param mobile
	 */
	public FeedBack(Long autoId, String openId, Boolean enable, Date sayTime,
			String content, String image, String mobile) {
		super();
		this.autoId = autoId;
		this.openId = openId;
		this.enable = enable;
		this.sayTime = sayTime;
		this.content = content;
		this.image = image;
		this.mobile = mobile;
	}

}
