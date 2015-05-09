package com.eeeya.fantuan.server.dao.impl;

import com.eeeya.fantuan.server.api.v1.model.FoodItem;
import com.eeeya.fantuan.server.api.v1.model.ImageInfo;
import com.eeeya.fantuan.server.api.v1.model.RestaurantMetaInfo;
import com.eeeya.fantuan.server.contants.ImageType;
import com.eeeya.fantuan.server.dao.RestaurantDAO;
import com.eeeya.fantuan.server.domain.*;
import com.eeeya.fantuan.server.mapper.YfRestaurantFoodMapper;
import com.eeeya.fantuan.server.mapper.YfRestaurantImageMapper;
import com.eeeya.fantuan.server.mapper.YfRestaurantMapper;
import com.eeeya.fantuan.server.model.RestaurantFullInfo;
import com.eeeya.fantuan.server.utils.DomainUtils;
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

            DomainUtils.loadRestaurantDomain(restaurantFullInfo, yfRestaurant);

            restaurantFullInfo.setFoodItemList(yfRestaurantFoodHashMap.get(yfRestaurant.getId()));

            restaurantFullInfo.setRestaurantImage(yfRestaurantImageHashMap.get(yfRestaurant.getId()));
            restaurantFullInfoList.add(restaurantFullInfo);
        }

        return restaurantFullInfoList;
    }

    @Override
    public RestaurantMetaInfo getRestaurantMetaInfo(Long restaurantId) {
        YfRestaurant yfRestaurant = yfRestaurantMapper.selectByPrimaryKey(restaurantId);
        RestaurantMetaInfo restaurantMetaInfo = new RestaurantMetaInfo();
        DomainUtils.loadRestaurantDomain(restaurantMetaInfo, yfRestaurant);
        return restaurantMetaInfo;

    }

    @Override
    public RestaurantFullInfo getRestaurantFullInfo(Long restaurantId) {
        YfRestaurant yfRestaurant = yfRestaurantMapper.selectByPrimaryKey(restaurantId);
        RestaurantFullInfo restaurantFullInfo = new RestaurantFullInfo();
        DomainUtils.loadRestaurantDomain(restaurantFullInfo, yfRestaurant);
        restaurantFullInfo.setRestaurantImage(getRestaurantImageInfo(yfRestaurant.getId()));
        restaurantFullInfo.setFoodItemList(getRestaurantFoodItemList(yfRestaurant.getId()));
        return restaurantFullInfo;
    }

    private List<FoodItem> getRestaurantFoodItemList(Long restaurantId) {
        YfRestaurantFoodExample yfRestaurantFoodExample = new YfRestaurantFoodExample();
        yfRestaurantFoodExample.or().andRestaurantIdEqualTo(restaurantId);
        List<YfRestaurantFood> yfRestaurantFoodList = yfRestaurantFoodMapper.selectByExample(yfRestaurantFoodExample);
        List<FoodItem> foodItemList = new ArrayList<FoodItem>();
        for(YfRestaurantFood yfRestaurantFood : yfRestaurantFoodList){
            FoodItem foodItem = new FoodItem();
            foodItem.setFoodId(yfRestaurantFood.getId());
            foodItem.setFoodPrice(yfRestaurantFood.getFoodPrice());
            foodItem.setFoodName(yfRestaurantFood.getFoodName());
            foodItemList.add(foodItem);
        }
        return foodItemList;
    }

    private ImageInfo getRestaurantImageInfo(Long restaurantId) {
        YfRestaurantImageExample yfRestaurantImageExample = new YfRestaurantImageExample();
        yfRestaurantImageExample.or().andRestaurantIdEqualTo(restaurantId);
        yfRestaurantImageExample.setOrderByClause("id desc");
        yfRestaurantImageExample.setRows(1);
        yfRestaurantImageExample.setOffset(0);
        List<YfRestaurantImage> yfRestaurantImageList = yfRestaurantImageMapper.selectByExample(yfRestaurantImageExample);
        if(!yfRestaurantImageList.isEmpty()){
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setImageType(ImageType.RESTAURANT_LOGO);
            imageInfo.setImageUrl(yfRestaurantImageList.get(0).getUrl());
            return imageInfo;
        }
        return null;
    }
}
