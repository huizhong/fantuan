package com.eeeya.fantuan.api.v1.model;

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
    }

    public CoordinatePosition(Double longitudeValue, Double latitudeValue) {
        this.longitudeValue = longitudeValue;
        this.latitudeValue = latitudeValue;
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
