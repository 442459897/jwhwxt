package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * \u9644\u4EF6\u4FE1\u606F
 **/

@ApiModel(description = "\u9644\u4EF6\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AttachInfo   {
  
  private Long autoId = null;
  private String columnKey = null;
  private Long itemId = null;
  private String url = null;
  private String extension = null;

  /**
   **/
  public AttachInfo autoId(Long autoId) {
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
  public AttachInfo columnKey(String columnKey) {
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
  public AttachInfo itemId(Long itemId) {
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
  public AttachInfo url(String url) {
    this.url = url;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   **/
  public AttachInfo extension(String extension) {
    this.extension = extension;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("extension")
  public String getExtension() {
    return extension;
  }
  public void setExtension(String extension) {
    this.extension = extension;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachInfo attachInfo = (AttachInfo) o;
    return Objects.equals(autoId, attachInfo.autoId) &&
        Objects.equals(columnKey, attachInfo.columnKey) &&
        Objects.equals(itemId, attachInfo.itemId) &&
        Objects.equals(url, attachInfo.url) &&
        Objects.equals(extension, attachInfo.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoId, columnKey, itemId, url, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachInfo {\n");
    
    sb.append("    autoId: ").append(toIndentedString(autoId)).append("\n");
    sb.append("    columnKey: ").append(toIndentedString(columnKey)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
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

