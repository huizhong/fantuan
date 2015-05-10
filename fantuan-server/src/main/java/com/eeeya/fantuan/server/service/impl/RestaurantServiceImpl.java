package com.eeeya.fantuan.server.service.impl;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.server.dao.RestaurantDAO;
import com.eeeya.fantuan.server.model.RestaurantFullInfo;
import com.eeeya.fantuan.server.param.RestaurantSelectParam;
import com.eeeya.fantuan.server.service.RestaurantService;
import com.eeeya.fantuan.server.service.TableService;
import com.eeeya.fantuan.server.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDAO restaurantDAO;

    @Autowired
    TableService tableService;

    @Override
    public TableInfo getNewRestaurant(RestaurantSelectParam restaurantSelectParam) {
        CoordinatePosition userCoordinatePosition = new CoordinatePosition();
        userCoordinatePosition.setLongitudeValue(restaurantSelectParam.getUserLongitude());
        userCoordinatePosition.setLatitudeValue(restaurantSelectParam.getUserLatitude());
        CoordinatePosition currentTableCoordinatePosition = tableService.getTableCoordinatePosition(restaurantSelectParam.getTableId());
        Double currentDistance = MathUtils.getDistance(userCoordinatePosition, currentTableCoordinatePosition);

        TableInfo tableInfo = getNewRestaurant(userCoordinatePosition, currentDistance,  restaurantSelectParam.getIsFarther());
        if(tableInfo != null){
            return tableInfo;
        }
        else{
            // todo 提示用户信息
            return tableService.getTableInfo(restaurantSelectParam.getTableId());
        }
    }


    @Override
    public TableInfo getNewRestaurant(Double userLatitude, Double userLongitude) {
        CoordinatePosition userCoordinatePosition = new CoordinatePosition();
        userCoordinatePosition.setLongitudeValue(userLongitude);
        userCoordinatePosition.setLatitudeValue(userLatitude);

        return getNewRestaurant(userCoordinatePosition, 0.0, true);
    }


    private TableInfo getNewRestaurant(CoordinatePosition userCoordinatePosition, Double currentDistance, Boolean isFarther) {
        RestaurantFullInfo restaurantFullInfo = findRestaurantByDistance(userCoordinatePosition, currentDistance, isFarther);
        if(restaurantFullInfo == null){
            return null;
        }
        return tableService.getRestaurantRecommendTable(restaurantFullInfo);
    }

    private RestaurantFullInfo findRestaurantByDistance(CoordinatePosition userCoordinatePosition, Double currentDistance, Boolean isFarther){
        List<RestaurantFullInfo> restaurantFullInfoList = restaurantDAO.getAllRestaurantInfo();
        Double minDistance = Double.MAX_VALUE;
        RestaurantFullInfo selectedRestaurantFullInfo = null;
        for(RestaurantFullInfo restaurantFullInfo : restaurantFullInfoList){
            Double restaurantDistance = MathUtils.getDistance(userCoordinatePosition, restaurantFullInfo.getCoordinatePosition());
            if( (isFarther && restaurantDistance > currentDistance && restaurantDistance < (currentDistance + minDistance))
                    || (!isFarther && restaurantDistance < currentDistance && restaurantDistance > (currentDistance - minDistance))
                    )
            {
                selectedRestaurantFullInfo = restaurantFullInfo;
                minDistance = Math.abs(restaurantDistance - currentDistance);
            }
        }
        return selectedRestaurantFullInfo;
    }

}
