package com.eeeya.fantuan.model.table.meal;

import com.eeeya.fantuan.model.UserInfo;
import com.eeeya.fantuan.model.table.TableElementStatus;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class MealStartItem extends TableElementStatus {
    UserInfo userInfo;
    Long startTime;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}
