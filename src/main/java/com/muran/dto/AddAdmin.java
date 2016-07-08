package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * \u6DFB\u52A0\u4EBA\u5458\u4FE1\u606F
 **/

@ApiModel(description = "\u6DFB\u52A0\u4EBA\u5458\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AddAdmin   {
  
  private String username = null;
  private String name = null;
  private Boolean gender = null;
  private String mobile = null;
  private String email = null;
  private String idNumber = null;

  /**
   **/
  public AddAdmin username(String username) {
    this.username = username;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   **/
  public AddAdmin name(String name) {
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
  public AddAdmin gender(Boolean gender) {
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
  public AddAdmin mobile(String mobile) {
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
  public AddAdmin email(String email) {
    this.email = email;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   **/
  public AddAdmin idNumber(String idNumber) {
    this.idNumber = idNumber;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("idNumber")
  public String getIdNumber() {
    return idNumber;
  }
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddAdmin addAdmin = (AddAdmin) o;
    return Objects.equals(username, addAdmin.username) &&
        Objects.equals(name, addAdmin.name) &&
        Objects.equals(gender, addAdmin.gender) &&
        Objects.equals(mobile, addAdmin.mobile) &&
        Objects.equals(email, addAdmin.email) &&
        Objects.equals(idNumber, addAdmin.idNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, name, gender, mobile, email, idNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddAdmin {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    idNumber: ").append(toIndentedString(idNumber)).append("\n");
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

