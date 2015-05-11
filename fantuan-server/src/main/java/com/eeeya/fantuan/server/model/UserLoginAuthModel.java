package com.eeeya.fantuan.server.model;

import com.eeeya.fantuan.api.v1.model.UserLoginModel;

/**
 * @author zhonghui
 * @since 5/10/15.
 */
public class UserLoginAuthModel extends UserLoginModel {
    String encodedPassword;
    String userPhone;

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
