package com.eeeya.fantuan.model.table;

import com.eeeya.fantuan.config.FantuanConfig;
import com.eeeya.fantuan.contants.PayType;
import com.eeeya.fantuan.model.ImageInfo;
import com.eeeya.fantuan.model.RestaurantInfo;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐桌信息")
public class TableInfo {

    @ApiModelProperty("餐桌唯一ID")
    Long tableId;

    @ApiModelProperty("餐桌在餐厅的位置序号")
    Integer tableIndex;

    @ApiModelProperty("餐桌能坐多少人")
    Integer tableSize;

    @ApiModelProperty("餐桌的Logo图，用于背景")
    ImageInfo tableLogo;

    @ApiModelProperty("餐桌人均价格")
    PriceInfo averagePrice;

    @ApiModelProperty("餐桌付款方式")
    PayType payType;

    @ApiModelProperty("餐厅信息")
    RestaurantInfo restaurantInfo;

    @ApiModelProperty("餐桌状态，会实时变化")
    TableStatus tableStatus;

    public TableInfo() {
        this.tableId = FantuanConfig.DEFAULT_TABLE_ID;
        this.tableIndex = FantuanConfig.DEFAULT_TABLE_INDEX;
        this.tableLogo = new ImageInfo();
        this.averagePrice= new PriceInfo();
        this.payType = FantuanConfig.DEFAULT_PAY_TYPE;
        this.restaurantInfo = new RestaurantInfo();
        this.tableStatus = new TableStatus();
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Integer getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(Integer tableIndex) {
        this.tableIndex = tableIndex;
    }

    public Integer getTableSize() {
        return tableSize;
    }

    public void setTableSize(Integer tableSize) {
        this.tableSize = tableSize;
    }

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

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }

    public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }
}
