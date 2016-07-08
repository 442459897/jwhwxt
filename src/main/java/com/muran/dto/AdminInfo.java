package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;



/**
 * \u4EBA\u5458\u4FE1\u606F\u5BF9\u8C61
 **/

@ApiModel(description = "\u4EBA\u5458\u4FE1\u606F\u5BF9\u8C61")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class AdminInfo   {
  
  private Long autoId = null;
  private String username = null;
  private String name = null;
  private Boolean gender = null;
  private String mobile = null;
  private String email = null;
  private String idNumber = null;
  private Boolean enable = null;
  private Date createTime = null;
  private String createMan = null;
  private Date modifyTime = null;
  private String modifyMan = null;

  /**
   **/
  public AdminInfo autoId(Long autoId) {
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
  public AdminInfo username(String username) {
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
  public AdminInfo name(String name) {
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
  public AdminInfo gender(Boolean gender) {
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
  public AdminInfo mobile(String mobile) {
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
  public AdminInfo email(String email) {
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
  public AdminInfo idNumber(String idNumber) {
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

  /**
   **/
  public AdminInfo enable(Boolean enable) {
    this.enable = enable;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("enable")
  public Boolean getEnable() {
    return enable;
  }
  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  /**
   **/
  public AdminInfo createTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("createTime")
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   **/
  public AdminInfo createMan(String createMan) {
    this.createMan = createMan;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("createMan")
  public String getCreateMan() {
    return createMan;
  }
  public void setCreateMan(String createMan) {
    this.createMan = createMan;
  }

  /**
   **/
  public AdminInfo modifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("modifyTime")
  public Date getModifyTime() {
    return modifyTime;
  }
  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  /**
   **/
  public AdminInfo modifyMan(String modifyMan) {
    this.modifyMan = modifyMan;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("modifyMan")
  public String getModifyMan() {
    return modifyMan;
  }
  public void setModifyMan(String modifyMan) {
    this.modifyMan = modifyMan;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminInfo adminInfo = (AdminInfo) o;
    return Objects.equals(autoId, adminInfo.autoId) &&
        Objects.equals(username, adminInfo.username) &&
        Objects.equals(name, adminInfo.name) &&
        Objects.equals(gender, adminInfo.gender) &&
        Objects.equals(mobile, adminInfo.mobile) &&
        Objects.equals(email, adminInfo.email) &&
        Objects.equals(idNumber, adminInfo.idNumber) &&
        Objects.equals(enable, adminInfo.enable) &&
        Objects.equals(createTime, adminInfo.createTime) &&
        Objects.equals(createMan, adminInfo.createMan) &&
        Objects.equals(modifyTime, adminInfo.modifyTime) &&
        Objects.equals(modifyMan, adminInfo.modifyMan);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoId, username, name, gender, mobile, email, idNumber, enable, createTime, createMan, modifyTime, modifyMan);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminInfo {\n");
    
    sb.append("    autoId: ").append(toIndentedString(autoId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    idNumber: ").append(toIndentedString(idNumber)).append("\n");
    sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createMan: ").append(toIndentedString(createMan)).append("\n");
    sb.append("    modifyTime: ").append(toIndentedString(modifyTime)).append("\n");
    sb.append("    modifyMan: ").append(toIndentedString(modifyMan)).append("\n");
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

