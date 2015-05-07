package com.eeeya.fantuan.param;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
@ApiModel("餐厅切换参数")
public class RestaurantChangeParam {
    @ApiModelProperty("切换到更远")
    Boolean isFarther;

    @ApiModelProperty("用户位置经度")
    Double userLatitude;

    @ApiModelProperty("用户位置纬度")
    Double userLongitude;

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
