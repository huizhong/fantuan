package com.eeeya.fantuan.api.java.client.model;

import com.eeeya.fantuan.api.java.client.model.CoordinatePosition;
import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class RestaurantInfo  {
  
  private List foodItemList = null;
  private String fullName = null;
  private String shortName = null;
  private Long restaurantId = null;
  private CoordinatePosition coordinatePosition = null;
  private String restaurantPhone = null;
  private String restaurantAddress = null;
  private Integer maxTable = null;

  
  /**
   * 菜品列表
   **/
  @ApiModelProperty(required = false, value = "菜品列表")
  @JsonProperty("foodItemList")
  public List getFoodItemList() {
    return foodItemList;
  }
  public void setFoodItemList(List foodItemList) {
    this.foodItemList = foodItemList;
  }

  
  /**
   * 全名称，比如'金百万（望京店）'
   **/
  @ApiModelProperty(required = false, value = "全名称，比如'金百万（望京店）'")
  @JsonProperty("fullName")
  public String getFullName() {
    return fullName;
  }
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  
  /**
   * 短名称，比如'金百万'
   **/
  @ApiModelProperty(required = false, value = "短名称，比如'金百万'")
  @JsonProperty("shortName")
  public String getShortName() {
    return shortName;
  }
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  
  /**
   * 餐厅唯一ID
   **/
  @ApiModelProperty(required = false, value = "餐厅唯一ID")
  @JsonProperty("restaurantId")
  public Long getRestaurantId() {
    return restaurantId;
  }
  public void setRestaurantId(Long restaurantId) {
    this.restaurantId = restaurantId;
  }

  
  /**
   * 餐厅经纬度
   **/
  @ApiModelProperty(required = false, value = "餐厅经纬度")
  @JsonProperty("coordinatePosition")
  public CoordinatePosition getCoordinatePosition() {
    return coordinatePosition;
  }
  public void setCoordinatePosition(CoordinatePosition coordinatePosition) {
    this.coordinatePosition = coordinatePosition;
  }

  
  /**
   * 餐厅电话
   **/
  @ApiModelProperty(required = false, value = "餐厅电话")
  @JsonProperty("restaurantPhone")
  public String getRestaurantPhone() {
    return restaurantPhone;
  }
  public void setRestaurantPhone(String restaurantPhone) {
    this.restaurantPhone = restaurantPhone;
  }

  
  /**
   * 餐厅地址
   **/
  @ApiModelProperty(required = false, value = "餐厅地址")
  @JsonProperty("restaurantAddress")
  public String getRestaurantAddress() {
    return restaurantAddress;
  }
  public void setRestaurantAddress(String restaurantAddress) {
    this.restaurantAddress = restaurantAddress;
  }

  
  /**
   * 最大饭桌数
   **/
  @ApiModelProperty(required = false, value = "最大饭桌数")
  @JsonProperty("maxTable")
  public Integer getMaxTable() {
    return maxTable;
  }
  public void setMaxTable(Integer maxTable) {
    this.maxTable = maxTable;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestaurantInfo {\n");
    
    sb.append("  foodItemList: ").append(foodItemList).append("\n");
    sb.append("  fullName: ").append(fullName).append("\n");
    sb.append("  shortName: ").append(shortName).append("\n");
    sb.append("  restaurantId: ").append(restaurantId).append("\n");
    sb.append("  coordinatePosition: ").append(coordinatePosition).append("\n");
    sb.append("  restaurantPhone: ").append(restaurantPhone).append("\n");
    sb.append("  restaurantAddress: ").append(restaurantAddress).append("\n");
    sb.append("  maxTable: ").append(maxTable).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
