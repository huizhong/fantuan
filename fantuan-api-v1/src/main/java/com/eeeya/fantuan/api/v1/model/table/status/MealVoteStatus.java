package com.eeeya.fantuan.api.v1.model.table.status;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("会餐投票信息")
public class MealVoteStatus extends TableElementStatus {
    @ApiModelProperty("会餐投票列表")
    List<MealVoteItem> mealVoteItemList;

    public List<MealVoteItem> getMealVoteItemList() {
        return mealVoteItemList;
    }

    public void setMealVoteItemList(List<MealVoteItem> mealVoteItemList) {
        this.mealVoteItemList = mealVoteItemList;
    }

}
