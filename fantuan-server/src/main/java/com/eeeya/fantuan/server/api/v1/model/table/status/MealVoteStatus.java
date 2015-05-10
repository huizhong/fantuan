package com.eeeya.fantuan.server.api.v1.model.table.status;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("会餐投票信息")
public class MealVoteStatus extends TableElementStatus {
    @ApiModelProperty("会餐投票列表")
    List<MealVoteItem> mealVoteItemList;

    public MealVoteStatus() {
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
