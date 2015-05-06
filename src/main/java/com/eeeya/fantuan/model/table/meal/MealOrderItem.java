package com.eeeya.fantuan.model.table.meal;

import com.eeeya.fantuan.model.FoodItem;
import com.eeeya.fantuan.model.UserInfo;
import com.eeeya.fantuan.model.table.TableElementStatus;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class MealOrderItem extends TableElementStatus {
    UserInfo userInfo;
    FoodItem foodItem;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
