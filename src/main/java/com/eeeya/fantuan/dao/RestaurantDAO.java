package com.eeeya.fantuan.dao;

import com.eeeya.fantuan.model.RestaurantFullInfo;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public interface RestaurantDAO {
    List<RestaurantFullInfo> getAllRestaurantInfo();
}
