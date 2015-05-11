package com.eeeya.fantuan.server.dao.impl;

import com.eeeya.fantuan.api.v1.contants.ImageType;
import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.ImageInfo;
import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.eeeya.fantuan.api.v1.model.UserLoginModel;
import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.common.model.ApiError;
import com.eeeya.fantuan.server.config.FantuanServerConfig;
import com.eeeya.fantuan.server.dao.UserDAO;
import com.eeeya.fantuan.server.domain.YfImage;
import com.eeeya.fantuan.server.domain.YfImageExample;
import com.eeeya.fantuan.server.domain.YfUser;
import com.eeeya.fantuan.server.domain.YfUserExample;
import com.eeeya.fantuan.server.mapper.YfImageMapper;
import com.eeeya.fantuan.server.mapper.YfUserMapper;
import com.eeeya.fantuan.server.model.UserLoginAuthModel;
import com.eeeya.fantuan.server.utils.DomainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    YfImageMapper yfImageMapper;

    @Autowired
    YfUserMapper yfUserMapper;


    @Override
    public UserInfo getUserInfoById(Long userId) {
        YfUser yfUser = yfUserMapper.selectByPrimaryKey(userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(yfUser.getName());
        userInfo.setUserId(userId);
        userInfo.setUserPhone(yfUser.getTelphone());

        // todo 需要线上兼容
        if(yfUser.getImgid()){
            YfImageExample yfImageExample = new YfImageExample();
            yfImageExample.or().andUseridEqualTo(userId);
            yfImageExample.setOrderByClause("id desc");
            List<YfImage> yfImageList = yfImageMapper.selectByExample(yfImageExample);
            if(!yfImageList.isEmpty()){
                userInfo.setUserLogo(new ImageInfo(ImageType.USER_LOGO, yfImageList.get(0).getImgsrc()));
            }
        }
        return userInfo;
    }

    @Override
    public CoordinatePosition getUserCoordinatePositionByUserId(Long userId) {
        if(userId == null){
            // todo
            userId = FantuanServerConfig.DEFAULT_USER_ID;
        }
        YfUser yfUser = yfUserMapper.selectByPrimaryKey(userId);
        CoordinatePosition coordinatePosition = new CoordinatePosition();
        coordinatePosition.setLatitudeValue(yfUser.getLatitude());
        coordinatePosition.setLongitudeValue(yfUser.getLongitude());
        return coordinatePosition;
    }

    @Override
    public UserLoginModel getUserLoginModelByPhoneAndPassword(String userPhone, String encodePassword) {

        UserLoginAuthModel userLoginAuthModel = getUserLoginAuthModelByPhone(userPhone);
        if (encodePassword != null && encodePassword.equals(userLoginAuthModel.getEncodedPassword())) {
            return userLoginAuthModel;
        } else {
            throw new ApiException(ApiError.USER_PHONE_PASSWORD_NOT_MATCH, "user: " + userPhone + ", encoded password: " + encodePassword);
        }
    }

    @Override
    public Boolean isRightToken(Long userId, String token) {
        YfUser yfUser = yfUserMapper.selectByPrimaryKey(userId);
        return token != null && token.equals(yfUser.getToken());
    }

    @Override
    public UserLoginAuthModel getUserLoginAuthModelByPhone(String userPhone) {
        YfUserExample yfUserExample = new YfUserExample();
        yfUserExample.or().andTelphoneEqualTo(userPhone);
        yfUserExample.setOffset(0);
        yfUserExample.setRows(1);
        yfUserExample.setOrderByClause("id desc");
        List<YfUser> yfUserList = yfUserMapper.selectByExample(yfUserExample);
        if(yfUserList.isEmpty()){
            throw new ApiException(ApiError.USER_PHONE_NOT_FOUND, userPhone);
        }
        YfUser yfUser = yfUserList.get(0);
        UserLoginAuthModel userLoginModel = new UserLoginAuthModel();
        DomainUtils.loadUserLoginAuthModel(userLoginModel, yfUser);
        return userLoginModel;

    }
}
