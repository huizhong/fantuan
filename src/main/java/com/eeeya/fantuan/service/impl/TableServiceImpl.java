package com.eeeya.fantuan.service.impl;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.dao.TableDAO;
import com.eeeya.fantuan.model.RestaurantFullInfo;
import com.eeeya.fantuan.service.RestaurantService;
import com.eeeya.fantuan.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
@Service
public class TableServiceImpl implements TableService {

    @Autowired
    TableDAO tableDAO;

    @Autowired
    RestaurantService restaurantService;

    @Override
    public CoordinatePosition getTableCoordinatePosition(Long tableId) {
        return tableDAO.getCoordinatePositionById(tableId);
    }

    @Override
    public TableInfo getRestaurantRecommendTable(RestaurantFullInfo restaurantFullInfo) {
        List<TableInfo> tableInfoList =  tableDAO.getAllTableByRestaurantId(restaurantFullInfo.getRestaurantId());
        // todo 目前随机选
        int randTableIndex = (int) (Math.random() * tableInfoList.size());
        TableInfo tableInfo = tableInfoList.get(randTableIndex);
        tableInfo.setRestaurantInfo(restaurantFullInfo);
        tableInfo.setTableLogo(restaurantFullInfo.getRestaurantImage());
        return tableInfo;

    }


}
