package com.eeeya.fantuan.api.v1.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("用户简要信息")
public class UserInfo {

    @ApiModelProperty("用户Id")
    Long userId;

    @ApiModelProperty("用户名")
    String userName;

    @ApiModelProperty("用于展示在桌面上的圆头像")
    ImageInfo userLogo;

    @ApiModelProperty("手机号")
    String userPhone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ImageInfo getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(ImageInfo userLogo) {
        this.userLogo = userLogo;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
