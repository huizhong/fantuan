package com.eeeya.fantuan.api.v1.model.table;

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

    @ApiModelProperty("会餐状态")
    TableMealStatus mealStatus;

    public TableStatus() {
        this.joinStatus = new TableJoinStatus();
        this.messageStatus = new TableMessageStatus();
        this.mealStatus = new TableMealStatus();
    }

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

    public TableMealStatus getMealStatus() {
        return mealStatus;
    }

    public void setMealStatus(TableMealStatus mealStatus) {
        this.mealStatus = mealStatus;
    }
}
