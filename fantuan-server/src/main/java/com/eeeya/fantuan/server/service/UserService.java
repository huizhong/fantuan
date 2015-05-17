package com.eeeya.fantuan.server.service;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.eeeya.fantuan.api.v1.model.UserLoginModel;
import com.eeeya.fantuan.common.exception.ApiException;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public interface UserService {
    CoordinatePosition getUserCoordinatePosition(Long userId);

    UserLoginModel getUserLoginModelByPassword(String userPhone, String password) throws ApiException;

    void checkPermission(Long userId, String token) throws ApiException;

    List<UserLoginModel> getAllUserLoginModel();

    UserInfo getUserInfo(Long userId);
}
