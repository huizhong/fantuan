package com.eeeya.fantuan.server.api.v1.model;

import com.eeeya.fantuan.server.config.FantuanConfig;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("价格信息")
public class PriceInfo {

    @ApiModelProperty("价格数值")
    Integer priceValue;

    @ApiModelProperty("价格单位")
    String priceUnit;

    public PriceInfo() {
        priceValue = FantuanConfig.DEFAULT_PRICE_VALUE;
        priceUnit = FantuanConfig.DEFAULT_PRICE_UNIT;
    }

    public Integer getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(Integer priceValue) {
        this.priceValue = priceValue;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }
}
