package com.eeeya.fantuan.server.api.v1.model;

import com.eeeya.fantuan.server.config.FantuanConfig;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐厅元信息，不包含菜品")
public class RestaurantMetaInfo {

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

    public RestaurantMetaInfo() {
        this.restaurantId = FantuanConfig.DEFAULT_RESTAURANT_ID;
        this.shortName = FantuanConfig.DEFAULT_RESTAURANT_SHORT_NAME;
        this.fullName = FantuanConfig.DEFAULT_RESTAURANT_FULL_NAME;
        this.maxTable = FantuanConfig.DEFAULT_RESTAURANT_MAX_TABLE;
        this.restaurantPhone = FantuanConfig.DEFAULT_RESTAURANT_PHONE;
        this.restaurantAddress = FantuanConfig.DEFAULT_RESTAURANT_LOCATION;
        this.coordinatePosition = new CoordinatePosition();
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

}
