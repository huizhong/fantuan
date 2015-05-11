package com.eeeya.fantuan.server.model;

import com.eeeya.fantuan.api.v1.model.ImageInfo;
import com.eeeya.fantuan.api.v1.model.RestaurantInfo;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public class RestaurantFullInfo extends RestaurantInfo {
    ImageInfo restaurantImage;

    public ImageInfo getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(ImageInfo restaurantImage) {
        this.restaurantImage = restaurantImage;
    }
}
