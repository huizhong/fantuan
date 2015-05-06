package com.eeeya.fantuan.model.table.meal;

import com.eeeya.fantuan.model.table.TableElementStatus;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("会餐投票信息")
public class MealOrderInfo extends TableElementStatus {
    @ApiModelProperty("会餐投票列表")
    List<MealOrderItem> mealOrderItemList;

    public MealOrderInfo() {
        this.mealOrderItemList = new ArrayList<MealOrderItem>();

        // todo 测试数据
        getMealOrderItemList().add(new MealOrderItem());
        getMealOrderItemList().add(new MealOrderItem());
        getMealOrderItemList().add(new MealOrderItem());
    }

    public List<MealOrderItem> getMealOrderItemList() {
        return mealOrderItemList;
    }

    public void setMealOrderItemList(List<MealOrderItem> mealOrderItemList) {
        this.mealOrderItemList = mealOrderItemList;
    }
}
