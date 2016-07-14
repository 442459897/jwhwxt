package com.muran.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.muran.api.exception.GeneralResponseCode;
import com.muran.api.exception.ServerException;

/**
 * token: username_usersys_timestamp
 */
@Entity
@Table(name = "TB_USER_TOKEN")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
// @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class UserToken implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date createTime = new Date();
	private Date modifyTime = new Date();


	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@JsonIgnore
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@JsonIgnore
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	private boolean enable = true;

	@JsonIgnore
	@Column(length = 20)
	public String getUsername() {
		return username;
	}

	private String userSys;

	@JsonIgnore
	@Column(length = 10)
	public String getUserSys() {
		return userSys;
	}

	public void setUserSys(String userSys) {
		this.userSys = userSys;
	}

	private String username;

	public void setUsername(String username) {
		this.username = username;
	}

	private String userToken;
	private String tokenSecret;
	
	@JsonIgnore
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Id
	@Column(length = 50)
	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String token) {
		this.userToken = token;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	public UserToken(String token) {
		try {
			this.userToken = token;
			String str[] = token.split("_");
			username = str[0];
			userSys = str[2];
			createTime = new Date();
			createTime.setTime(Long.parseLong(str[1]));
		} catch (Exception ex) {
			throw new ServerException(GeneralResponseCode.UserTokenException);
		}
	}

	@Transient
	@JsonIgnore
	public Date getUserLoginTime() {
		String[] strs = userToken.split(":");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(strs[2]));
		return c.getTime();
	}
	
	public UserToken(){
		
	}
}