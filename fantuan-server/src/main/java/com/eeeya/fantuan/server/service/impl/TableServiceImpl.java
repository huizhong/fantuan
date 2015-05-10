package com.eeeya.fantuan.server.service.impl;

import com.eeeya.fantuan.server.api.common.ApiError;
import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.RestaurantMetaInfo;
import com.eeeya.fantuan.server.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.server.dao.TableDAO;
import com.eeeya.fantuan.server.exception.ApiException;
import com.eeeya.fantuan.server.model.RestaurantFullInfo;
import com.eeeya.fantuan.server.service.RestaurantService;
import com.eeeya.fantuan.server.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
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
    public TableInfo getRestaurantRecommendTable(RestaurantFullInfo restaurantFullInfo){
        List<TableInfo> tableInfoList =  tableDAO.getAllTableByRestaurantId(restaurantFullInfo.getRestaurantId());
        TableInfo tableInfo;
        if(tableInfoList.isEmpty()){
            tableInfo = insertTable(restaurantFullInfo);
        }
        else{
            // todo 目前随机选
            int randTableIndex = (int) (Math.random() * tableInfoList.size());
            tableInfo = tableInfoList.get(randTableIndex);
        }
        tableInfo.setRestaurantInfo(restaurantFullInfo);
        tableInfo.setTableLogo(restaurantFullInfo.getRestaurantImage());
        return tableInfo;

    }

    @NotNull
    private TableInfo insertTable(RestaurantMetaInfo restaurantMetaInfo){
        Long newTableId = tableDAO.insertTable(restaurantMetaInfo);
        return getTableInfo(newTableId);
    }

    @Override
    public TableInfo getTableInfo(Long tableId) {
        return tableDAO.getTableInfoByTableId(tableId);
    }

    @Override
    public TableInfo getNextTable(Long tableId) {
        TableInfo tableInfo = tableDAO.getTableInfoByTableId(tableId);
        List<TableInfo> tableInfoList = tableDAO.getAllTableByRestaurantId(tableInfo.getRestaurantId()); // 需要按table index排序
        TableInfo lastTable = tableInfoList.get(tableInfoList.size() - 1);
        if(tableId.equals(lastTable.getTableId())){
            if( lastTable.getTableStatus().getJoinStatus().getJoinNumber() != 0
                && lastTable.getRestaurantInfo().getMaxTable() > lastTable.getTableIndex()
                ){
                    return insertTable(lastTable.getRestaurantInfo());
                }
            else {
                    return tableInfoList.get(0);
                }
        }
        for(TableInfo tableInfoElement : tableInfoList){
            if(tableInfoElement.getTableIndex() > tableInfo.getTableIndex() ){
                return tableInfoElement;
            }
        }
        throw new ApiException(ApiError.UNKNOWN_EXCEPTION);
    }

    @Override
    public TableInfo joinTable(Long tableId, Long userId) {
        Long joinId = tableDAO.insertJoinStatus(tableId, userId);
        // todo 插入失败时提示
        return getTableInfo(tableId);
    }

    @Override
    public TableInfo startMeal(Long tableId, Long userId) {
        Long startId = tableDAO.insertStartStatus(tableId, userId);
        // todo 插入失败时提示
        return getTableInfo(tableId);
    }

    @Override
    public TableInfo voteMeal(Long tableId, Long userId, Long foodItemId) {
        Long voteId = tableDAO.insertVoteStatus(tableId, userId, foodItemId);
        // todo 插入失败时提示
        return getTableInfo(tableId);
    }
}
