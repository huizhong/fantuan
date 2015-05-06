package com.eeeya.fantuan.model;

import com.eeeya.fantuan.config.FantuanConfig;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class CoordinatePosition {
    Double latitudeValue;
    Double longitudeValue;

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
