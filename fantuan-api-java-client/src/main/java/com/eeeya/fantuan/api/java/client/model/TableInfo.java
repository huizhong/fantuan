package com.eeeya.fantuan.api.java.client.model;

import com.eeeya.fantuan.api.java.client.model.ImageInfo;
import com.eeeya.fantuan.api.java.client.model.PriceInfo;
import com.eeeya.fantuan.api.java.client.model.TableStatus;
import com.eeeya.fantuan.api.java.client.model.RestaurantInfo;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class TableInfo  {
  
  private TableStatus tableStatus = null;
  private Integer tableIndex = null;
  private RestaurantInfo restaurantInfo = null;
  private ImageInfo tableLogo = null;
  private PriceInfo averagePrice = null;
  private Long mealTime = null;
  private String mealType = null;
  private String payType = null;
  private Integer talkGroupId = null;
  private Long restaurantId = null;
  private String tableType = null;
  private Long tableId = null;

  
  /**
   * 餐桌状态，会实时变化
   **/
  @ApiModelProperty(required = false, value = "餐桌状态，会实时变化")
  @JsonProperty("tableStatus")
  public TableStatus getTableStatus() {
    return tableStatus;
  }
  public void setTableStatus(TableStatus tableStatus) {
    this.tableStatus = tableStatus;
  }

  
  /**
   * 餐桌在餐厅的位置序号
   **/
  @ApiModelProperty(required = false, value = "餐桌在餐厅的位置序号")
  @JsonProperty("tableIndex")
  public Integer getTableIndex() {
    return tableIndex;
  }
  public void setTableIndex(Integer tableIndex) {
    this.tableIndex = tableIndex;
  }

  
  /**
   * 餐厅信息
   **/
  @ApiModelProperty(required = false, value = "餐厅信息")
  @JsonProperty("restaurantInfo")
  public RestaurantInfo getRestaurantInfo() {
    return restaurantInfo;
  }
  public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
    this.restaurantInfo = restaurantInfo;
  }

  
  /**
   * 餐桌的Logo图，用于背景
   **/
  @ApiModelProperty(required = false, value = "餐桌的Logo图，用于背景")
  @JsonProperty("tableLogo")
  public ImageInfo getTableLogo() {
    return tableLogo;
  }
  public void setTableLogo(ImageInfo tableLogo) {
    this.tableLogo = tableLogo;
  }

  
  /**
   * 餐桌人均价格
   **/
  @ApiModelProperty(required = false, value = "餐桌人均价格")
  @JsonProperty("averagePrice")
  public PriceInfo getAveragePrice() {
    return averagePrice;
  }
  public void setAveragePrice(PriceInfo averagePrice) {
    this.averagePrice = averagePrice;
  }

  
  /**
   * 会餐时间
   **/
  @ApiModelProperty(required = false, value = "会餐时间")
  @JsonProperty("mealTime")
  public Long getMealTime() {
    return mealTime;
  }
  public void setMealTime(Long mealTime) {
    this.mealTime = mealTime;
  }

  
  /**
   * 会餐类型
   **/
  @ApiModelProperty(required = false, value = "会餐类型")
  @JsonProperty("mealType")
  public String getMealType() {
    return mealType;
  }
  public void setMealType(String mealType) {
    this.mealType = mealType;
  }

  
  /**
   * 餐桌付款方式
   **/
  @ApiModelProperty(required = false, value = "餐桌付款方式")
  @JsonProperty("payType")
  public String getPayType() {
    return payType;
  }
  public void setPayType(String payType) {
    this.payType = payType;
  }

  
  /**
   * 环信群聊ID
   **/
  @ApiModelProperty(required = false, value = "环信群聊ID")
  @JsonProperty("talkGroupId")
  public Integer getTalkGroupId() {
    return talkGroupId;
  }
  public void setTalkGroupId(Integer talkGroupId) {
    this.talkGroupId = talkGroupId;
  }

  
  /**
   * 餐厅ID
   **/
  @ApiModelProperty(required = false, value = "餐厅ID")
  @JsonProperty("restaurantId")
  public Long getRestaurantId() {
    return restaurantId;
  }
  public void setRestaurantId(Long restaurantId) {
    this.restaurantId = restaurantId;
  }

  
  /**
   * 餐桌座位类型
   **/
  @ApiModelProperty(required = false, value = "餐桌座位类型")
  @JsonProperty("tableType")
  public String getTableType() {
    return tableType;
  }
  public void setTableType(String tableType) {
    this.tableType = tableType;
  }

  
  /**
   * 餐桌唯一ID
   **/
  @ApiModelProperty(required = false, value = "餐桌唯一ID")
  @JsonProperty("tableId")
  public Long getTableId() {
    return tableId;
  }
  public void setTableId(Long tableId) {
    this.tableId = tableId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TableInfo {\n");
    
    sb.append("  tableStatus: ").append(tableStatus).append("\n");
    sb.append("  tableIndex: ").append(tableIndex).append("\n");
    sb.append("  restaurantInfo: ").append(restaurantInfo).append("\n");
    sb.append("  tableLogo: ").append(tableLogo).append("\n");
    sb.append("  averagePrice: ").append(averagePrice).append("\n");
    sb.append("  mealTime: ").append(mealTime).append("\n");
    sb.append("  mealType: ").append(mealType).append("\n");
    sb.append("  payType: ").append(payType).append("\n");
    sb.append("  talkGroupId: ").append(talkGroupId).append("\n");
    sb.append("  restaurantId: ").append(restaurantId).append("\n");
    sb.append("  tableType: ").append(tableType).append("\n");
    sb.append("  tableId: ").append(tableId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
