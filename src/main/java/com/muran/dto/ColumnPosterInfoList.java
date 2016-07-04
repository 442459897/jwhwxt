package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.muran.dto.ColumnPosterInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * \u680F\u76EE\u6D77\u62A5\u4FE1\u606F\u5217\u8868
 **/

@ApiModel(description = "\u680F\u76EE\u6D77\u62A5\u4FE1\u606F\u5217\u8868")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-02T10:24:45.752+08:00")
public class ColumnPosterInfoList   {
  
  private List<ColumnPosterInfo> posters = new ArrayList<ColumnPosterInfo>();

  /**
   **/
  public ColumnPosterInfoList posters(List<ColumnPosterInfo> posters) {
    this.posters = posters;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("posters")
  public List<ColumnPosterInfo> getPosters() {
    return posters;
  }
  public void setPosters(List<ColumnPosterInfo> posters) {
    this.posters = posters;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColumnPosterInfoList columnPosterInfoList = (ColumnPosterInfoList) o;
    return Objects.equals(posters, columnPosterInfoList.posters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(posters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColumnPosterInfoList {\n");
    
    sb.append("    posters: ").append(toIndentedString(posters)).append("\n");
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

