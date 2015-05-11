package com.eeeya.fantuan.api.java.client.model;

import com.eeeya.fantuan.api.java.client.model.ImageInfo;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class UserInfo  {
  
  private ImageInfo userLogo = null;
  private String userPhone = null;
  private String userName = null;
  private Long userId = null;

  
  /**
   * 用于展示在桌面上的圆头像
   **/
  @ApiModelProperty(required = false, value = "用于展示在桌面上的圆头像")
  @JsonProperty("userLogo")
  public ImageInfo getUserLogo() {
    return userLogo;
  }
  public void setUserLogo(ImageInfo userLogo) {
    this.userLogo = userLogo;
  }

  
  /**
   * 手机号
   **/
  @ApiModelProperty(required = false, value = "手机号")
  @JsonProperty("userPhone")
  public String getUserPhone() {
    return userPhone;
  }
  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  
  /**
   * 用户名
   **/
  @ApiModelProperty(required = false, value = "用户名")
  @JsonProperty("userName")
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  
  /**
   * 用户Id
   **/
  @ApiModelProperty(required = false, value = "用户Id")
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    
    sb.append("  userLogo: ").append(userLogo).append("\n");
    sb.append("  userPhone: ").append(userPhone).append("\n");
    sb.append("  userName: ").append(userName).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
