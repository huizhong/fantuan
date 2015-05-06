package com.eeeya.fantuan.model;

import com.eeeya.fantuan.api.ListDataModel;
import com.eeeya.fantuan.config.FantuanConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class RestaurantInfo {
    Long restaurantId;
    String shortName;
    String fullName;
    Integer maxTable;
    String restaurantPhone;
    String restaurantLocation;
    CoordinatePosition coordinatePosition;
    List<FoodItem> foodMenu;

    public RestaurantInfo() {
        this.restaurantId = FantuanConfig.DEFAULT_RESTAURANT_ID;
        this.shortName = FantuanConfig.DEFAULT_RESTAURANT_SHORT_NAME;
        this.fullName = FantuanConfig.DEFAULT_RESTAURANT_FULL_NAME;
        this.maxTable = FantuanConfig.DEFAULT_RESTAURANT_MAX_TABLE;
        this.restaurantPhone = FantuanConfig.DEFAULT_RESTAURANT_PHONE;
        this.restaurantLocation = FantuanConfig.DEFAULT_RESTAURANT_LOCATION;
        this.coordinatePosition = new CoordinatePosition();
        this.foodMenu = new ArrayList<FoodItem>();

        // todo 真实数据时去掉
        foodMenu.add(new FoodItem(1L, "鹅肝", 30));
        foodMenu.add(new FoodItem(2L, "烤鱼", 40));
        foodMenu.add(new FoodItem(3L, "土豆沙拉", 35));
        foodMenu.add(new FoodItem(4L, "牛排", 20));
        foodMenu.add(new FoodItem(5L, "蟹子手券", 40));
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public CoordinatePosition getCoordinatePosition() {
        return coordinatePosition;
    }

    public void setCoordinatePosition(CoordinatePosition coordinatePosition) {
        this.coordinatePosition = coordinatePosition;
    }
}
