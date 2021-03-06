package com.eeeya.fantuan.api.v1.model.table.status;

import com.eeeya.fantuan.api.v1.model.FoodItem;
import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("会餐投票条目")
public class MealVoteItem extends TableElementStatus {

    @ApiModelProperty("投票人")
    UserInfo userInfo;

    @ApiModelProperty("投的菜品")
    FoodItem foodItem;

    @ApiModelProperty("投票时间")
    Long voteTime;

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

    public Long getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(Long voteTime) {
        this.voteTime = voteTime;
    }
}
