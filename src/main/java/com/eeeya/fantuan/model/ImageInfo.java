package com.eeeya.fantuan.model;

import com.eeeya.fantuan.config.FantuanConfig;
import com.eeeya.fantuan.contants.ImageType;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class ImageInfo {
    ImageType imageType;
    String imageUrl;

    public ImageInfo(ImageType imageType, String imageUrl) {
        this.imageType = imageType;
        this.imageUrl = imageUrl;
    }

    public ImageInfo() {
        this(FantuanConfig.DEFAULT_IMAGE_TYPE, FantuanConfig.DEFAULT_IMG_URL);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }
}
