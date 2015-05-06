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
@ApiModel("会餐人员出发信息")
public class MealStartInfo extends TableElementStatus {

    @ApiModelProperty("出发信息列表")
    List<MealStartItem> mealStartItemList;

    public MealStartInfo() {
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
