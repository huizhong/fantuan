package com.eeeya.fantuan.server.dao.impl;

import com.eeeya.fantuan.server.api.common.ApiError;
import com.eeeya.fantuan.server.api.v1.model.*;
import com.eeeya.fantuan.server.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.server.api.v1.model.table.TableStatus;
import com.eeeya.fantuan.server.api.v1.model.table.status.MealStartStatus;
import com.eeeya.fantuan.server.api.v1.model.table.status.MealVoteStatus;
import com.eeeya.fantuan.server.api.v1.model.table.status.TableJoinStatus;
import com.eeeya.fantuan.server.api.v1.model.table.status.TableMessageStatus;
import com.eeeya.fantuan.server.config.FantuanConfig;
import com.eeeya.fantuan.server.contants.ImageType;
import com.eeeya.fantuan.server.contants.TableIconType;
import com.eeeya.fantuan.server.dao.RestaurantDAO;
import com.eeeya.fantuan.server.dao.TableDAO;
import com.eeeya.fantuan.server.dao.UserDAO;
import com.eeeya.fantuan.server.domain.YfTable;
import com.eeeya.fantuan.server.domain.YfTableExample;
import com.eeeya.fantuan.server.domain.YfTableJoin;
import com.eeeya.fantuan.server.domain.YfTableJoinExample;
import com.eeeya.fantuan.server.exception.ApiException;
import com.eeeya.fantuan.server.mapper.YfTableJoinMapper;
import com.eeeya.fantuan.server.mapper.YfTableMapper;
import com.eeeya.fantuan.server.model.RestaurantFullInfo;
import com.eeeya.fantuan.server.utils.DomainUtils;
import com.eeeya.fantuan.server.utils.FoodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    YfTableJoinMapper yfTableJoinMapper;

    @Autowired
    UserDAO userDAO;

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

    @Override
    public Long insertJoinStatus(Long tableId, Long userId) {
        YfTableJoin yfTableJoin = new YfTableJoin();
        yfTableJoin.setTableId(tableId);
        yfTableJoin.setUserId(userId);
        try {
            Integer affectNumber = yfTableJoinMapper.insertSelective(yfTableJoin);
            if(affectNumber == 1){
                return yfTableJoin.getId();
            }
        }catch (DuplicateKeyException ignore){}
        return null;
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

        tableInfo.setTableStatus(getTableStatusByTableId(yfTable.getId(), tableInfo.getTableType().getValue()));

        return tableInfo;
    }

    private Integer getTableIndex(Long tableId, Long restaurantId) {
        YfTableExample yfTableExample = new YfTableExample();
        yfTableExample.or().andRestaurantIdEqualTo(restaurantId).andIdLessThanOrEqualTo(tableId);
        return yfTableMapper.countByExample(yfTableExample);
    }

    private TableStatus getTableStatusByTableId(Long tableId, Byte tableSize) {
        TableJoinStatus joinStatus = getTableJoinStatus(tableId, tableSize);

        TableStatus tableStatus = new TableStatus();
        tableStatus.setJoinStatus(joinStatus);

        // todo
        tableStatus.setMessageStatus(new TableMessageStatus());
        tableStatus.setMealVoteStatus(new MealVoteStatus());
        tableStatus.setMealStartStatus(new MealStartStatus());
        return tableStatus;
    }

    private TableJoinStatus getTableJoinStatus(Long tableId, Byte tableSize) {
        TableJoinStatus joinStatus = new TableJoinStatus();
        YfTableJoinExample yfTableJoinExample = new YfTableJoinExample();
        yfTableJoinExample.or().andTableIdEqualTo(tableId);
        List<YfTableJoin> yfTableJoinList = yfTableJoinMapper.selectByExample(yfTableJoinExample);

        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        for(YfTableJoin yfTableJoin : yfTableJoinList){
            userInfoList.add(userDAO.getUserInfoById(yfTableJoin.getUserId()));
        }
        joinStatus.setJoinUserList(userInfoList);
        Integer joinNumber = userInfoList.size();
        joinStatus.setJoinNumber(joinNumber);
        String tableStatusTitle = String.format(FantuanConfig.DEFAULT_TABLE_STATUS_TITLE, tableSize, joinNumber);
        joinStatus.setTableStatusLabel(tableStatusTitle);
        if(joinNumber.equals((int)tableSize)){
            joinStatus.setTableIconType(TableIconType.FULL);
        }
        else{
            joinStatus.setTableIconType(TableIconType.NOT_FULL);
        }
        return joinStatus;
    }
}
