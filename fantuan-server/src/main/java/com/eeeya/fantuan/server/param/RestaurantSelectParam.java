package com.eeeya.fantuan.server.param;

import com.eeeya.fantuan.server.api.v1.param.RestaurantParam;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public class RestaurantSelectParam extends RestaurantParam {
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
