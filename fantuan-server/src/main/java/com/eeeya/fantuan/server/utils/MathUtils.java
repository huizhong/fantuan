/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.eeeya.fantuan.server.utils;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public static String md5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);

        for (byte b : hash) {
            int i = (b & 0xFF);
            if (i < 0x10) hex.append('0');
            hex.append(Integer.toHexString(i));
        }

        return hex.toString();
    }

}
