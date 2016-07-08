package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * \u8BE6\u7EC6\u8BC4\u8BBA\u4FE1\u606F
 **/

@ApiModel(description = "\u8BE6\u7EC6\u8BC4\u8BBA\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AddComment   {
  
  private String columnKey = null;
  private Long itemId = null;
  private String content = null;

  /**
   **/
  public AddComment columnKey(String columnKey) {
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
  public AddComment itemId(Long itemId) {
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
  public AddComment content(String content) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddComment addComment = (AddComment) o;
    return Objects.equals(columnKey, addComment.columnKey) &&
        Objects.equals(itemId, addComment.itemId) &&
        Objects.equals(content, addComment.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(columnKey, itemId, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddComment {\n");
    
    sb.append("    columnKey: ").append(toIndentedString(columnKey)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

