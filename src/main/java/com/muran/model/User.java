package com.muran.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.RandomStringUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.muran.api.exception.Code;
import com.muran.api.exception.ServerException;
import com.muran.util.DateTimeSerializer;
import com.muran.util.UserNameVerify;

@Entity
@Table(name = "TB_USER", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "userSys", "username" }),
		@UniqueConstraint(columnNames = { "userSys", "mobile" }) })
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
// @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private long autoId;
	private Date createTime = new Date();
	private Date modifyTime = new Date();

	@Id
	@GeneratedValue
	@Column(name = "autoId", unique = true, nullable = false)
	public long getAutoId() {
		return this.autoId;
	}

	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@JsonSerialize(using = DateTimeSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@JsonSerialize(using = DateTimeSerializer.class)
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	private String username;
	private String mobile;
	private String password;

	@Column(length = 200)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String userSys;// 用户来自那个系统：
							// 

	@Column(length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (!UserNameVerify.getInstance().verify(username))
			throw new ServerException(Code.UsernameFormatException,
					"请使用字母开头的5-15为字母数字组合");
		this.username = username;
	}

	@Column(length = 15)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(length = 10)
	public String getUserSys() {
		return userSys;
	}

	public void setUserSys(String userSys) {
		this.userSys = userSys;
	}

	public UserToken newUserToken() {
		UserToken ut = new UserToken();
		StringBuffer sb = new StringBuffer();
		sb.append(getUsername());
		sb.append("_");
		sb.append(Calendar.getInstance().getTimeInMillis());
		sb.append("_");
		sb.append(getUserSys());

		ut.setUserToken(sb.toString());
		ut.setTokenSecret(RandomStringUtils.random(20, true, true));
		ut.setUsername(getUsername());
		ut.setUserSys(getUserSys());
		return ut;
	}

}