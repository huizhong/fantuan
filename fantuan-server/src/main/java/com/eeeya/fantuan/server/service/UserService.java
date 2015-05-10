package com.eeeya.fantuan.server.service;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.UserLoginModel;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public interface UserService {
    CoordinatePosition getUserCoordinatePosition(Long userId);

    UserLoginModel getUserLoginModelByPassword(String userPhone, String password);

    boolean isRightToken(Long userId, String token);
}
