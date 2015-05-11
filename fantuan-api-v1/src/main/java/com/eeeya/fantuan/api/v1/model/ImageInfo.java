package com.eeeya.fantuan.api.v1.model;

import com.eeeya.fantuan.api.v1.contants.ImageType;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("图片信息")
public class ImageInfo {

    @ApiModelProperty("图片类型，例如：用户Logo")
    ImageType imageType;

    @ApiModelProperty("图片URL")
    String imageUrl;

    public ImageInfo() {
    }

    public ImageInfo(ImageType imageType, String imageUrl) {
        this.imageType = imageType;
        this.imageUrl = imageUrl;
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
