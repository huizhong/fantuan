package com.eeeya.fantuan.api.android.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class TableMessageStatus  {
  
  private Boolean hasNewMessage = null;
  private Long updateTime = null;

  
  /**
   * 是否有新消息
   **/
  @ApiModelProperty(required = false, value = "是否有新消息")
  @JsonProperty("hasNewMessage")
  public Boolean getHasNewMessage() {
    return hasNewMessage;
  }
  public void setHasNewMessage(Boolean hasNewMessage) {
    this.hasNewMessage = hasNewMessage;
  }

  
  /**
   * 状态更新时间
   **/
  @ApiModelProperty(required = false, value = "状态更新时间")
  @JsonProperty("updateTime")
  public Long getUpdateTime() {
    return updateTime;
  }
  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TableMessageStatus {\n");
    
    sb.append("  hasNewMessage: ").append(hasNewMessage).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
