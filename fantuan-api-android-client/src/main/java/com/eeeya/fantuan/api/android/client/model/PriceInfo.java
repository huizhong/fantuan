package com.eeeya.fantuan.api.android.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class PriceInfo  {
  
  private Integer priceValue = null;
  private String priceUnit = null;

  
  /**
   * 价格数值
   **/
  @ApiModelProperty(required = false, value = "价格数值")
  @JsonProperty("priceValue")
  public Integer getPriceValue() {
    return priceValue;
  }
  public void setPriceValue(Integer priceValue) {
    this.priceValue = priceValue;
  }

  
  /**
   * 价格单位
   **/
  @ApiModelProperty(required = false, value = "价格单位")
  @JsonProperty("priceUnit")
  public String getPriceUnit() {
    return priceUnit;
  }
  public void setPriceUnit(String priceUnit) {
    this.priceUnit = priceUnit;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceInfo {\n");
    
    sb.append("  priceValue: ").append(priceValue).append("\n");
    sb.append("  priceUnit: ").append(priceUnit).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
