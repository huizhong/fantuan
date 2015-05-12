package com.eeeya.fantuan.api.android.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class CoordinatePosition  {
  
  private Double latitudeValue = null;
  private Double longitudeValue = null;

  
  /**
   * 纬度
   **/
  @ApiModelProperty(required = false, value = "纬度")
  @JsonProperty("latitudeValue")
  public Double getLatitudeValue() {
    return latitudeValue;
  }
  public void setLatitudeValue(Double latitudeValue) {
    this.latitudeValue = latitudeValue;
  }

  
  /**
   * 经度
   **/
  @ApiModelProperty(required = false, value = "经度")
  @JsonProperty("longitudeValue")
  public Double getLongitudeValue() {
    return longitudeValue;
  }
  public void setLongitudeValue(Double longitudeValue) {
    this.longitudeValue = longitudeValue;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoordinatePosition {\n");
    
    sb.append("  latitudeValue: ").append(latitudeValue).append("\n");
    sb.append("  longitudeValue: ").append(longitudeValue).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
