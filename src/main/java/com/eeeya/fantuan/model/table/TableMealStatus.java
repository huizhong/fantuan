package com.eeeya.fantuan.model.table;

import com.eeeya.fantuan.model.table.meal.MealVoteInfo;
import com.eeeya.fantuan.model.table.meal.MealStartInfo;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐桌会餐状态")
public class TableMealStatus extends TableElementStatus {

    @ApiModelProperty("菜品投票状态")
    MealVoteInfo mealVoteInfo;

    @ApiModelProperty("会餐人员出发状态")
    MealStartInfo mealStartInfo;

    public TableMealStatus() {
        this.mealVoteInfo = new MealVoteInfo();
        this.mealStartInfo = new MealStartInfo();
    }

    public MealVoteInfo getMealVoteInfo() {
        return mealVoteInfo;
    }

    public void setMealVoteInfo(MealVoteInfo mealVoteInfo) {
        this.mealVoteInfo = mealVoteInfo;
    }

    public MealStartInfo getMealStartInfo() {
        return mealStartInfo;
    }

    public void setMealStartInfo(MealStartInfo mealStartInfo) {
        this.mealStartInfo = mealStartInfo;
    }
}
