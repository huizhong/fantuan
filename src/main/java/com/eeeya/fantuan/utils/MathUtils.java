/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.eeeya.fantuan.utils;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;

import java.math.BigDecimal;

public class MathUtils {

    public static double round(double value, int scale) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }

    private static final double EARTH_RADIUS = 6371004;//地球半径,单位米

    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点的经纬度计算两点之间的距离，单位是米
     *
     * */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    public static Double getDistance(CoordinatePosition coordinatePosition, CoordinatePosition nextCoordinatePosition) {
        return getDistance(
                coordinatePosition.getLatitudeValue(),
                coordinatePosition.getLongitudeValue(),
                nextCoordinatePosition.getLatitudeValue(),
                nextCoordinatePosition.getLongitudeValue()
        );
    }

}
