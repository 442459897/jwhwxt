package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * \u56DE\u590D\u4FE1\u606F\u5BF9\u8C61
 **/

@ApiModel(description = "\u56DE\u590D\u4FE1\u606F\u5BF9\u8C61")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AddReply   {
  
  private Long type = null;
  private String content = null;
  private Long message = null;
  private Long reply = null;
  private Long replyType = null;

  /**
   **/
  public AddReply type(Long type) {
    this.type = type;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("type")
  public Long getType() {
    return type;
  }
  public void setType(Long type) {
    this.type = type;
  }

  /**
   **/
  public AddReply content(String content) {
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
  public AddReply message(Long message) {
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
  public AddReply reply(Long reply) {
    this.reply = reply;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("reply")
  public Long getReply() {
    return reply;
  }
  public void setReply(Long reply) {
    this.reply = reply;
  }

  /**
   **/
  public AddReply replyType(Long replyType) {
    this.replyType = replyType;
    return this;
  }

  
  @ApiModelProperty(value = "")
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
    AddReply addReply = (AddReply) o;
    return Objects.equals(type, addReply.type) &&
        Objects.equals(content, addReply.content) &&
        Objects.equals(message, addReply.message) &&
        Objects.equals(reply, addReply.reply) &&
        Objects.equals(replyType, addReply.replyType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, content, message, reply, replyType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddReply {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    reply: ").append(toIndentedString(reply)).append("\n");
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

