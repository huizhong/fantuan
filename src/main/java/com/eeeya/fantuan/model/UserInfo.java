package com.eeeya.fantuan.model;

import com.eeeya.fantuan.contants.ImageType;
import com.eeeya.fantuan.contants.TableIconType;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("用户简要信息")
public class UserInfo {

    @ApiModelProperty("用户Id")
    Integer userId;

    @ApiModelProperty("用户名")
    String userName;

    @ApiModelProperty("用于展示在桌面上的圆头像")
    ImageInfo userLogo;

    public UserInfo(int userId) {
        setUserId(userId);
        // todo 替换成真实头像
        ImageInfo imageInfo = new ImageInfo(ImageType.USER_LOGO, "http://t.meituan.com/qrc/s?c=" + userId);
        // todo 替换成真实姓名
        setUserName("用户" + userId);

        setUserLogo(imageInfo);

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
}
