package com.eeeya.fantuan.server.param;

/**
 * 餐厅切换参数
 * @author zhonghui
 * @since 5/8/15.
 */
public class RestaurantParam {
    Boolean isFarther;

    Double userLatitude;

    Double userLongitude;

    public RestaurantParam(Boolean isFarther, Double userLatitude, Double userLongitude) {
        this.isFarther = isFarther;
        this.userLatitude = userLatitude;
        this.userLongitude = userLongitude;
    }

    public RestaurantParam() {
    }

    public Boolean getIsFarther() {
        return isFarther;
    }

    public void setIsFarther(Boolean isFarther) {
        this.isFarther = isFarther;
    }

    public Double getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(Double userLatitude) {
        this.userLatitude = userLatitude;
    }

    public Double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(Double userLongitude) {
        this.userLongitude = userLongitude;
    }
}
