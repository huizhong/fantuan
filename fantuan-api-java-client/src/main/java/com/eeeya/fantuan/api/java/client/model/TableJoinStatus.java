package com.eeeya.fantuan.api.java.client.model;

import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class TableJoinStatus  {
  
  private Integer joinNumber = null;
  private List joinUserList = null;
  private String tableStatusLabel = null;
  private String tableIconType = null;
  private Long updateTime = null;

  
  /**
   * 参与人数
   **/
  @ApiModelProperty(required = false, value = "参与人数")
  @JsonProperty("joinNumber")
  public Integer getJoinNumber() {
    return joinNumber;
  }
  public void setJoinNumber(Integer joinNumber) {
    this.joinNumber = joinNumber;
  }

  
  /**
   * 参与人员列表
   **/
  @ApiModelProperty(required = false, value = "参与人员列表")
  @JsonProperty("joinUserList")
  public List getJoinUserList() {
    return joinUserList;
  }
  public void setJoinUserList(List joinUserList) {
    this.joinUserList = joinUserList;
  }

  
  /**
   * 参与状态标题，比如'四缺一'
   **/
  @ApiModelProperty(required = false, value = "参与状态标题，比如'四缺一'")
  @JsonProperty("tableStatusLabel")
  public String getTableStatusLabel() {
    return tableStatusLabel;
  }
  public void setTableStatusLabel(String tableStatusLabel) {
    this.tableStatusLabel = tableStatusLabel;
  }

  
  /**
   * 参与状态标签
   **/
  @ApiModelProperty(required = false, value = "参与状态标签")
  @JsonProperty("tableIconType")
  public String getTableIconType() {
    return tableIconType;
  }
  public void setTableIconType(String tableIconType) {
    this.tableIconType = tableIconType;
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
    sb.append("class TableJoinStatus {\n");
    
    sb.append("  joinNumber: ").append(joinNumber).append("\n");
    sb.append("  joinUserList: ").append(joinUserList).append("\n");
    sb.append("  tableStatusLabel: ").append(tableStatusLabel).append("\n");
    sb.append("  tableIconType: ").append(tableIconType).append("\n");
    sb.append("  updateTime: ").append(updateTime).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
