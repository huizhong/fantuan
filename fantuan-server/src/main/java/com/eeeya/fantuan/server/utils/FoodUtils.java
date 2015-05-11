package com.eeeya.fantuan.server.utils;

import com.eeeya.fantuan.api.v1.model.FoodItem;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public class FoodUtils {
    public static Integer getFoodAveragePriceValue(List<FoodItem> foodItemList) {
        Integer sum = 0;
        Integer size = 0;
        for(FoodItem foodItem : foodItemList){
            if(foodItem.getFoodPrice() == null){
                continue;
            }
            sum += foodItem.getFoodPrice();
            size ++;
        }
        if(size == 0){
            return null;
        }
        return sum/size;
    }
}
