package com.eeeya.fantuan.server.dao;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.eeeya.fantuan.api.v1.model.UserLoginModel;
import com.eeeya.fantuan.server.model.UserLoginAuthModel;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public interface UserDAO {
    UserInfo getUserInfoById(Long userId);

    CoordinatePosition getUserCoordinatePositionByUserId(Long userId);

    UserLoginModel getUserLoginModelByPhoneAndPassword(String userPhone, String encodePassword);

    Boolean isRightToken(Long userId, String token);

    UserLoginAuthModel getUserLoginAuthModelByPhone(String userPhone);
}
