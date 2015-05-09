package com.eeeya.fantuan.api.v1.model.table.meal;

import com.eeeya.fantuan.api.v1.model.table.TableElementStatus;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("会餐投票信息")
public class MealVoteInfo extends TableElementStatus {
    @ApiModelProperty("会餐投票列表")
    List<MealVoteItem> mealVoteItemList;

    public MealVoteInfo() {
        this.mealVoteItemList = new ArrayList<MealVoteItem>();

        // todo 测试数据
        getMealVoteItemList().add(new MealVoteItem());
        getMealVoteItemList().add(new MealVoteItem());
        getMealVoteItemList().add(new MealVoteItem());
    }

    public List<MealVoteItem> getMealVoteItemList() {
        return mealVoteItemList;
    }

    public void setMealVoteItemList(List<MealVoteItem> mealVoteItemList) {
        this.mealVoteItemList = mealVoteItemList;
    }

}
