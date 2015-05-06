package com.eeeya.fantuan.model.table;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class TableStatus extends TableElementStatus {
    TableJoinStatus joinStatus;
    TableMessageStatus messageStatus;
    TableMealStatus mealStatus;

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
