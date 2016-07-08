package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.muran.dto.GeneralString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * \u6DFB\u52A0\u6587\u7AE0\u4FE1\u606F
 **/

@ApiModel(description = "\u6DFB\u52A0\u6587\u7AE0\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AddArticle   {
  
  private String columeKey = null;
  private String title = null;
  private String keyword = null;
  private String showType = null;
  private List<GeneralString> coverUrl = new ArrayList<GeneralString>();
  private String videoUrl = null;
  private String content = null;
  private String source = null;
  private String writer = null;
  private String attachUrl = null;
  private Long status = null;

  /**
   **/
  public AddArticle columeKey(String columeKey) {
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

  /**
   **/
  public AddArticle title(String title) {
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
  public AddArticle keyword(String keyword) {
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
  public AddArticle showType(String showType) {
    this.showType = showType;
    return this;
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
  public AddArticle coverUrl(List<GeneralString> coverUrl) {
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
  public AddArticle videoUrl(String videoUrl) {
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
  public AddArticle content(String content) {
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
  public AddArticle source(String source) {
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
  public AddArticle writer(String writer) {
    this.writer = writer;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("writer")
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }

  /**
   **/
  public AddArticle attachUrl(String attachUrl) {
    this.attachUrl = attachUrl;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("attachUrl")
  public String getAttachUrl() {
    return attachUrl;
  }
  public void setAttachUrl(String attachUrl) {
    this.attachUrl = attachUrl;
  }

  /**
   **/
  public AddArticle status(Long status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("status")
  public Long getStatus() {
    return status;
  }
  public void setStatus(Long status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddArticle addArticle = (AddArticle) o;
    return Objects.equals(columeKey, addArticle.columeKey) &&
        Objects.equals(title, addArticle.title) &&
        Objects.equals(keyword, addArticle.keyword) &&
        Objects.equals(showType, addArticle.showType) &&
        Objects.equals(coverUrl, addArticle.coverUrl) &&
        Objects.equals(videoUrl, addArticle.videoUrl) &&
        Objects.equals(content, addArticle.content) &&
        Objects.equals(source, addArticle.source) &&
        Objects.equals(writer, addArticle.writer) &&
        Objects.equals(attachUrl, addArticle.attachUrl) &&
        Objects.equals(status, addArticle.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(columeKey, title, keyword, showType, coverUrl, videoUrl, content, source, writer, attachUrl, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddArticle {\n");
    
    sb.append("    columeKey: ").append(toIndentedString(columeKey)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    keyword: ").append(toIndentedString(keyword)).append("\n");
    sb.append("    showType: ").append(toIndentedString(showType)).append("\n");
    sb.append("    coverUrl: ").append(toIndentedString(coverUrl)).append("\n");
    sb.append("    videoUrl: ").append(toIndentedString(videoUrl)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    writer: ").append(toIndentedString(writer)).append("\n");
    sb.append("    attachUrl: ").append(toIndentedString(attachUrl)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

