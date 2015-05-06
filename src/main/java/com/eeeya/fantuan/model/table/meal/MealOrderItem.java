package com.eeeya.fantuan.model.table.meal;

import com.eeeya.fantuan.model.FoodItem;
import com.eeeya.fantuan.model.UserInfo;
import com.eeeya.fantuan.model.table.TableElementStatus;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("会餐投票条目")
public class MealOrderItem extends TableElementStatus {

    @ApiModelProperty("投票人")
    UserInfo userInfo;

    @ApiModelProperty("投的菜品")
    FoodItem foodItem;

    public MealOrderItem() {
        this.userInfo = new UserInfo();
        this.foodItem = new FoodItem();
    }

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
