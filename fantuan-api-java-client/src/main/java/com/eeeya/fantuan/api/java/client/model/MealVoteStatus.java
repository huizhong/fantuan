package com.eeeya.fantuan.api.java.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * 
 **/
@ApiModel(description = "")
public class MealVoteStatus  {
  
  private List mealVoteItemList = null;
  private Long updateTime = null;

  
  /**
   * 会餐投票列表
   **/
  @ApiModelProperty(required = false, value = "会餐投票列表")
  @JsonProperty("mealVoteItemList")
  public List getMealVoteItemList() {
    return mealVoteItemList;
  }
  public void setMealVoteItemList(List mealVoteItemList) {
    this.mealVoteItemList = mealVoteItemList;
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
    sb.append("class MealVoteStatus {\n");
    
    sb.append("  mealVoteItemList: ").append(mealVoteItemList).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
