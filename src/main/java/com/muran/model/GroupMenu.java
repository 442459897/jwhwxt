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
@Table(name = "TB_MENUGROUP_MENU")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class GroupMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long autoId;
	private long groupId;
	private long menuId;
	private String roleKey;
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
	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the roleKey
	 */
	@Column(columnDefinition="text")
	public String getRoleKey() {
		return roleKey;
	}
	/**
	 * @param roleKey the roleKey to set
	 */
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

}
