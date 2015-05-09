package com.eeeya.fantuan.server.api.v1.model.table;

import com.eeeya.fantuan.server.contants.MealType;
import com.eeeya.fantuan.server.contants.PayType;
import com.eeeya.fantuan.server.contants.TableType;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐桌元信息，不包含状态和图片等复杂信息")
public class TableMetaInfo {

    @ApiModelProperty("餐桌唯一ID")
    Long tableId;

    @ApiModelProperty("会餐时间")
    Long mealTime;

    @ApiModelProperty("会餐类型")
    MealType mealType;

    @ApiModelProperty("餐桌座位类型")
    TableType tableType;


    @ApiModelProperty("餐桌付款方式")
    PayType payType;

    @ApiModelProperty("餐厅ID")
    Long restaurantId;

    @ApiModelProperty("环信群聊ID")
    Integer talkGroupId;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getMealTime() {
        return mealTime;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public void setMealTime(Long mealTime) {
        this.mealTime = mealTime;
    }

    public TableType getTableType() {
        return tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getTalkGroupId() {
        return talkGroupId;
    }

    public void setTalkGroupId(Integer talkGroupId) {
        this.talkGroupId = talkGroupId;
    }

}
