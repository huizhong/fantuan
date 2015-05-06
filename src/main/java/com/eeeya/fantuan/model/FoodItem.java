package com.eeeya.fantuan.model;

import com.eeeya.fantuan.config.FantuanConfig;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class FoodItem {
    Long foodId;
    String foodName;
    Integer foodPrice;

    public FoodItem(Long foodId, String foodName, Integer foodPrice) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public FoodItem() {
        this(
                FantuanConfig.DEFAULT_FOOD_ID,
                FantuanConfig.DEFAULT_FOOD_NAME,
                FantuanConfig.DEFAULT_FOOD_PRICE
        );
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
