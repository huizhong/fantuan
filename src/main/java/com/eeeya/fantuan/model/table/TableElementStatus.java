package com.eeeya.fantuan.model.table;

import com.eeeya.fantuan.utils.DateUtils;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
abstract public class TableElementStatus {
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
