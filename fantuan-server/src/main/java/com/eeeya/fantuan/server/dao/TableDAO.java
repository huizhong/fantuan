package com.eeeya.fantuan.server.dao;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.RestaurantMetaInfo;
import com.eeeya.fantuan.server.api.v1.model.table.TableInfo;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public interface TableDAO {
    List<TableInfo> getAllTableByRestaurantId(Long restaurantId);

    CoordinatePosition getCoordinatePositionById(Long tableId);

    TableInfo getTableInfoByTableId(Long tableId);

    Long insertTable(RestaurantMetaInfo restaurantMetaInfo);

    Long insertJoinStatus(Long tableId, Long userId);
}
