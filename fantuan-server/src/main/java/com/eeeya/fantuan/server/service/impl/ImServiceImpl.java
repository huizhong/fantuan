package com.eeeya.fantuan.server.service.impl;

import com.eeeya.fantuan.api.v1.model.UserLoginModel;
import com.eeeya.fantuan.im.server.exception.ImException;
import com.eeeya.fantuan.im.server.utils.ImUtils;
import com.eeeya.fantuan.server.service.ImService;
import com.eeeya.fantuan.server.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhonghui
 * @since 5/12/15.
 */
@Service
public class ImServiceImpl implements ImService, InitializingBean {
    @Autowired
    UserService userService;

    @Override
    public void createSystemUser() {
        try {
            ImUtils.createUser(ImUtils.SYSTEM_USER_ID, "token", "系统账户，每个群都参加");
        } catch (ImException ignore) {
        }
    }

    @Override
    public void updateUserImAccount(){
        for(UserLoginModel userLoginModel : userService.getAllUserLoginModel()){
            try {
                ImUtils.createUser(userLoginModel.getUserId().toString(), userLoginModel.getUserToken(), userLoginModel.getUserName());
            } catch (ImException e) {
                try {
                    ImUtils.setUserPassword(userLoginModel.getUserId().toString(), userLoginModel.getUserToken());
                } catch (ImException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        updateUserImAccount();
    }
}
