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
@Table(name = "TB_MENUGROUP")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class MenuGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long autoId;
	private String groupName;
	private String code;

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
	 * @return the groupName
	 */
	@Column(length=50)
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the property
	 */
	@Column(length=50)
	public String getCode() {
		return code;
	}

	/**
	 * @param property the property to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
