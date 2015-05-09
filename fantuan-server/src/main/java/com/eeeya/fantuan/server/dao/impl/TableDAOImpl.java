package com.eeeya.fantuan.server.dao.impl;

import com.eeeya.fantuan.server.api.common.ApiError;
import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.ImageInfo;
import com.eeeya.fantuan.server.api.v1.model.PriceInfo;
import com.eeeya.fantuan.server.api.v1.model.RestaurantMetaInfo;
import com.eeeya.fantuan.server.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.server.api.v1.model.table.TableStatus;
import com.eeeya.fantuan.server.config.FantuanConfig;
import com.eeeya.fantuan.server.contants.ImageType;
import com.eeeya.fantuan.server.dao.RestaurantDAO;
import com.eeeya.fantuan.server.dao.TableDAO;
import com.eeeya.fantuan.server.domain.YfTable;
import com.eeeya.fantuan.server.domain.YfTableExample;
import com.eeeya.fantuan.server.exception.ApiException;
import com.eeeya.fantuan.server.mapper.YfTableMapper;
import com.eeeya.fantuan.server.model.RestaurantFullInfo;
import com.eeeya.fantuan.server.utils.DomainUtils;
import com.eeeya.fantuan.server.utils.FoodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
@Repository
public class TableDAOImpl implements TableDAO {
    @Autowired
    YfTableMapper yfTableMapper;

    @Autowired
    RestaurantDAO restaurantDAO;

    @Override
    public List<TableInfo> getAllTableByRestaurantId(Long restaurantId) {
        YfTableExample yfTableExample = new YfTableExample();
        yfTableExample.or().andRestaurantIdEqualTo(restaurantId);
        yfTableExample.setOrderByClause("id asc");
        List<YfTable> yfTableList = yfTableMapper.selectByExample(yfTableExample);

        List<TableInfo> tableInfoList = new ArrayList<TableInfo>();
        for(int i=0; i< yfTableList.size(); i++){
            tableInfoList.add(getTableInfoByDomain(yfTableList.get(i), i+1));
        }
        return tableInfoList;
    }

    @Override
    public CoordinatePosition getCoordinatePositionById(Long tableId) {
        YfTable yfTable = yfTableMapper.selectByPrimaryKey(tableId);
        RestaurantMetaInfo restaurantMetaInfo = restaurantDAO.getRestaurantMetaInfo(yfTable.getRestaurantId());
        return restaurantMetaInfo.getCoordinatePosition();
    }

    @Override
    public TableInfo getTableInfoByTableId(Long tableId) {
        YfTable yfTable = yfTableMapper.selectByPrimaryKey(tableId);
        Integer tableIndex = getTableIndex(yfTable.getId(), yfTable.getRestaurantId());
        return getTableInfoByDomain(yfTable, tableIndex);
    }

    @Override
    public Long insertTable(RestaurantMetaInfo restaurantMetaInfo) {
        YfTable yfTable = new YfTable();
        yfTable.setMealType(FantuanConfig.DEFAULT_MEAL_TYPE.getValue());
        yfTable.setTableType(FantuanConfig.DEFAULT_TABLE_TYPE.getValue());
        yfTable.setPayType(FantuanConfig.DEFAULT_PAY_TYPE.getValue());
        yfTable.setRestaurantId(restaurantMetaInfo.getRestaurantId());
        // todo talk group
        yfTable.setTalkGroupId(FantuanConfig.DEFAULT_TALK_GROUP_ID);
        if( 1 == yfTableMapper.insertSelective(yfTable)){
            return yfTable.getId();
        }
        else{
            throw new ApiException(ApiError.DATABASE_INSERT_FAILED);
        }
    }

    private TableInfo getTableInfoByDomain(YfTable yfTable, Integer tableIndex) {
        TableInfo tableInfo = new TableInfo();
        DomainUtils.loadTableDomain(tableInfo, yfTable);

        RestaurantFullInfo restaurantFullInfo = restaurantDAO.getRestaurantFullInfo(yfTable.getRestaurantId());

        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setImageType(ImageType.TABLE_LOGO);
        imageInfo.setImageUrl(restaurantFullInfo.getRestaurantImage().getImageUrl());
        tableInfo.setTableLogo(imageInfo);

        tableInfo.setRestaurantInfo(restaurantFullInfo);

        tableInfo.setTableIndex(tableIndex);

        PriceInfo priceInfo = new PriceInfo();
        priceInfo.setPriceUnit(FantuanConfig.TABLE_AVERAGE_PRICE_UNIT);
        priceInfo.setPriceValue(FoodUtils.getFoodAveragePriceValue(restaurantFullInfo.getFoodItemList()));
        tableInfo.setAveragePrice(priceInfo);

        tableInfo.setTableStatus(getTableStatusByTableId(yfTable.getId()));

        return tableInfo;
    }

    private Integer getTableIndex(Long tableId, Long restaurantId) {
        YfTableExample yfTableExample = new YfTableExample();
        yfTableExample.or().andRestaurantIdEqualTo(restaurantId);
        yfTableExample.or().andIdLessThanOrEqualTo(tableId);
        return yfTableMapper.countByExample(yfTableExample);
    }

    private TableStatus getTableStatusByTableId(Long tableId) {
        // todo
        return new TableStatus();
    }
}
