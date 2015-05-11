package com.eeeya.fantuan.api.v1.model.table;

import com.eeeya.fantuan.api.v1.model.ImageInfo;
import com.eeeya.fantuan.api.v1.model.PriceInfo;
import com.eeeya.fantuan.api.v1.model.RestaurantInfo;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐桌信息")
public class TableInfo extends TableMetaInfo {


    @ApiModelProperty("餐桌的Logo图，用于背景")
    ImageInfo tableLogo;

    @ApiModelProperty("餐桌人均价格")
    PriceInfo averagePrice;

    @ApiModelProperty("餐厅信息")
    RestaurantInfo restaurantInfo;

    @ApiModelProperty("餐桌在餐厅的位置序号")
    Integer tableIndex;

    @ApiModelProperty("餐桌状态，会实时变化")
    TableStatus tableStatus;

    public ImageInfo getTableLogo() {
        return tableLogo;
    }

    public void setTableLogo(ImageInfo tableLogo) {
        this.tableLogo = tableLogo;
    }

    public PriceInfo getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(PriceInfo averagePrice) {
        this.averagePrice = averagePrice;
    }


    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }

    public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    public Integer getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(Integer tableIndex) {
        this.tableIndex = tableIndex;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }
}
