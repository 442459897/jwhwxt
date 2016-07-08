package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;



/**
 * \u56DE\u590D\u4FE1\u606F
 **/

@ApiModel(description = "\u56DE\u590D\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class ReplyWxInfo   {
  
  private Long autoId = null;
  private Long message = null;
  private String content = null;
  private String name = null;
  private String headImg = null;
  private Date replyTime = null;
  private Long type = null;
  private Long replyType = null;

  /**
   **/
  public ReplyWxInfo autoId(Long autoId) {
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
  public ReplyWxInfo message(Long message) {
    this.message = message;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("message")
  public Long getMessage() {
    return message;
  }
  public void setMessage(Long message) {
    this.message = message;
  }

  /**
   **/
  public ReplyWxInfo content(String content) {
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
  public ReplyWxInfo name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public ReplyWxInfo headImg(String headImg) {
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
  public ReplyWxInfo replyTime(Date replyTime) {
    this.replyTime = replyTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("replyTime")
  public Date getReplyTime() {
    return replyTime;
  }
  public void setReplyTime(Date replyTime) {
    this.replyTime = replyTime;
  }

  /**
   * \u56DE\u590D\u7C7B\u578B 0:\u7559\u8A00\u8BC4\u8BBA\u56DE\u590D  1:\u6211\u6709\u8BDD\u8BF4\u56DE\u590D
   **/
  public ReplyWxInfo type(Long type) {
    this.type = type;
    return this;
  }

  
  @ApiModelProperty(value = "\u56DE\u590D\u7C7B\u578B 0:\u7559\u8A00\u8BC4\u8BBA\u56DE\u590D  1:\u6211\u6709\u8BDD\u8BF4\u56DE\u590D")
  @JsonProperty("type")
  public Long getType() {
    return type;
  }
  public void setType(Long type) {
    this.type = type;
  }

  /**
   * \u56DE\u590D\u65B9 0:\u5C45\u59D4\u4F1A 1:\u5FAE\u4FE1\u7528\u6237
   **/
  public ReplyWxInfo replyType(Long replyType) {
    this.replyType = replyType;
    return this;
  }

  
  @ApiModelProperty(value = "\u56DE\u590D\u65B9 0:\u5C45\u59D4\u4F1A 1:\u5FAE\u4FE1\u7528\u6237")
  @JsonProperty("replyType")
  public Long getReplyType() {
    return replyType;
  }
  public void setReplyType(Long replyType) {
    this.replyType = replyType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplyWxInfo replyWxInfo = (ReplyWxInfo) o;
    return Objects.equals(autoId, replyWxInfo.autoId) &&
        Objects.equals(message, replyWxInfo.message) &&
        Objects.equals(content, replyWxInfo.content) &&
        Objects.equals(name, replyWxInfo.name) &&
        Objects.equals(headImg, replyWxInfo.headImg) &&
        Objects.equals(replyTime, replyWxInfo.replyTime) &&
        Objects.equals(type, replyWxInfo.type) &&
        Objects.equals(replyType, replyWxInfo.replyType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoId, message, content, name, headImg, replyTime, type, replyType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplyWxInfo {\n");
    
    sb.append("    autoId: ").append(toIndentedString(autoId)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    headImg: ").append(toIndentedString(headImg)).append("\n");
    sb.append("    replyTime: ").append(toIndentedString(replyTime)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    replyType: ").append(toIndentedString(replyType)).append("\n");
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

