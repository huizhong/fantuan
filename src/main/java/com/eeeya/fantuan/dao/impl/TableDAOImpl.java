package com.eeeya.fantuan.dao.impl;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.dao.TableDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
@Repository
public class TableDAOImpl implements TableDAO {
    @Override
    public List<TableInfo> getAllTableByRestaurantId(Long restaurantId) {
        // todo
        List<TableInfo> tableInfoList = new ArrayList<TableInfo>();
        tableInfoList.add(new TableInfo());
        tableInfoList.add(new TableInfo());
        tableInfoList.add(new TableInfo());
        return tableInfoList;
    }

    @Override
    public CoordinatePosition getCoordinatePositionById(Long tableId) {
        // todo
        return new CoordinatePosition();
    }
}
