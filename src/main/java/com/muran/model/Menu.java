package com.muran.model;

import java.io.Serializable;
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
@Table(name = "TB_MENU")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	private long autoId;
	private String type;// group，menu，fold，sub，
	private String name;
	private String descpt;
	private String path;
	private String icon;
	private int menuOrder;
	private String roleKey;
	private long parentId;
	private boolean isAssign;
	private boolean isShowMenu;
	private boolean enable;
	private Date createTime = new Date();
	private String createUser;
	private Date modifyTime = new Date();
	private String modifyUser;

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
	 * @return the type
	 */
	@Column(length = 50)
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	@Column(length = 50)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the descpt
	 */
	@Column(length = 50)
	public String getDescpt() {
		return descpt;
	}

	/**
	 * @param descpt
	 *            the descpt to set
	 */
	public void setDescpt(String descpt) {
		this.descpt = descpt;
	}

	/**
	 * @return the path
	 */
	@Column(length = 100)
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the icon
	 */
	@Column(length = 100)
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the parentId
	 */
	public long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(long parentId) {
		this.parentId = parentId;
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

	@Column(length = 45)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(length = 45)
	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	/**
	 * @return the roleKey
	 */
	@Column(columnDefinition = "text")
	public String getRoleKey() {
		return roleKey;
	}

	/**
	 * @param roleKey
	 *            the roleKey to set
	 */
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	/**
	 * @return the menuOrder
	 */
	public int getMenuOrder() {
		return menuOrder;
	}

	/**
	 * @param menuOrder
	 *            the menuOrder to set
	 */
	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	/**
	 * @return the isAssign
	 */
	public boolean isAssign() {
		return isAssign;
	}

	/**
	 * @param isAssign
	 *            the isAssign to set
	 */
	public void setAssign(boolean isAssign) {
		this.isAssign = isAssign;
	}

	/**
	 * @return the isShow
	 */
	public boolean isShowMenu() {
		return isShowMenu;
	}

	/**
	 * @param isShow
	 *            the isShow to set
	 */
	public void setShowMenu(boolean isShowMenu) {
		this.isShowMenu = isShowMenu;
	}
}
