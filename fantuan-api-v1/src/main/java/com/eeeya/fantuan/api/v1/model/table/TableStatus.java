package com.eeeya.fantuan.api.v1.model.table;

import com.eeeya.fantuan.api.v1.model.table.status.*;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐桌状态")
public class TableStatus extends TableElementStatus {

    @ApiModelProperty("参与状态")
    TableJoinStatus joinStatus;

    @ApiModelProperty("消息状态")
    TableMessageStatus messageStatus;

    @ApiModelProperty("菜品投票状态")
    MealVoteStatus mealVoteStatus;

    @ApiModelProperty("会餐人员出发状态")
    MealStartStatus mealStartStatus;


    public TableJoinStatus getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(TableJoinStatus joinStatus) {
        this.joinStatus = joinStatus;
    }

    public TableMessageStatus getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(TableMessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }

    public MealVoteStatus getMealVoteStatus() {
        return mealVoteStatus;
    }

    public void setMealVoteStatus(MealVoteStatus mealVoteStatus) {
        this.mealVoteStatus = mealVoteStatus;
    }

    public MealStartStatus getMealStartStatus() {
        return mealStartStatus;
    }

    public void setMealStartStatus(MealStartStatus mealStartStatus) {
        this.mealStartStatus = mealStartStatus;
    }
}
