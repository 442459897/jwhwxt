package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;



/**
 * \u5FAE\u4FE1\u62A5\u540D\u4FE1\u606F
 **/

@ApiModel(description = "\u5FAE\u4FE1\u62A5\u540D\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class SignupWxInfo   {
  
  private Long activity = null;
  private String nickName = null;
  private String headImg = null;
  private Date signupTime = null;

  /**
   **/
  public SignupWxInfo activity(Long activity) {
    this.activity = activity;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("activity")
  public Long getActivity() {
    return activity;
  }
  public void setActivity(Long activity) {
    this.activity = activity;
  }

  /**
   **/
  public SignupWxInfo nickName(String nickName) {
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
  public SignupWxInfo headImg(String headImg) {
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
  public SignupWxInfo signupTime(Date signupTime) {
    this.signupTime = signupTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("signupTime")
  public Date getSignupTime() {
    return signupTime;
  }
  public void setSignupTime(Date signupTime) {
    this.signupTime = signupTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignupWxInfo signupWxInfo = (SignupWxInfo) o;
    return Objects.equals(activity, signupWxInfo.activity) &&
        Objects.equals(nickName, signupWxInfo.nickName) &&
        Objects.equals(headImg, signupWxInfo.headImg) &&
        Objects.equals(signupTime, signupWxInfo.signupTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activity, nickName, headImg, signupTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignupWxInfo {\n");
    
    sb.append("    activity: ").append(toIndentedString(activity)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    headImg: ").append(toIndentedString(headImg)).append("\n");
    sb.append("    signupTime: ").append(toIndentedString(signupTime)).append("\n");
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

