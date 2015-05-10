package com.eeeya.fantuan.server.service.impl;

import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.UserLoginModel;
import com.eeeya.fantuan.server.dao.UserDAO;
import com.eeeya.fantuan.server.model.UserLoginAuthModel;
import com.eeeya.fantuan.server.service.UserService;
import com.eeeya.fantuan.server.utils.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public CoordinatePosition getUserCoordinatePosition(Long userId) {
        return userDAO.getUserCoordinatePositionByUserId(userId);
    }

    @Override
    public UserLoginModel getUserLoginModelByPassword(String userPhone, String password){
        String encodePassword = MathUtils.md5(password);
        return userDAO.getUserLoginModelByPhoneAndPassword(userPhone, encodePassword);
        // $params['token'] = md5(time() . $params['telphone'] .rand(1,99));   //生成TOKEN
    }

    @Override
    public boolean isRightToken(Long userId, String token){
        return userDAO.isRightToken(userId, token);
    }

    @Override
    public UserDetails loadUserByUsername(String userPhone) throws UsernameNotFoundException {
        UserLoginAuthModel userLoginAuthModel = userDAO.getUserLoginAuthModelByPhone(userPhone);
        return new CurrentUser(userLoginAuthModel);
    }

    public class CurrentUser extends org.springframework.security.core.userdetails.User {
        UserLoginModel userLoginAuthModel;

        public CurrentUser(UserLoginAuthModel userLoginModel) {
            super(userLoginModel.getUserPhone(), userLoginModel.getEncodedPassword(), AuthorityUtils.createAuthorityList("USER"));
            this.userLoginAuthModel =  userLoginModel;
        }

        public UserLoginModel getUserLoginAuthModel() {
            return userLoginAuthModel;
        }

        public void setUserLoginAuthModel(UserLoginAuthModel userLoginAuthModel) {
            this.userLoginAuthModel = userLoginAuthModel;
        }
    }
}
