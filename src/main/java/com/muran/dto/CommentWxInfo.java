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
 * \u5FAE\u4FE1\u8BC4\u8BBA\u4FE1\u606F
 **/

@ApiModel(description = "\u5FAE\u4FE1\u8BC4\u8BBA\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class CommentWxInfo   {
  
  private Long autoId = null;
  private String columnKey = null;
  private Long itemId = null;
  private String nickName = null;
  private String headImg = null;
  private Date commentTime = null;
  private String content = null;
  private Long status = null;
  private List<ReplyWxInfo> replies = new ArrayList<ReplyWxInfo>();

  /**
   **/
  public CommentWxInfo autoId(Long autoId) {
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
  public CommentWxInfo columnKey(String columnKey) {
    this.columnKey = columnKey;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("columnKey")
  public String getColumnKey() {
    return columnKey;
  }
  public void setColumnKey(String columnKey) {
    this.columnKey = columnKey;
  }

  /**
   **/
  public CommentWxInfo itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("itemId")
  public Long getItemId() {
    return itemId;
  }
  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  /**
   **/
  public CommentWxInfo nickName(String nickName) {
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
  public CommentWxInfo headImg(String headImg) {
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
  public CommentWxInfo commentTime(Date commentTime) {
    this.commentTime = commentTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("commentTime")
  public Date getCommentTime() {
    return commentTime;
  }
  public void setCommentTime(Date commentTime) {
    this.commentTime = commentTime;
  }

  /**
   **/
  public CommentWxInfo content(String content) {
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
  public CommentWxInfo status(Long status) {
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

  /**
   **/
  public CommentWxInfo replies(List<ReplyWxInfo> replies) {
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
    CommentWxInfo commentWxInfo = (CommentWxInfo) o;
    return Objects.equals(autoId, commentWxInfo.autoId) &&
        Objects.equals(columnKey, commentWxInfo.columnKey) &&
        Objects.equals(itemId, commentWxInfo.itemId) &&
        Objects.equals(nickName, commentWxInfo.nickName) &&
        Objects.equals(headImg, commentWxInfo.headImg) &&
        Objects.equals(commentTime, commentWxInfo.commentTime) &&
        Objects.equals(content, commentWxInfo.content) &&
        Objects.equals(status, commentWxInfo.status) &&
        Objects.equals(replies, commentWxInfo.replies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoId, columnKey, itemId, nickName, headImg, commentTime, content, status, replies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentWxInfo {\n");
    
    sb.append("    autoId: ").append(toIndentedString(autoId)).append("\n");
    sb.append("    columnKey: ").append(toIndentedString(columnKey)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    headImg: ").append(toIndentedString(headImg)).append("\n");
    sb.append("    commentTime: ").append(toIndentedString(commentTime)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

