package com.eeeya.fantuan.server.service.impl;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.dao.UserDAO;
import com.eeeya.fantuan.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public CoordinatePosition getUserCoordinatePosition(Long userId) {
        return userDAO.getUserCoordinatePositionByUserId(userId);
    }
}
