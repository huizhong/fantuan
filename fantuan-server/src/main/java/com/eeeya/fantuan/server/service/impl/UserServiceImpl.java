package com.eeeya.fantuan.server.service.impl;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.eeeya.fantuan.api.v1.model.UserLoginModel;
import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.common.model.ApiError;
import com.eeeya.fantuan.server.dao.UserDAO;
import com.eeeya.fantuan.server.service.UserService;
import com.eeeya.fantuan.server.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public CoordinatePosition getUserCoordinatePosition(Long userId) {
        return userDAO.getUserCoordinatePositionByUserId(userId);
    }

    @Override
    public UserLoginModel getUserLoginModelByPassword(String userPhone, String password) throws ApiException {
        String encodePassword = MathUtils.md5(password);
        return userDAO.getUserLoginModelByPhoneAndPassword(userPhone, encodePassword);
        // $params['token'] = md5(time() . $params['telphone'] .rand(1,99));   //生成TOKEN
    }

    @Override
    public void checkPermission(Long userId, String token) throws ApiException {
        Boolean isRightToken = userDAO.isRightToken(userId, token);
        if(!isRightToken){
            throw new ApiException(ApiError.AUTHENTICATE_FAIL);
        }
    }

    @Override
    public List<UserLoginModel> getAllUserLoginModel() {
        return userDAO.getAllUserLoginModel();
    }

    @Override
    public UserInfo getUserInfo(Long userId) {
        return userDAO.getUserInfoById(userId);
    }

}
