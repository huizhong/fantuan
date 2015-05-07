package com.eeeya.fantuan.model;

import com.eeeya.fantuan.config.FantuanConfig;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐厅信息")
public class RestaurantInfo {

    @ApiModelProperty("餐厅唯一ID")
    Long restaurantId;

    @ApiModelProperty("短名称，比如'金百万'")
    String shortName;

    @ApiModelProperty("全名称，比如'金百万（望京店）'")
    String fullName;

    @ApiModelProperty("最大饭桌数")
    Integer maxTable;

    @ApiModelProperty("餐厅电话")
    String restaurantPhone;

    @ApiModelProperty("餐厅地址")
    String restaurantAddress;

    @ApiModelProperty("餐厅经纬度")
    CoordinatePosition coordinatePosition;

    @ApiModelProperty("菜品列表")
    List<FoodItem> foodItemList;

    public RestaurantInfo() {
        this.restaurantId = FantuanConfig.DEFAULT_RESTAURANT_ID;
        this.shortName = FantuanConfig.DEFAULT_RESTAURANT_SHORT_NAME;
        this.fullName = FantuanConfig.DEFAULT_RESTAURANT_FULL_NAME;
        this.maxTable = FantuanConfig.DEFAULT_RESTAURANT_MAX_TABLE;
        this.restaurantPhone = FantuanConfig.DEFAULT_RESTAURANT_PHONE;
        this.restaurantAddress = FantuanConfig.DEFAULT_RESTAURANT_LOCATION;
        this.coordinatePosition = new CoordinatePosition();
        this.foodItemList = new ArrayList<FoodItem>();

        // todo 真实数据时去掉
        foodItemList.add(new FoodItem(1L, "鹅肝", 30));
        foodItemList.add(new FoodItem(2L, "烤鱼", 40));
        foodItemList.add(new FoodItem(3L, "土豆沙拉", 35));
        foodItemList.add(new FoodItem(4L, "牛排", 20));
        foodItemList.add(new FoodItem(5L, "蟹子手券", 40));
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
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

    public Integer getMaxTable() {
        return maxTable;
    }

    public void setMaxTable(Integer maxTable) {
        this.maxTable = maxTable;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }
}
