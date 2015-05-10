package com.eeeya.fantuan.server.utils;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.RestaurantMetaInfo;
import com.eeeya.fantuan.server.api.v1.model.table.TableMetaInfo;
import com.eeeya.fantuan.server.contants.MealType;
import com.eeeya.fantuan.server.contants.PayType;
import com.eeeya.fantuan.server.contants.TableType;
import com.eeeya.fantuan.server.domain.YfRestaurant;
import com.eeeya.fantuan.server.domain.YfTable;
import com.eeeya.fantuan.server.domain.YfUser;
import com.eeeya.fantuan.server.model.UserLoginAuthModel;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public class DomainUtils {
    public static void loadRestaurantDomain(RestaurantMetaInfo restaurantMetaInfo, YfRestaurant yfRestaurant) {
        restaurantMetaInfo.setRestaurantId(yfRestaurant.getId());

        restaurantMetaInfo.setShortName(yfRestaurant.getShortName());
        restaurantMetaInfo.setFullName(yfRestaurant.getFullName());
        restaurantMetaInfo.setMaxTable(yfRestaurant.getMaxTable());
        restaurantMetaInfo.setRestaurantPhone(yfRestaurant.getRestaurantPhone());
        restaurantMetaInfo.setRestaurantAddress(yfRestaurant.getRestaurantAddress());

        CoordinatePosition coordinatePosition = new CoordinatePosition();
        coordinatePosition.setLatitudeValue(yfRestaurant.getRestaurantLatitude());
        coordinatePosition.setLongitudeValue(yfRestaurant.getRestaurantLongitude());
        restaurantMetaInfo.setCoordinatePosition(coordinatePosition);
    }

    public static void loadTableDomain(TableMetaInfo tableMetaInfo, YfTable yfTable) {
        tableMetaInfo.setTableId(yfTable.getId());
        tableMetaInfo.setTableType(TableType.load(yfTable.getTableType()));
        tableMetaInfo.setMealTime(yfTable.getMealTime().getTime());
        tableMetaInfo.setMealType(MealType.load(yfTable.getMealType()));
        tableMetaInfo.setPayType(PayType.load(yfTable.getPayType()));
        tableMetaInfo.setRestaurantId(yfTable.getRestaurantId());
        tableMetaInfo.setTalkGroupId(yfTable.getTalkGroupId());
    }

    public static void loadUserLoginAuthModel(UserLoginAuthModel userLoginModel, YfUser yfUser) {
        userLoginModel.setUserId(yfUser.getId());
        userLoginModel.setUserToken(yfUser.getToken());
        userLoginModel.setUserName(yfUser.getName());
        userLoginModel.setEncodedPassword(yfUser.getPassword());
        userLoginModel.setUserPhone(yfUser.getTelphone());
    }
}
