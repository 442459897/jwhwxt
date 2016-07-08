package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.muran.dto.ReplyWxInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * \u6211\u6709\u8BDD\u8BF4\u4FE1\u606F\u5BF9\u8C61
 **/

@ApiModel(description = "\u6211\u6709\u8BDD\u8BF4\u4FE1\u606F\u5BF9\u8C61")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class FeedBackInfo   {
  
  private Long autoId = null;
  private String nickName = null;
  private String headImg = null;
  private Date sayTime = null;
  private String content = null;
  private String image = null;
  private String mobile = null;
  private List<ReplyWxInfo> replies = new ArrayList<ReplyWxInfo>();

  /**
   **/
  public FeedBackInfo autoId(Long autoId) {
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
  public FeedBackInfo nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("nickName")
  public String getNickName() {
    return nickName;
  }
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  /**
   **/
  public FeedBackInfo headImg(String headImg) {
    this.headImg = headImg;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("headImg")
  public String getHeadImg() {
    return headImg;
  }
  public void setHeadImg(String headImg) {
    this.headImg = headImg;
  }

  /**
   **/
  public FeedBackInfo sayTime(Date sayTime) {
    this.sayTime = sayTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("sayTime")
  public Date getSayTime() {
    return sayTime;
  }
  public void setSayTime(Date sayTime) {
    this.sayTime = sayTime;
  }

  /**
   **/
  public FeedBackInfo content(String content) {
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
  public FeedBackInfo image(String image) {
    this.image = image;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("image")
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  /**
   **/
  public FeedBackInfo mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("mobile")
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  /**
   **/
  public FeedBackInfo replies(List<ReplyWxInfo> replies) {
    this.replies = replies;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("replies")
  public List<ReplyWxInfo> getReplies() {
    return replies;
  }
  public void setReplies(List<ReplyWxInfo> replies) {
    this.replies = replies;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeedBackInfo feedBackInfo = (FeedBackInfo) o;
    return Objects.equals(autoId, feedBackInfo.autoId) &&
        Objects.equals(nickName, feedBackInfo.nickName) &&
        Objects.equals(headImg, feedBackInfo.headImg) &&
        Objects.equals(sayTime, feedBackInfo.sayTime) &&
        Objects.equals(content, feedBackInfo.content) &&
        Objects.equals(image, feedBackInfo.image) &&
        Objects.equals(mobile, feedBackInfo.mobile) &&
        Objects.equals(replies, feedBackInfo.replies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoId, nickName, headImg, sayTime, content, image, mobile, replies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeedBackInfo {\n");
    
    sb.append("    autoId: ").append(toIndentedString(autoId)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    headImg: ").append(toIndentedString(headImg)).append("\n");
    sb.append("    sayTime: ").append(toIndentedString(sayTime)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    replies: ").append(toIndentedString(replies)).append("\n");
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

