package com.eeeya.fantuan.api.java.client.model;

import com.eeeya.fantuan.api.java.client.model.UserInfo;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class MealStartItem  {
  
  private UserInfo userInfo = null;
  private Long startTime = null;
  private Long updateTime = null;

  
  /**
   * 会餐人员
   **/
  @ApiModelProperty(required = false, value = "会餐人员")
  @JsonProperty("userInfo")
  public UserInfo getUserInfo() {
    return userInfo;
  }
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  
  /**
   * 出发时间
   **/
  @ApiModelProperty(required = false, value = "出发时间")
  @JsonProperty("startTime")
  public Long getStartTime() {
    return startTime;
  }
  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }

  
  /**
   * 状态更新时间
   **/
  @ApiModelProperty(required = false, value = "状态更新时间")
  @JsonProperty("updateTime")
  public Long getUpdateTime() {
    return updateTime;
  }
  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MealStartItem {\n");
    
    sb.append("  userInfo: ").append(userInfo).append("\n");
    sb.append("  startTime: ").append(startTime).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
