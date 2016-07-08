/**
 * 
 */
package com.muran.model;

import java.io.Serializable;

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
@Table(name = "TB_USER_MENUGROUP")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class UserMenuGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long autoId;
	private String username;
	private long groupId;
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
	 * @return the username
	 */
	@Column(length=50)
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
	 * @return the groupId
	 */
	public long getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
}
