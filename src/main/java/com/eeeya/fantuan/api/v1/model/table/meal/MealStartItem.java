package com.eeeya.fantuan.api.v1.model.table.meal;

import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.eeeya.fantuan.api.v1.model.table.TableElementStatus;
import com.eeeya.fantuan.utils.DateUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("会餐人员出发信息条目")
public class MealStartItem extends TableElementStatus {

    @ApiModelProperty("会餐人员")
    UserInfo userInfo;

    @ApiModelProperty("出发时间")
    Long startTime;

    public MealStartItem() {
        this.userInfo = new UserInfo();
        this.startTime = DateUtils.getTimeInNumber();
    }

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