package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;



/**
 * \u62A5\u540D\u6D3B\u52A8
 **/

@ApiModel(description = "\u62A5\u540D\u6D3B\u52A8")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class SignupActivity   {
  
  private Long activity = null;
  private String name = null;
  private String mobile = null;
  private Boolean gender = null;
  private String remark = null;
  private Date signupTime = null;

  /**
   **/
  public SignupActivity activity(Long activity) {
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
  public SignupActivity name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public SignupActivity mobile(String mobile) {
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

  /**
   **/
  public SignupActivity gender(Boolean gender) {
    this.gender = gender;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("gender")
  public Boolean getGender() {
    return gender;
  }
  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  /**
   **/
  public SignupActivity remark(String remark) {
    this.remark = remark;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("remark")
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }

  /**
   **/
  public SignupActivity signupTime(Date signupTime) {
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
    SignupActivity signupActivity = (SignupActivity) o;
    return Objects.equals(activity, signupActivity.activity) &&
        Objects.equals(name, signupActivity.name) &&
        Objects.equals(mobile, signupActivity.mobile) &&
        Objects.equals(gender, signupActivity.gender) &&
        Objects.equals(remark, signupActivity.remark) &&
        Objects.equals(signupTime, signupActivity.signupTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activity, name, mobile, gender, remark, signupTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignupActivity {\n");
    
    sb.append("    activity: ").append(toIndentedString(activity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
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

