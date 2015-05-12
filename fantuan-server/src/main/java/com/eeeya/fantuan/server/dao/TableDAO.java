package com.eeeya.fantuan.server.dao;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.RestaurantMetaInfo;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.common.exception.ApiException;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public interface TableDAO {
    List<TableInfo> getAllTableByRestaurantId(Long restaurantId);

    CoordinatePosition getCoordinatePositionById(Long tableId);

    TableInfo getTableInfoByTableId(Long tableId);

    Long insertTable(RestaurantMetaInfo restaurantMetaInfo, String talkGroupId) throws ApiException;

    Long insertJoinStatus(Long tableId, Long userId) throws ApiException;

    Long insertStartStatus(Long tableId, Long userId) throws ApiException;

    Long insertVoteStatus(Long tableId, Long userId, Long foodItemId) throws ApiException;

    void removeUserJoinStatus(Long joinId) throws ApiException;
}
