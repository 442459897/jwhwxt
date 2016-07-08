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
@Table(name = "TB_ACTIVITY_SIGNUP")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class ActivitySignup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ActivitySignup() {
		// TODO Auto-generated constructor stub
	}

	private Long autoId;
	private Long activity;
	private String name;
	private String mobile;
	private Boolean gender;
	private String remark;
	private Date signupTime = new Date();
	private String openId;
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
	 * @return the activity
	 */
	public Long getActivity() {
		return activity;
	}
	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Long activity) {
		this.activity = activity;
	}
	/**
	 * @return the name
	 */
	@Column(name = "name", length = 50)
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
	 * @return the mobile
	 */
	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the gender
	 */
	public Boolean getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	/**
	 * @return the remark
	 */
	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the signupTime
	 */
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getSignupTime() {
		return signupTime;
	}
	/**
	 * @param signupTime the signupTime to set
	 */
	public void setSignupTime(Date signupTime) {
		this.signupTime = signupTime;
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
	 * @param autoId
	 * @param activity
	 * @param name
	 * @param mobile
	 * @param gender
	 * @param remark
	 * @param signupTime
	 * @param openId
	 */
	public ActivitySignup(Long autoId, Long activity, String name,
			String mobile, Boolean gender, String remark, Date signupTime,
			String openId) {
		super();
		this.autoId = autoId;
		this.activity = activity;
		this.name = name;
		this.mobile = mobile;
		this.gender = gender;
		this.remark = remark;
		this.signupTime = signupTime;
		this.openId = openId;
	}

}
