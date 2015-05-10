package com.eeeya.fantuan.server.service;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.server.exception.ApiException;
import com.eeeya.fantuan.server.model.RestaurantFullInfo;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public interface TableService {
    CoordinatePosition getTableCoordinatePosition(Long tableId);

    TableInfo getRestaurantRecommendTable(RestaurantFullInfo restaurantFullInfo) throws ApiException;

    TableInfo getTableInfo(Long tableId);

    TableInfo getNextTable(Long tableId);

    TableInfo joinTable(Long tableId, Long userId);
}
