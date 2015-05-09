package com.eeeya.fantuan.service;

import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.param.RestaurantSelectParam;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public interface RestaurantService {
    TableInfo getNewRestaurant(RestaurantSelectParam restaurantSelectParam);
}
