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
@Table(name = "TB_ACTIVITY")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class Activity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Activity() {
		// TODO Auto-generated constructor stub
	}

	private long autoId;
	private String title;
	private String location;

	private Date startTime = new Date();;
	private Date endTime = new Date();;

	private String hoster;
	private String overUrl;
	
	private String keywords;

	private Date publishTime;
	private String publishMan;
	private Long signupTop;

	private Date signupEndTime = new Date();

	private String content;

	private Long status;

	private boolean enable = true;
	private Date createTime = new Date();
	private String createUser;
	private Date modifyTime = new Date();
	private String modifyUser;
	
	private Date backTime=new Date();
	private String backMan;

	@Id
	@GeneratedValue
	@Column(name = "autoId", unique = true, nullable = false)
	public long getAutoId() {
		return autoId;
	}

	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "province", length = 100)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "startTime")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "endTime")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "signupEndTime")
	public Date getSignupEndTime() {
		return signupEndTime;
	}

	public void setSignupEndTime(Date signupEndTime) {
		this.signupEndTime = signupEndTime;
	}

	@Column(name = "content", columnDefinition = "text")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	 * @return the hoster
	 */
	@Column(name = "hoster", length = 100)
	public String getHoster() {
		return hoster;
	}

	/**
	 * @param hoster the hoster to set
	 */
	public void setHoster(String hoster) {
		this.hoster = hoster;
	}

	/**
	 * @return the overUrl
	 */
	@Column(name = "overUrl", length = 300)
	public String getOverUrl() {
		return overUrl;
	}

	/**
	 * @param overUrl the overUrl to set
	 */
	public void setOverUrl(String overUrl) {
		this.overUrl = overUrl;
	}

	/**
	 * @return the publishTime
	 */
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishTime the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * @return the publishMan
	 */
	@Column(name = "publishMan", length = 50)
	public String getPublishMan() {
		return publishMan;
	}

	/**
	 * @param publishMan the publishMan to set
	 */
	public void setPublishMan(String publishMan) {
		this.publishMan = publishMan;
	}

	/**
	 * @return the signupTop
	 */
	public Long getSignupTop() {
		return signupTop;
	}

	/**
	 * @param signupTop the signupTop to set
	 */
	public void setSignupTop(Long signupTop) {
		this.signupTop = signupTop;
	}

	/**
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}

	/**
	 * @return the keywords
	 */
	@Column(name = "keywords", length = 100)
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * @param autoId
	 * @param title
	 * @param location
	 * @param startTime
	 * @param endTime
	 * @param hoster
	 * @param overUrl
	 * @param keywords
	 * @param publishTime
	 * @param publishMan
	 * @param signupTop
	 * @param signupEndTime
	 * @param content
	 * @param status
	 * @param enable
	 * @param createTime
	 * @param createUser
	 * @param modifyTime
	 * @param modifyUser
	 */
	public Activity(long autoId, String title, String location, Date startTime,
			Date endTime, String hoster, String overUrl, String keywords,
			Date publishTime, String publishMan, Long signupTop,
			Date signupEndTime, String content, Long status, boolean enable,
			Date createTime, String createUser, Date modifyTime,
			String modifyUser) {
		super();
		this.autoId = autoId;
		this.title = title;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.hoster = hoster;
		this.overUrl = overUrl;
		this.keywords = keywords;
		this.publishTime = publishTime;
		this.publishMan = publishMan;
		this.signupTop = signupTop;
		this.signupEndTime = signupEndTime;
		this.content = content;
		this.status = status;
		this.enable = enable;
		this.createTime = createTime;
		this.createUser = createUser;
		this.modifyTime = modifyTime;
		this.modifyUser = modifyUser;
	}

	/**
	 * @return the backTime
	 */
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getBackTime() {
		return backTime;
	}

	/**
	 * @param backTime the backTime to set
	 */
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	/**
	 * @return the backMan
	 */
	@Column(name = "backMan", length = 50)
	public String getBackMan() {
		return backMan;
	}

	/**
	 * @param backMan the backMan to set
	 */
	public void setBackMan(String backMan) {
		this.backMan = backMan;
	}

}
