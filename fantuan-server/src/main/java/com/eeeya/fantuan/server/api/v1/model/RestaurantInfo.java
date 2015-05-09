package com.eeeya.fantuan.server.api.v1.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐厅信息")
public class RestaurantInfo extends RestaurantMetaInfo {

    @ApiModelProperty("菜品列表")
    List<FoodItem> foodItemList;

    public RestaurantInfo() {
        super();
        this.foodItemList = new ArrayList<FoodItem>();
    }
    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }
}
