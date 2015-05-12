package com.eeeya.fantuan.server.service;

import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.server.param.RestaurantSelectParam;

import javax.annotation.Nullable;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public interface RestaurantService {

    @Nullable
    TableInfo getNewRestaurant(RestaurantSelectParam restaurantSelectParam) throws ApiException;

    TableInfo getNewRestaurant(Double userLatitude, Double userLongitude) throws ApiException;
}
