package com.eeeya.fantuan.server.api.v1.model;

/**
 * @author zhonghui
 * @since 5/10/15.
 */
public class UserLoginModel {
    Long userId;
    String userToken;
    String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
