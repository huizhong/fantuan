package com.eeeya.fantuan.model;

import com.eeeya.fantuan.config.FantuanConfig;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("经纬度")
public class CoordinatePosition {

    @ApiModelProperty("经度")
    Double longitudeValue;

    @ApiModelProperty("纬度")
    Double latitudeValue;

    public CoordinatePosition() {
        this.latitudeValue = FantuanConfig.DEFAULT_COORDINATE_POSITION_LATITUDE_VALUE;
        this.longitudeValue = FantuanConfig.DEFAULT_COORDINATE_POSITION_LONGITUDE_VALUE;
    }

    public Double getLatitudeValue() {
        return latitudeValue;
    }

    public void setLatitudeValue(Double latitudeValue) {
        this.latitudeValue = latitudeValue;
    }

    public Double getLongitudeValue() {
        return longitudeValue;
    }

    public void setLongitudeValue(Double longitudeValue) {
        this.longitudeValue = longitudeValue;
    }
}
