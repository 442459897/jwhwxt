package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;
import java.util.Date;



/**
 * \u6DFB\u52A0\u6216\u53D1\u5E03\u6D3B\u52A8\u4FE1\u606F
 **/

@ApiModel(description = "\u6DFB\u52A0\u6216\u53D1\u5E03\u6D3B\u52A8\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AddActivity   {
  
  private String title = null;
  private Date startTime = null;
  private Date endTime = null;
  private String location = null;
  private String keywords = null;
  private Date signupEndTime = null;
  private String content = null;
  private String coverUrl = null;
  private BigInteger signupTop = null;
  private String hoster = null;
  private BigInteger status = null;

  /**
   **/
  public AddActivity title(String title) {
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
  public AddActivity startTime(Date startTime) {
    this.startTime = startTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("startTime")
  public Date getStartTime() {
    return startTime;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  /**
   **/
  public AddActivity endTime(Date endTime) {
    this.endTime = endTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("endTime")
  public Date getEndTime() {
    return endTime;
  }
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  /**
   **/
  public AddActivity location(String location) {
    this.location = location;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("location")
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   **/
  public AddActivity keywords(String keywords) {
    this.keywords = keywords;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("keywords")
  public String getKeywords() {
    return keywords;
  }
  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  /**
   **/
  public AddActivity signupEndTime(Date signupEndTime) {
    this.signupEndTime = signupEndTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("signupEndTime")
  public Date getSignupEndTime() {
    return signupEndTime;
  }
  public void setSignupEndTime(Date signupEndTime) {
    this.signupEndTime = signupEndTime;
  }

  /**
   **/
  public AddActivity content(String content) {
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
  public AddActivity coverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("coverUrl")
  public String getCoverUrl() {
    return coverUrl;
  }
  public void setCoverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
  }

  /**
   **/
  public AddActivity signupTop(BigInteger signupTop) {
    this.signupTop = signupTop;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("signupTop")
  public BigInteger getSignupTop() {
    return signupTop;
  }
  public void setSignupTop(BigInteger signupTop) {
    this.signupTop = signupTop;
  }

  /**
   **/
  public AddActivity hoster(String hoster) {
    this.hoster = hoster;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("hoster")
  public String getHoster() {
    return hoster;
  }
  public void setHoster(String hoster) {
    this.hoster = hoster;
  }

  /**
   **/
  public AddActivity status(BigInteger status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("status")
  public BigInteger getStatus() {
    return status;
  }
  public void setStatus(BigInteger status) {
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
    AddActivity addActivity = (AddActivity) o;
    return Objects.equals(title, addActivity.title) &&
        Objects.equals(startTime, addActivity.startTime) &&
        Objects.equals(endTime, addActivity.endTime) &&
        Objects.equals(location, addActivity.location) &&
        Objects.equals(keywords, addActivity.keywords) &&
        Objects.equals(signupEndTime, addActivity.signupEndTime) &&
        Objects.equals(content, addActivity.content) &&
        Objects.equals(coverUrl, addActivity.coverUrl) &&
        Objects.equals(signupTop, addActivity.signupTop) &&
        Objects.equals(hoster, addActivity.hoster) &&
        Objects.equals(status, addActivity.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, startTime, endTime, location, keywords, signupEndTime, content, coverUrl, signupTop, hoster, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddActivity {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    keywords: ").append(toIndentedString(keywords)).append("\n");
    sb.append("    signupEndTime: ").append(toIndentedString(signupEndTime)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    coverUrl: ").append(toIndentedString(coverUrl)).append("\n");
    sb.append("    signupTop: ").append(toIndentedString(signupTop)).append("\n");
    sb.append("    hoster: ").append(toIndentedString(hoster)).append("\n");
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

