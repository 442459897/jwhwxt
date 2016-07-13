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

@Entity
@Table(name = "TB_ARTICLE")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class Article implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	private Long autoId;
	private String columnKey;
	private String title;
	private String keywords;
	private String showType;
	private String coverUrl;
	private String videoUrl;
	private String content;
	private String source;
	private String writer;
	private Date publishTime=new Date();
	private String publishMan;
	private Date backTime=new Date();
	private String backMan;
	private Date createTime=new Date();
	private String createMan;
	private Date modifyTime=new Date();
	private String modifyMan;
	private Boolean enable;
	private Long status;
	/**
	 * @return the autoId
	 */
	@Id
	@GeneratedValue
	@Column(name = "autoId", unique = true, nullable = false)
	public Long getAutoId() {
		return autoId;
	}
	/**
	 * @param autoId the autoId to set
	 */
	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}
	/**
	 * @return the columeKey
	 */
	@Column(name="columnKey",length = 50)
	public String getColumnKey() {
		return columnKey;
	}
	/**
	 * @param columeKey the columeKey to set
	 */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	/**
	 * @return the title
	 */
	@Column(length = 50)
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the keywords
	 */
	@Column(length = 100)
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
	 * @return the showType
	 */
	@Column(length = 20)
	public String getShowType() {
		return showType;
	}
	/**
	 * @param showType the showType to set
	 */
	public void setShowType(String showType) {
		this.showType = showType;
	}
	/**
	 * @return the coverUrl
	 */
	@Column(length = 1000)
	public String getCoverUrl() {
		return coverUrl;
	}
	/**
	 * @param coverUrl the coverUrl to set
	 */
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	/**
	 * @return the videoUrl
	 */
	@Column(length = 300)
	public String getVideoUrl() {
		return videoUrl;
	}
	/**
	 * @param videoUrl the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	/**
	 * @return the content
	 */
	@Column(columnDefinition = "text")
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the source
	 */
	@Column(length = 50)
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the writer
	 */
	@Column(length = 50)
	public String getWriter() {
		return writer;
	}
	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
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
	@Column(length = 50)
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
	@Column(length = 50)
	public String getBackMan() {
		return backMan;
	}
	/**
	 * @param backMan the backMan to set
	 */
	public void setBackMan(String backMan) {
		this.backMan = backMan;
	}
	/**
	 * @return the createTime
	 */
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the createMan
	 */
	@Column(length = 50)
	public String getCreateMan() {
		return createMan;
	}
	/**
	 * @param createMan the createMan to set
	 */
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	/**
	 * @return the modifyTime
	 */
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * @return the modifyMan
	 */
	@Column(length = 50)
	public String getModifyMan() {
		return modifyMan;
	}
	/**
	 * @param modifyMan the modifyMan to set
	 */
	public void setModifyMan(String modifyMan) {
		this.modifyMan = modifyMan;
	}
	/**
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}
	/**
	 * @param enable the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	/**
	 * @param autoId
	 * @param columeKey
	 * @param title
	 * @param keywords
	 * @param showType
	 * @param coverUrl
	 * @param videoUrl
	 * @param content
	 * @param source
	 * @param writer
	 * @param publishTime
	 * @param publishMan
	 * @param backTime
	 * @param backMan
	 * @param createTime
	 * @param createMan
	 * @param modifyTime
	 * @param modifyMan
	 * @param enable
	 */
	public Article(Long autoId, String columnKey, String title,
			String keywords, String showType, String coverUrl, String videoUrl,
			String content, String source, String writer, Date publishTime,
			String publishMan, Date backTime, String backMan, Date createTime,
			String createMan, Date modifyTime, String modifyMan, Boolean enable) {
		super();
		this.autoId = autoId;
		this.columnKey = columnKey;
		this.title = title;
		this.keywords = keywords;
		this.showType = showType;
		this.coverUrl = coverUrl;
		this.videoUrl = videoUrl;
		this.content = content;
		this.source = source;
		this.writer = writer;
		this.publishTime = publishTime;
		this.publishMan = publishMan;
		this.backTime = backTime;
		this.backMan = backMan;
		this.createTime = createTime;
		this.createMan = createMan;
		this.modifyTime = modifyTime;
		this.modifyMan = modifyMan;
		this.enable = enable;
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
}
