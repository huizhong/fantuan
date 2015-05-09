package com.eeeya.fantuan.dao;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public interface TableDAO {
    List<TableInfo> getAllTableByRestaurantId(Long restaurantId);

    CoordinatePosition getCoordinatePositionById(Long tableId);
}
