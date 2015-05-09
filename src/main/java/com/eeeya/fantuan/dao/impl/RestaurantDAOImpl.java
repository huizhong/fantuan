package com.eeeya.fantuan.dao.impl;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.FoodItem;
import com.eeeya.fantuan.api.v1.model.ImageInfo;
import com.eeeya.fantuan.contants.ImageType;
import com.eeeya.fantuan.dao.RestaurantDAO;
import com.eeeya.fantuan.domain.*;
import com.eeeya.fantuan.mapper.YfRestaurantFoodMapper;
import com.eeeya.fantuan.mapper.YfRestaurantImageMapper;
import com.eeeya.fantuan.mapper.YfRestaurantMapper;
import com.eeeya.fantuan.model.RestaurantFullInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {
    @Autowired
    YfRestaurantMapper yfRestaurantMapper;

    @Autowired
    YfRestaurantImageMapper yfRestaurantImageMapper;

    @Autowired
    YfRestaurantFoodMapper yfRestaurantFoodMapper;

    @Override
    public List<RestaurantFullInfo> getAllRestaurantInfo() {
        List<YfRestaurant> yfRestaurantList = yfRestaurantMapper.selectByExample(new YfRestaurantExample());

        HashMap<Long, ImageInfo> yfRestaurantImageHashMap = new HashMap<Long, ImageInfo>(yfRestaurantList.size());
        List<YfRestaurantImage> yfRestaurantImageList = yfRestaurantImageMapper.selectByExample(new YfRestaurantImageExample());
        for(YfRestaurantImage yfRestaurantImage : yfRestaurantImageList){
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setImageType(ImageType.RESTAURANT_LOGO);
            imageInfo.setImageUrl(yfRestaurantImage.getUrl());
            yfRestaurantImageHashMap.put(yfRestaurantImage.getRestaurantId(), imageInfo);
        }

        HashMap<Long, List<FoodItem>> yfRestaurantFoodHashMap = new HashMap<Long, List<FoodItem>>(yfRestaurantList.size());
        List<YfRestaurantFood> allYfRestaurantFoodList = yfRestaurantFoodMapper.selectByExample(new YfRestaurantFoodExample());
        for(YfRestaurantFood yfRestaurantFood: allYfRestaurantFoodList){
            List<FoodItem> yfRestaurantFoodList = yfRestaurantFoodHashMap.get(yfRestaurantFood.getRestaurantId());
            if(yfRestaurantFoodList == null){
                yfRestaurantFoodList = new ArrayList<FoodItem>();
                yfRestaurantFoodHashMap.put(yfRestaurantFood.getRestaurantId(), yfRestaurantFoodList);
            }
            FoodItem foodItem = new FoodItem();
            foodItem.setFoodId(yfRestaurantFood.getId());
            foodItem.setFoodName(yfRestaurantFood.getFoodName());
            foodItem.setFoodPrice(yfRestaurantFood.getFoodPrice());
            yfRestaurantFoodList.add(foodItem);
        }

        List<RestaurantFullInfo> restaurantFullInfoList = new ArrayList<RestaurantFullInfo>();
        for(YfRestaurant yfRestaurant : yfRestaurantList){
            RestaurantFullInfo restaurantFullInfo = new RestaurantFullInfo();

            restaurantFullInfo.setRestaurantId(yfRestaurant.getId());

            restaurantFullInfo.setShortName(yfRestaurant.getShortName());
            restaurantFullInfo.setFullName(yfRestaurant.getFullName());
            restaurantFullInfo.setMaxTable(yfRestaurant.getMaxTable());
            restaurantFullInfo.setRestaurantPhone(yfRestaurant.getRestaurantPhone());
            restaurantFullInfo.setRestaurantAddress(yfRestaurant.getRestaurantAddress());

            CoordinatePosition coordinatePosition = new CoordinatePosition();
            coordinatePosition.setLatitudeValue(yfRestaurant.getRestaurantLatitude());
            coordinatePosition.setLongitudeValue(yfRestaurant.getRestaurantLongitude());
            restaurantFullInfo.setCoordinatePosition(coordinatePosition);

            restaurantFullInfo.setFoodItemList(yfRestaurantFoodHashMap.get(yfRestaurant.getId()));

            restaurantFullInfo.setRestaurantImage(yfRestaurantImageHashMap.get(yfRestaurant.getId()));
            restaurantFullInfoList.add(restaurantFullInfo);
        }

        return restaurantFullInfoList;
    }
}
