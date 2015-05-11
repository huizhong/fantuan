package com.eeeya.fantuan.api.v1.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("菜品信息")
public class FoodItem {
    @ApiModelProperty("菜品唯一ID")
    Long foodId;

    @ApiModelProperty("菜品名字")
    String foodName;

    @ApiModelProperty("菜品价格")
    Integer foodPrice;

    public FoodItem() {
    }

    public FoodItem(Long foodId, String foodName, Integer foodPrice) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }


    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Integer foodPrice) {
        this.foodPrice = foodPrice;
    }
}
