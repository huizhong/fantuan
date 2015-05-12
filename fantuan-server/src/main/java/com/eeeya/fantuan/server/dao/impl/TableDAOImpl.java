package com.eeeya.fantuan.server.dao.impl;

import com.eeeya.fantuan.api.v1.contants.ImageType;
import com.eeeya.fantuan.api.v1.contants.TableIconType;
import com.eeeya.fantuan.api.v1.model.*;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.api.v1.model.table.TableStatus;
import com.eeeya.fantuan.api.v1.model.table.status.*;
import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.common.model.ApiError;
import com.eeeya.fantuan.server.config.FantuanServerConfig;
import com.eeeya.fantuan.server.dao.RestaurantDAO;
import com.eeeya.fantuan.server.dao.TableDAO;
import com.eeeya.fantuan.server.dao.UserDAO;
import com.eeeya.fantuan.server.domain.*;
import com.eeeya.fantuan.server.mapper.YfTableJoinMapper;
import com.eeeya.fantuan.server.mapper.YfTableMapper;
import com.eeeya.fantuan.server.mapper.YfTableStartMapper;
import com.eeeya.fantuan.server.mapper.YfTableVoteMapper;
import com.eeeya.fantuan.server.model.RestaurantFullInfo;
import com.eeeya.fantuan.server.utils.DomainUtils;
import com.eeeya.fantuan.server.utils.FoodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
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
    YfTableVoteMapper yfTableVoteMapper;

    @Autowired
    YfTableStartMapper yfTableStartMapper;

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

    @NotNull
    @Override
    public Long insertTable(RestaurantMetaInfo restaurantMetaInfo, String talkGroupId) throws ApiException {
        YfTable yfTable = new YfTable();
        yfTable.setMealType(FantuanServerConfig.DEFAULT_MEAL_TYPE.getValue());
        yfTable.setTableType(FantuanServerConfig.DEFAULT_TABLE_TYPE.getValue());
        yfTable.setPayType(FantuanServerConfig.DEFAULT_PAY_TYPE.getValue());
        yfTable.setRestaurantId(restaurantMetaInfo.getRestaurantId());
        yfTable.setTalkGroupId(talkGroupId);
        if( 1 == yfTableMapper.insertSelective(yfTable)){
            return yfTable.getId();
        }
        else{
            throw new ApiException(ApiError.DATABASE_INSERT_FAILED);
        }
    }


    @NotNull
    @Override
    public Long insertJoinStatus(Long tableId, Long userId) throws ApiException {
        YfTableJoin yfTableJoin = new YfTableJoin();
        yfTableJoin.setTableId(tableId);
        yfTableJoin.setUserId(userId);
        try {
            Integer affectNumber = yfTableJoinMapper.insertSelective(yfTableJoin);
            if(affectNumber == 1){
                return yfTableJoin.getId();
            }
        }catch (DuplicateKeyException e){
            throw new ApiException(ApiError.DATABASE_DUPLICATE_KEY, "插入用户参加状态失败", e);
        }
        throw new ApiException(ApiError.DATABASE_INSERT_FAILED);
    }


    @NotNull
    @Override
    public Long insertStartStatus(Long tableId, Long userId) throws ApiException {
        YfTableStart yfTableStart = new YfTableStart();
        yfTableStart.setTableId(tableId);
        yfTableStart.setUserId(userId);
        try {
            Integer affectNumber = yfTableStartMapper.insertSelective(yfTableStart);
            if(affectNumber == 1){
                return yfTableStart.getId();
            }
        }catch (DuplicateKeyException e){
            throw new ApiException(ApiError.DATABASE_DUPLICATE_KEY, "插入用户出发状态失败", e);
        }
        throw new ApiException(ApiError.DATABASE_INSERT_FAILED);
    }

    @Override
    public Long insertVoteStatus(Long tableId, Long userId, Long foodItemId) throws ApiException {
        YfTableVote yfTableVote = new YfTableVote();
        yfTableVote.setTableId(tableId);
        yfTableVote.setUserId(userId);
        yfTableVote.setFoodId(foodItemId);
        try {
            Integer affectNumber = yfTableVoteMapper.insertSelective(yfTableVote);
            if(affectNumber == 1){
                return yfTableVote.getId();
            }
        }catch (DuplicateKeyException e){
            throw new ApiException(ApiError.DATABASE_DUPLICATE_KEY, "插入用户投票状态失败", e);
        }
        throw new ApiException(ApiError.DATABASE_INSERT_FAILED);
    }

    @Override
    public void removeUserJoinStatus(Long joinId) throws ApiException {
        Integer affectNumber = yfTableMapper.deleteByPrimaryKey(joinId);
        if(affectNumber != 1){
            throw new ApiException(ApiError.DATABASE_REMOVE_FAILED, "删除加入状态失败, 表：join_status, key: " + joinId);
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
        priceInfo.setPriceUnit(FantuanServerConfig.TABLE_AVERAGE_PRICE_UNIT);
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

        TableStatus tableStatus = new TableStatus();
        tableStatus.setJoinStatus(getTableJoinStatus(tableId, tableSize));
        tableStatus.setMealVoteStatus(getMealVoteStatus(tableId));
        tableStatus.setMealStartStatus(getMealStartStatus(tableId));

        // todo
        tableStatus.setMessageStatus(new TableMessageStatus());
        return tableStatus;
    }

    private MealStartStatus getMealStartStatus(Long tableId) {
        MealStartStatus mealStartStatus = new MealStartStatus();
        YfTableStartExample yfTableStartExample = new YfTableStartExample();
        yfTableStartExample.or().andTableIdEqualTo(tableId);
        List<YfTableStart> yfTableStartList = yfTableStartMapper.selectByExample(yfTableStartExample);
        List<MealStartItem> mealStartItemList = new ArrayList<MealStartItem>();
        Long lastStartTime = FantuanServerConfig.DEFAULT_LAST_UPDATE_TIME;
        for(YfTableStart yfTableStart : yfTableStartList){
            MealStartItem mealStartItem = new MealStartItem();
            mealStartItem.setUserInfo(userDAO.getUserInfoById(yfTableStart.getUserId()));
            Long startTime = yfTableStart.getStartTime().getTime();
            mealStartItem.setStartTime(startTime);
            if(startTime>lastStartTime){
                lastStartTime = startTime;
            }
            mealStartItemList.add(mealStartItem);
        }
        mealStartStatus.setMealStartItemList(mealStartItemList);
        mealStartStatus.setUpdateTime(lastStartTime);
        return mealStartStatus;
    }

    private MealVoteStatus getMealVoteStatus(Long tableId) {
        MealVoteStatus mealVoteStatus = new MealVoteStatus();
        YfTableVoteExample yfTableVoteExample = new YfTableVoteExample();
        yfTableVoteExample.or().andTableIdEqualTo(tableId);
        List<YfTableVote> yfTableVoteList = yfTableVoteMapper.selectByExample(yfTableVoteExample);
        List<MealVoteItem> mealVoteItemList = new ArrayList<MealVoteItem>();
        Long lastVoteTime = FantuanServerConfig.DEFAULT_LAST_UPDATE_TIME;
        for(YfTableVote yfTableVote : yfTableVoteList){
            MealVoteItem mealVoteItem = new MealVoteItem();
            mealVoteItem.setUserInfo(userDAO.getUserInfoById(yfTableVote.getUserId()));
            mealVoteItem.setFoodItem(restaurantDAO.getFoodItem(yfTableVote.getFoodId()));
            Long voteTime = yfTableVote.getVoteTime().getTime();
            mealVoteItem.setVoteTime(voteTime);
            if(voteTime>lastVoteTime){
                lastVoteTime = voteTime;
            }
            mealVoteItemList.add(mealVoteItem);
        }
        mealVoteStatus.setMealVoteItemList(mealVoteItemList);
        mealVoteStatus.setUpdateTime(lastVoteTime);
        return mealVoteStatus;
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
        String tableStatusTitle = String.format(FantuanServerConfig.DEFAULT_TABLE_STATUS_TITLE, tableSize, joinNumber);
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
