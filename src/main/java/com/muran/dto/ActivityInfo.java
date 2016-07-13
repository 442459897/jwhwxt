package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;
import java.util.Date;



/**
 * \u6D3B\u52A8\u4FE1\u606F\u5BF9\u8C61
 **/

@ApiModel(description = "\u6D3B\u52A8\u4FE1\u606F\u5BF9\u8C61")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class ActivityInfo   {
  
  private BigInteger autoId = null;
  private String title = null;
  private String overUrl = null;
  private String hoster = null;
  private Date startTime = null;
  private Date endTime = null;
  private String location = null;
  private BigInteger signNum = null;
  private Date publishTime = null;
  private String publishMan = null;
  private String content = null;
  private BigInteger signupTop = null;
  private BigInteger commentNum = null;
  private BigInteger status = null;
  private Date signupEndTime = null;

  /**
   **/
  public ActivityInfo autoId(BigInteger autoId) {
    this.autoId = autoId;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("autoId")
  public BigInteger getAutoId() {
    return autoId;
  }
  public void setAutoId(BigInteger autoId) {
    this.autoId = autoId;
  }

  /**
   **/
  public ActivityInfo title(String title) {
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
  public ActivityInfo overUrl(String overUrl) {
    this.overUrl = overUrl;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("overUrl")
  public String getOverUrl() {
    return overUrl;
  }
  public void setOverUrl(String overUrl) {
    this.overUrl = overUrl;
  }

  /**
   **/
  public ActivityInfo hoster(String hoster) {
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
  public ActivityInfo startTime(Date startTime) {
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
  public ActivityInfo endTime(Date endTime) {
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
  public ActivityInfo location(String location) {
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
  public ActivityInfo signNum(BigInteger signNum) {
    this.signNum = signNum;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("signNum")
  public BigInteger getSignNum() {
    return signNum;
  }
  public void setSignNum(BigInteger signNum) {
    this.signNum = signNum;
  }

  /**
   **/
  public ActivityInfo publishTime(Date publishTime) {
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
  public ActivityInfo publishMan(String publishMan) {
    this.publishMan = publishMan;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("publishMan")
  public String getPublishMan() {
    return publishMan;
  }
  public void setPublishMan(String publishMan) {
    this.publishMan = publishMan;
  }

  /**
   **/
  public ActivityInfo content(String content) {
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
  public ActivityInfo signupTop(BigInteger signupTop) {
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
  public ActivityInfo commentNum(BigInteger commentNum) {
    this.commentNum = commentNum;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("commentNum")
  public BigInteger getCommentNum() {
    return commentNum;
  }
  public void setCommentNum(BigInteger commentNum) {
    this.commentNum = commentNum;
  }

  /**
   **/
  public ActivityInfo status(BigInteger status) {
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

  /**
   **/
  public ActivityInfo signupEndTime(Date signupEndTime) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityInfo activityInfo = (ActivityInfo) o;
    return Objects.equals(autoId, activityInfo.autoId) &&
        Objects.equals(title, activityInfo.title) &&
        Objects.equals(overUrl, activityInfo.overUrl) &&
        Objects.equals(hoster, activityInfo.hoster) &&
        Objects.equals(startTime, activityInfo.startTime) &&
        Objects.equals(endTime, activityInfo.endTime) &&
        Objects.equals(location, activityInfo.location) &&
        Objects.equals(signNum, activityInfo.signNum) &&
        Objects.equals(publishTime, activityInfo.publishTime) &&
        Objects.equals(publishMan, activityInfo.publishMan) &&
        Objects.equals(content, activityInfo.content) &&
        Objects.equals(signupTop, activityInfo.signupTop) &&
        Objects.equals(commentNum, activityInfo.commentNum) &&
        Objects.equals(status, activityInfo.status) &&
        Objects.equals(signupEndTime, activityInfo.signupEndTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoId, title, overUrl, hoster, startTime, endTime, location, signNum, publishTime, publishMan, content, signupTop, commentNum, status, signupEndTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityInfo {\n");
    
    sb.append("    autoId: ").append(toIndentedString(autoId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    overUrl: ").append(toIndentedString(overUrl)).append("\n");
    sb.append("    hoster: ").append(toIndentedString(hoster)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    signNum: ").append(toIndentedString(signNum)).append("\n");
    sb.append("    publishTime: ").append(toIndentedString(publishTime)).append("\n");
    sb.append("    publishMan: ").append(toIndentedString(publishMan)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    signupTop: ").append(toIndentedString(signupTop)).append("\n");
    sb.append("    commentNum: ").append(toIndentedString(commentNum)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    signupEndTime: ").append(toIndentedString(signupEndTime)).append("\n");
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

