package com.eeeya.fantuan.dao.impl;

import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.ImageInfo;
import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.eeeya.fantuan.contants.ImageType;
import com.eeeya.fantuan.dao.UserDAO;
import com.eeeya.fantuan.domain.YfImage;
import com.eeeya.fantuan.domain.YfImageExample;
import com.eeeya.fantuan.domain.YfUser;
import com.eeeya.fantuan.mapper.YfImageMapper;
import com.eeeya.fantuan.mapper.YfUserMapper;
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
        YfUser yfUser = yfUserMapper.selectByPrimaryKey(userId);
        CoordinatePosition coordinatePosition = new CoordinatePosition();
        coordinatePosition.setLatitudeValue(yfUser.getLatitude());
        coordinatePosition.setLongitudeValue(yfUser.getLongitude());
        return coordinatePosition;
    }
}
