package com.eeeya.fantuan.server.dao;

import com.eeeya.fantuan.server.api.v1.model.RestaurantMetaInfo;
import com.eeeya.fantuan.server.model.RestaurantFullInfo;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public interface RestaurantDAO {
    List<RestaurantFullInfo> getAllRestaurantInfo();

    RestaurantMetaInfo getRestaurantMetaInfo(Long restaurantId);

    RestaurantFullInfo getRestaurantFullInfo(Long restaurantId);
}
