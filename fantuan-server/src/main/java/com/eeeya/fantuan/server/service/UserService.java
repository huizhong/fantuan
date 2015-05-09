package com.eeeya.fantuan.server.service;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
public interface UserService {
    CoordinatePosition getUserCoordinatePosition(Long userId);
}
