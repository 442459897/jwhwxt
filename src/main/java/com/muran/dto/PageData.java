package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * \u5206\u9875\u5BF9\u8C61
 **/

@ApiModel(description = "\u5206\u9875\u5BF9\u8C61")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class PageData   {
  
  private Long pageIndex = null;
  private Long pageSize = null;
  private Long pageTotal = null;
  private Long recordTotal = null;
  private List<Object> data = new ArrayList<Object>();

  /**
   **/
  public PageData pageIndex(Long pageIndex) {
    this.pageIndex = pageIndex;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("pageIndex")
  public Long getPageIndex() {
    return pageIndex;
  }
  public void setPageIndex(Long pageIndex) {
    this.pageIndex = pageIndex;
  }

  /**
   **/
  public PageData pageSize(Long pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("pageSize")
  public Long getPageSize() {
    return pageSize;
  }
  public void setPageSize(Long pageSize) {
    this.pageSize = pageSize;
  }

  /**
   **/
  public PageData pageTotal(Long pageTotal) {
    this.pageTotal = pageTotal;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("pageTotal")
  public Long getPageTotal() {
    return pageTotal;
  }
  public void setPageTotal(Long pageTotal) {
    this.pageTotal = pageTotal;
  }

  /**
   **/
  public PageData recordTotal(Long recordTotal) {
    this.recordTotal = recordTotal;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("recordTotal")
  public Long getRecordTotal() {
    return recordTotal;
  }
  public void setRecordTotal(Long recordTotal) {
    this.recordTotal = recordTotal;
  }

  /**
   **/
  public PageData data(List<Object> data) {
    this.data = data;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("Data")
  public List<Object> getData() {
    return data;
  }
  public void setData(List<Object> data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageData pageData = (PageData) o;
    return Objects.equals(pageIndex, pageData.pageIndex) &&
        Objects.equals(pageSize, pageData.pageSize) &&
        Objects.equals(pageTotal, pageData.pageTotal) &&
        Objects.equals(recordTotal, pageData.recordTotal) &&
        Objects.equals(data, pageData.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageIndex, pageSize, pageTotal, recordTotal, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageData {\n");
    
    sb.append("    pageIndex: ").append(toIndentedString(pageIndex)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageTotal: ").append(toIndentedString(pageTotal)).append("\n");
    sb.append("    recordTotal: ").append(toIndentedString(recordTotal)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

