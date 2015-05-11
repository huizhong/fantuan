package com.eeeya.fantuan.api.java.client.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class FoodItem  {
  
  private String foodName = null;
  private Integer foodPrice = null;
  private Long foodId = null;

  
  /**
   * 菜品名字
   **/
  @ApiModelProperty(required = false, value = "菜品名字")
  @JsonProperty("foodName")
  public String getFoodName() {
    return foodName;
  }
  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  
  /**
   * 菜品价格
   **/
  @ApiModelProperty(required = false, value = "菜品价格")
  @JsonProperty("foodPrice")
  public Integer getFoodPrice() {
    return foodPrice;
  }
  public void setFoodPrice(Integer foodPrice) {
    this.foodPrice = foodPrice;
  }

  
  /**
   * 菜品唯一ID
   **/
  @ApiModelProperty(required = false, value = "菜品唯一ID")
  @JsonProperty("foodId")
  public Long getFoodId() {
    return foodId;
  }
  public void setFoodId(Long foodId) {
    this.foodId = foodId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoodItem {\n");
    
    sb.append("  foodName: ").append(foodName).append("\n");
    sb.append("  foodPrice: ").append(foodPrice).append("\n");
    sb.append("  foodId: ").append(foodId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
