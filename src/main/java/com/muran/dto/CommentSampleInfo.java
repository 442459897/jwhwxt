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
 * \u7559\u8A00\u8BC4\u8BBA\u540E\u53F0\u5217\u8868\u4FE1\u606F\u5BF9\u8C61
 **/

@ApiModel(description = "\u7559\u8A00\u8BC4\u8BBA\u540E\u53F0\u5217\u8868\u4FE1\u606F\u5BF9\u8C61")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class CommentSampleInfo   {
  
  private Long autoId = null;
  private String columnKey = null;
  private Long itemId = null;
  private String columnName = null;
  private String itemTitle = null;
  private String nickName = null;
  private String headImg = null;
  private Date commentTime = null;
  private String content = null;
  private Long status = null;
  private List<ReplyWxInfo> replies = new ArrayList<ReplyWxInfo>();

  /**
   **/
  public CommentSampleInfo autoId(Long autoId) {
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
  public CommentSampleInfo columnKey(String columnKey) {
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
  public CommentSampleInfo itemId(Long itemId) {
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
  public CommentSampleInfo columnName(String columnName) {
    this.columnName = columnName;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("columnName")
  public String getColumnName() {
    return columnName;
  }
  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  /**
   **/
  public CommentSampleInfo itemTitle(String itemTitle) {
    this.itemTitle = itemTitle;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("itemTitle")
  public String getItemTitle() {
    return itemTitle;
  }
  public void setItemTitle(String itemTitle) {
    this.itemTitle = itemTitle;
  }

  /**
   **/
  public CommentSampleInfo nickName(String nickName) {
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
  public CommentSampleInfo headImg(String headImg) {
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
  public CommentSampleInfo commentTime(Date commentTime) {
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
  public CommentSampleInfo content(String content) {
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
  public CommentSampleInfo status(Long status) {
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
  public CommentSampleInfo replies(List<ReplyWxInfo> replies) {
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
    CommentSampleInfo commentSampleInfo = (CommentSampleInfo) o;
    return Objects.equals(autoId, commentSampleInfo.autoId) &&
        Objects.equals(columnKey, commentSampleInfo.columnKey) &&
        Objects.equals(itemId, commentSampleInfo.itemId) &&
        Objects.equals(columnName, commentSampleInfo.columnName) &&
        Objects.equals(itemTitle, commentSampleInfo.itemTitle) &&
        Objects.equals(nickName, commentSampleInfo.nickName) &&
        Objects.equals(headImg, commentSampleInfo.headImg) &&
        Objects.equals(commentTime, commentSampleInfo.commentTime) &&
        Objects.equals(content, commentSampleInfo.content) &&
        Objects.equals(status, commentSampleInfo.status) &&
        Objects.equals(replies, commentSampleInfo.replies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoId, columnKey, itemId, columnName, itemTitle, nickName, headImg, commentTime, content, status, replies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentSampleInfo {\n");
    
    sb.append("    autoId: ").append(toIndentedString(autoId)).append("\n");
    sb.append("    columnKey: ").append(toIndentedString(columnKey)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    columnName: ").append(toIndentedString(columnName)).append("\n");
    sb.append("    itemTitle: ").append(toIndentedString(itemTitle)).append("\n");
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

