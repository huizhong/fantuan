package com.eeeya.fantuan.model.table.meal;

import com.eeeya.fantuan.model.table.TableElementStatus;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class MealStartInfo extends TableElementStatus {
    List<MealStartItem> mealStartItemList;

    public List<MealStartItem> getMealStartItemList() {
        return mealStartItemList;
    }

    public void setMealStartItemList(List<MealStartItem> mealStartItemList) {
        this.mealStartItemList = mealStartItemList;
    }
}
