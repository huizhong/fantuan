package com.eeeya.fantuan.server.dao;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.UserInfo;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public interface UserDAO {
    UserInfo getUserInfoById(Long userId);

    CoordinatePosition getUserCoordinatePositionByUserId(Long userId);
}
