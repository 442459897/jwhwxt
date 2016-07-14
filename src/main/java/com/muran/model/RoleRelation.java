/**
 * 
 */
package com.muran.model;

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
@Table(name = "TB_ROLE_RELATION")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class RoleRelation implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long autoId;
	private String clientSys;
	private String clientOperKey;
	private String clientOperName;
	private String serverRoleKey;
	private String serverRoleName;
	
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
	 * @return the clientOperKey
	 */
	@Column(length=50)
	public String getClientOperKey() {
		return clientOperKey;
	}
	/**
	 * @param clientOperKey the clientOperKey to set
	 */
	public void setClientOperKey(String clientOperKey) {
		this.clientOperKey = clientOperKey;
	}
	/**
	 * @return the clientOperName
	 */
	@Column(length=50)
	public String getClientOperName() {
		return clientOperName;
	}
	/**
	 * @param clientOperName the clientOperName to set
	 */
	public void setClientOperName(String clientOperName) {
		this.clientOperName = clientOperName;
	}
	/**
	 * @return the serverRoleKey
	 */
	@Column(length=50)
	public String getServerRoleKey() {
		return serverRoleKey;
	}
	/**
	 * @param serverRoleKey the serverRoleKey to set
	 */
	public void setServerRoleKey(String serverRoleKey) {
		this.serverRoleKey = serverRoleKey;
	}
	/**
	 * @return the serverRoleName
	 */
	@Column(length=50)
	public String getServerRoleName() {
		return serverRoleName;
	}
	/**
	 * @param serverRoleName the serverRoleName to set
	 */
	public void setServerRoleName(String serverRoleName) {
		this.serverRoleName = serverRoleName;
	}
	/**
	 * @return the clientSys
	 */
	@Column(length=20)
	public String getClientSys() {
		return clientSys;
	}
	/**
	 * @param clientSys the clientSys to set
	 */
	public void setClientSys(String clientSys) {
		this.clientSys = clientSys;
	}

}
