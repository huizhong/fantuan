package com.eeeya.fantuan.model.table;

import com.eeeya.fantuan.config.FantuanConfig;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class PriceInfo {
    Integer priceValue;
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
