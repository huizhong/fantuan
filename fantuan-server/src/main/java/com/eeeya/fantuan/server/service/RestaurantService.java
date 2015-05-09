package com.eeeya.fantuan.server.service;

import com.eeeya.fantuan.server.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.server.param.RestaurantSelectParam;

import javax.annotation.Nullable;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public interface RestaurantService {

    @Nullable
    TableInfo getNewRestaurant(RestaurantSelectParam restaurantSelectParam);

    TableInfo getNewRestaurant(Double userLatitude, Double userLongitude);
}
