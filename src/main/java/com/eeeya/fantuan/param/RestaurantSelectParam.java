package com.eeeya.fantuan.param;

import com.eeeya.fantuan.api.v1.param.RestaurantChangeParam;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public class RestaurantSelectParam extends RestaurantChangeParam {
    Long tableId;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public RestaurantSelectParam(Boolean isFarther, Double userLatitude, Double userLongitude, Long tableId) {
        super(isFarther, userLatitude, userLongitude);
        this.tableId = tableId;
    }

}
