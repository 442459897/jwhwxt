package com.muran.dto;

import java.math.BigInteger;
import java.util.List;

public class RoleDto {
	private BigInteger autoId;
	private String roleName;
	private String descpt;

	private String keyCode;
	private BigInteger parentId;
	private String category;
	public List<RoleDto> childRoles;

	public BigInteger getAutoId() {
		return autoId;
	}

	public void setAutoId(BigInteger autoId) {
		this.autoId = autoId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescpt() {
		return descpt;
	}

	public void setDescpt(String descpt) {
		this.descpt = descpt;
	}

	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	public BigInteger getParentId() {
		return parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<RoleDto> getChildRoles() {
		return childRoles;
	}

	public void setChildRoles(List<RoleDto> childRoles) {
		this.childRoles = childRoles;
	}


	
}
