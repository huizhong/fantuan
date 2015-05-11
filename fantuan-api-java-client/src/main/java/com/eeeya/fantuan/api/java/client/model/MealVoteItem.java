package com.eeeya.fantuan.api.java.client.model;

import com.eeeya.fantuan.api.java.client.model.UserInfo;
import com.eeeya.fantuan.api.java.client.model.FoodItem;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class MealVoteItem  {
  
  private UserInfo userInfo = null;
  private FoodItem foodItem = null;
  private Long voteTime = null;
  private Long updateTime = null;

  
  /**
   * 投票人
   **/
  @ApiModelProperty(required = false, value = "投票人")
  @JsonProperty("userInfo")
  public UserInfo getUserInfo() {
    return userInfo;
  }
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  
  /**
   * 投的菜品
   **/
  @ApiModelProperty(required = false, value = "投的菜品")
  @JsonProperty("foodItem")
  public FoodItem getFoodItem() {
    return foodItem;
  }
  public void setFoodItem(FoodItem foodItem) {
    this.foodItem = foodItem;
  }

  
  /**
   * 投票时间
   **/
  @ApiModelProperty(required = false, value = "投票时间")
  @JsonProperty("voteTime")
  public Long getVoteTime() {
    return voteTime;
  }
  public void setVoteTime(Long voteTime) {
    this.voteTime = voteTime;
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
    sb.append("class MealVoteItem {\n");
    
    sb.append("  userInfo: ").append(userInfo).append("\n");
    sb.append("  foodItem: ").append(foodItem).append("\n");
    sb.append("  voteTime: ").append(voteTime).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
