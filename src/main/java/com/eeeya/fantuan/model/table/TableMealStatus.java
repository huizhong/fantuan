package com.eeeya.fantuan.model.table;

import com.eeeya.fantuan.model.table.meal.MealOrderInfo;
import com.eeeya.fantuan.model.table.meal.MealStartInfo;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class TableMealStatus extends TableElementStatus {
    MealOrderInfo mealOrderInfo;
    MealStartInfo mealStartInfo;

    public MealOrderInfo getMealOrderInfo() {
        return mealOrderInfo;
    }

    public void setMealOrderInfo(MealOrderInfo mealOrderInfo) {
        this.mealOrderInfo = mealOrderInfo;
    }

    public MealStartInfo getMealStartInfo() {
        return mealStartInfo;
    }

    public void setMealStartInfo(MealStartInfo mealStartInfo) {
        this.mealStartInfo = mealStartInfo;
    }
}
