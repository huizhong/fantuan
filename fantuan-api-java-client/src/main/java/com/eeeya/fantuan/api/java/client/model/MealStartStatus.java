package com.eeeya.fantuan.api.java.client.model;

import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class MealStartStatus  {
  
  private List mealStartItemList = null;
  private Long updateTime = null;

  
  /**
   * 出发信息列表
   **/
  @ApiModelProperty(required = false, value = "出发信息列表")
  @JsonProperty("mealStartItemList")
  public List getMealStartItemList() {
    return mealStartItemList;
  }
  public void setMealStartItemList(List mealStartItemList) {
    this.mealStartItemList = mealStartItemList;
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
    sb.append("class MealStartStatus {\n");
    
    sb.append("  mealStartItemList: ").append(mealStartItemList).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
