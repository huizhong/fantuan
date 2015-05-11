package com.eeeya.fantuan.api.java.client.model;

import com.eeeya.fantuan.api.java.client.model.TableMessageStatus;
import com.eeeya.fantuan.api.java.client.model.TableJoinStatus;
import com.eeeya.fantuan.api.java.client.model.MealStartStatus;
import com.eeeya.fantuan.api.java.client.model.MealVoteStatus;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class TableStatus  {
  
  private MealStartStatus mealStartStatus = null;
  private MealVoteStatus mealVoteStatus = null;
  private TableJoinStatus joinStatus = null;
  private TableMessageStatus messageStatus = null;
  private Long updateTime = null;

  
  /**
   * 会餐人员出发状态
   **/
  @ApiModelProperty(required = false, value = "会餐人员出发状态")
  @JsonProperty("mealStartStatus")
  public MealStartStatus getMealStartStatus() {
    return mealStartStatus;
  }
  public void setMealStartStatus(MealStartStatus mealStartStatus) {
    this.mealStartStatus = mealStartStatus;
  }

  
  /**
   * 菜品投票状态
   **/
  @ApiModelProperty(required = false, value = "菜品投票状态")
  @JsonProperty("mealVoteStatus")
  public MealVoteStatus getMealVoteStatus() {
    return mealVoteStatus;
  }
  public void setMealVoteStatus(MealVoteStatus mealVoteStatus) {
    this.mealVoteStatus = mealVoteStatus;
  }

  
  /**
   * 参与状态
   **/
  @ApiModelProperty(required = false, value = "参与状态")
  @JsonProperty("joinStatus")
  public TableJoinStatus getJoinStatus() {
    return joinStatus;
  }
  public void setJoinStatus(TableJoinStatus joinStatus) {
    this.joinStatus = joinStatus;
  }

  
  /**
   * 消息状态
   **/
  @ApiModelProperty(required = false, value = "消息状态")
  @JsonProperty("messageStatus")
  public TableMessageStatus getMessageStatus() {
    return messageStatus;
  }
  public void setMessageStatus(TableMessageStatus messageStatus) {
    this.messageStatus = messageStatus;
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
    sb.append("class TableStatus {\n");
    
    sb.append("  mealStartStatus: ").append(mealStartStatus).append("\n");
    sb.append("  mealVoteStatus: ").append(mealVoteStatus).append("\n");
    sb.append("  joinStatus: ").append(joinStatus).append("\n");
    sb.append("  messageStatus: ").append(messageStatus).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
