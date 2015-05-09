package com.eeeya.fantuan.service;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.model.RestaurantFullInfo;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public interface TableService {
    CoordinatePosition getTableCoordinatePosition(Long tableId);

    TableInfo getRestaurantRecommendTable(RestaurantFullInfo restaurantFullInfo);
}
