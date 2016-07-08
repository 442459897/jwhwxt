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
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author wxz
 * 
 */
@Entity
@Table(name = "TB_ADMIN")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class Admin implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	private long autoId;
	private String username;
	private String name;
	private boolean gender;
	private String mobile;
	private String email;
	private String idNumber;
	private boolean enable = true;
	private Date createTime = new Date();
	private String createUser;
	private Date modifyTime = new Date();
	private String modifyUser;

	@Id
	@GeneratedValue
	@Column(name = "autoId", unique = true, nullable = false)
	public long getAutoId() {
		return autoId;
	}

	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender")
	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "idNumber", length = 50)
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Column(name = "enable")
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "createUser", nullable = false, length = 45)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", name = "modifyTime", insertable = false, updatable = false)
	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(name = "modifyUser", length = 45)
	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	/**
	 * @param autoId
	 * @param username
	 * @param name
	 * @param national
	 * @param genter
	 * @param mobile
	 * @param email
	 * @param idNumber
	 * @param birthday
	 * @param joinTime
	 * @param userTag
	 * @param modifyTimes
	 * @param status
	 * @param company
	 * @param code
	 * @param enable
	 * @param createTime
	 * @param createUser
	 * @param modifyTime
	 * @param modifyUser
	 */
	public Admin(long autoId, String username, String name, boolean gender,
			String mobile, String email, String idNumber, boolean enable,
			Date createTime, String createUser, Date modifyTime,
			String modifyUser) {
		super();
		this.autoId = autoId;
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.idNumber = idNumber;
		this.enable = enable;
		this.createTime = createTime;
		this.createUser = createUser;
		this.modifyTime = modifyTime;
		this.modifyUser = modifyUser;
	}
}
