package com.muran.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TB_ROLE")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long autoId;
	private String roleName;
	private String descpt;
	private String keyCode;
	private long parentId;
	private String category;
	private boolean enable;//是否禁用
	@Id
	@GeneratedValue
	@Column(name = "autoId", unique = true, nullable = false)
	public long getAutoId() {
		return autoId;
	}

	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}

	@Column(length = 50)
	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	@Column(length = 20)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(length = 50)
	public String getDescpt() {
		return descpt;
	}

	public void setDescpt(String descpt) {
		this.descpt = descpt;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public List<Role> childRoles;

	@Transient
	public List<Role> getChildRoles() {
		return childRoles;
	}

	public void setChildRoles(List<Role> childRoles) {
		this.childRoles = childRoles;
	}
	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}



	public Role(long autoId, String roleName, String descpt, String keyCode, long parentId, String category,
			boolean enable, List<Role> childRoles) {
		super();
		this.autoId = autoId;
		this.roleName = roleName;
		this.descpt = descpt;
		this.keyCode = keyCode;
		this.parentId = parentId;
		this.category = category;
		this.enable = enable;
		this.childRoles = childRoles;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
