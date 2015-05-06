package com.eeeya.fantuan.model.table.meal;

import com.eeeya.fantuan.model.table.TableElementStatus;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class MealOrderInfo extends TableElementStatus {
    List<MealOrderItem> mealOrderItemList;

    public List<MealOrderItem> getMealOrderItemList() {
        return mealOrderItemList;
    }

    public void setMealOrderItemList(List<MealOrderItem> mealOrderItemList) {
        this.mealOrderItemList = mealOrderItemList;
    }
}
