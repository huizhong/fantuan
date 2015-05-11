package com.eeeya.fantuan.api.v1.model;


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
