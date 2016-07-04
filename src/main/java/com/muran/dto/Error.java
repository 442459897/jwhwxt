package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * \u7F51\u7EDC\u4EA4\u4E92\u51FA\u73B0\u9519\u8BEF\u7684\u65F6\u5019\u8FD4\u56DE\u4FE1\u606F\u3002
 **/

@ApiModel(description = "\u7F51\u7EDC\u4EA4\u4E92\u51FA\u73B0\u9519\u8BEF\u7684\u65F6\u5019\u8FD4\u56DE\u4FE1\u606F\u3002")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-02T10:24:45.752+08:00")
public class Error   {
  
  private Integer code = null;
  private String info = null;

  /**
   * \u9519\u8BEF\u4EE3\u7801
   **/
  public Error code(Integer code) {
    this.code = code;
    return this;
  }

  
  @ApiModelProperty(value = "\u9519\u8BEF\u4EE3\u7801")
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * \u9519\u8BEF\u63D0\u793A\u4FE1\u606F
   **/
  public Error info(String info) {
    this.info = info;
    return this;
  }

  
  @ApiModelProperty(value = "\u9519\u8BEF\u63D0\u793A\u4FE1\u606F")
  @JsonProperty("info")
  public String getInfo() {
    return info;
  }
  public void setInfo(String info) {
    this.info = info;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(code, error.code) &&
        Objects.equals(info, error.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, info);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
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

