package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * \u6211\u6709\u8BDD\u8BF4\u5BF9\u8C61
 **/

@ApiModel(description = "\u6211\u6709\u8BDD\u8BF4\u5BF9\u8C61")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AddFeedback   {
  
  private String content = null;
  private String image = null;
  private String mobile = null;

  /**
   **/
  public AddFeedback content(String content) {
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
  public AddFeedback image(String image) {
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
  public AddFeedback mobile(String mobile) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddFeedback addFeedback = (AddFeedback) o;
    return Objects.equals(content, addFeedback.content) &&
        Objects.equals(image, addFeedback.image) &&
        Objects.equals(mobile, addFeedback.mobile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, image, mobile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddFeedback {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
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

