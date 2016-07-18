package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.muran.dto.GeneralString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * \u6587\u7AE0\u4FE1\u606F
 **/

@ApiModel(description = "\u6587\u7AE0\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T10:42:28.092+08:00")
public class ArticleInfo {

	private Long autoId = null;
	private String title = null;
	private String showType = null;
	private List<GeneralString> coverUrl = new ArrayList<GeneralString>();
	private String videoUrl = null;
	private String content = null;
	private Date publishTime = null;
	private Long time = null;
	private String source = null;
	private Long commentNum = null;
	private String columeKey = null;
	private String keyword = null;

	/**
	 **/
	public ArticleInfo autoId(Long autoId) {
		this.autoId = autoId;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("autoId")
	public Long getAutoId() {
		return autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	/**
	 **/
	public ArticleInfo title(String title) {
		this.title = title;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 **/
	public ArticleInfo showType(String showType) {
		this.showType = showType;
		return this;
	}

	public ArticleInfo keyword(String keyword) {
		this.keyword = keyword;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("keyword")
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 **/
	public ArticleInfo columeKey(String columeKey) {
		this.columeKey = columeKey;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("columeKey")
	public String getColumeKey() {
		return columeKey;
	}

	public void setColumeKey(String columeKey) {
		this.columeKey = columeKey;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("showType")
	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	/**
	 **/
	public ArticleInfo coverUrl(List<GeneralString> coverUrl) {
		this.coverUrl = coverUrl;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("coverUrl")
	public List<GeneralString> getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(List<GeneralString> coverUrl) {
		this.coverUrl = coverUrl;
	}

	/**
	 **/
	public ArticleInfo videoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("videoUrl")
	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 **/
	public ArticleInfo content(String content) {
		this.content = content;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 **/
	public ArticleInfo publishTime(Date publishTime) {
		this.publishTime = publishTime;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("publishTime")
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 **/
	public ArticleInfo time(Long time) {
		this.time = time;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("time")
	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	/**
	 **/
	public ArticleInfo source(String source) {
		this.source = source;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	/**
	 **/
	public ArticleInfo commentNum(Long commentNum) {
		this.commentNum = commentNum;
		return this;
	}

	@ApiModelProperty(value = "")
	@JsonProperty("commentNum")
	public Long getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Long commentNum) {
		this.commentNum = commentNum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ArticleInfo articleInfo = (ArticleInfo) o;
		return Objects.equals(autoId, articleInfo.autoId) && Objects.equals(title, articleInfo.title)
				&& Objects.equals(showType, articleInfo.showType) && Objects.equals(coverUrl, articleInfo.coverUrl)
				&& Objects.equals(videoUrl, articleInfo.videoUrl) && Objects.equals(content, articleInfo.content)
				&& Objects.equals(publishTime, articleInfo.publishTime) && Objects.equals(time, articleInfo.time)
				&& Objects.equals(source, articleInfo.source) && Objects.equals(commentNum, articleInfo.commentNum)
				&& Objects.equals(keyword, articleInfo.keyword) && Objects.equals(columeKey, articleInfo.columeKey);
	}

	@Override
	public int hashCode() {
		return Objects.hash(autoId, title, showType, coverUrl, videoUrl, content, publishTime, time, source,
				commentNum);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ArticleInfo {\n");
		sb.append("    columeKey: ").append(toIndentedString(columeKey)).append("\n");
		sb.append("    keyword: ").append(toIndentedString(keyword)).append("\n");
		sb.append("    autoId: ").append(toIndentedString(autoId)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    showType: ").append(toIndentedString(showType)).append("\n");
		sb.append("    coverUrl: ").append(toIndentedString(coverUrl)).append("\n");
		sb.append("    videoUrl: ").append(toIndentedString(videoUrl)).append("\n");
		sb.append("    content: ").append(toIndentedString(content)).append("\n");
		sb.append("    publishTime: ").append(toIndentedString(publishTime)).append("\n");
		sb.append("    time: ").append(toIndentedString(time)).append("\n");
		sb.append("    source: ").append(toIndentedString(source)).append("\n");
		sb.append("    commentNum: ").append(toIndentedString(commentNum)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
