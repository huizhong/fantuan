package com.eeeya.fantuan.service.impl;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.dao.RestaurantDAO;
import com.eeeya.fantuan.model.RestaurantFullInfo;
import com.eeeya.fantuan.param.RestaurantSelectParam;
import com.eeeya.fantuan.service.RestaurantService;
import com.eeeya.fantuan.service.TableService;
import com.eeeya.fantuan.utils.MathUtils;
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
        RestaurantFullInfo restaurantFullInfo = findRestaurantByDistance(userCoordinatePosition, currentDistance, restaurantSelectParam.getIsFarther());
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
