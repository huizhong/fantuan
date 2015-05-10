package com.eeeya.fantuan.server.api.v1.model.table.status;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("会餐人员出发信息")
public class MealStartStatus extends TableElementStatus {

    @ApiModelProperty("出发信息列表")
    List<MealStartItem> mealStartItemList;

    public MealStartStatus() {
        this.mealStartItemList = new ArrayList<MealStartItem>();

        // todo 测试
        getMealStartItemList().add(new MealStartItem());
        getMealStartItemList().add(new MealStartItem());
        getMealStartItemList().add(new MealStartItem());
    }

    public List<MealStartItem> getMealStartItemList() {
        return mealStartItemList;
    }

    public void setMealStartItemList(List<MealStartItem> mealStartItemList) {
        this.mealStartItemList = mealStartItemList;
    }
}
