package com.eeeya.fantuan.model.table;

import com.eeeya.fantuan.utils.DateUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */

@ApiModel("餐桌部分状态")
abstract public class TableElementStatus {

    @ApiModelProperty("状态更新时间")
    Long updateTime;

    protected TableElementStatus() {
        this.updateTime = DateUtils.getTimeInNumber();
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }
}
