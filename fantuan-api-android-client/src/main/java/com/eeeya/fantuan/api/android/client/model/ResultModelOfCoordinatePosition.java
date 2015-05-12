package com.eeeya.fantuan.api.android.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class ResultModelOfCoordinatePosition  {
  
  private String message = null;
  private Object ext = null;
  private Integer status = null;
  private Long time = null;
  private CoordinatePosition data = null;

  
  /**
   * 错误信息
   **/
  @ApiModelProperty(required = false, value = "错误信息")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  
  /**
   * 其它信息
   **/
  @ApiModelProperty(required = false, value = "其它信息")
  @JsonProperty("ext")
  public Object getExt() {
    return ext;
  }
  public void setExt(Object ext) {
    this.ext = ext;
  }

  
  /**
   * 请求状态, 0表示正常
   **/
  @ApiModelProperty(required = false, value = "请求状态, 0表示正常")
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  
  /**
   * 服务器时间
   **/
  @ApiModelProperty(required = false, value = "服务器时间")
  @JsonProperty("time")
  public Long getTime() {
    return time;
  }
  public void setTime(Long time) {
    this.time = time;
  }

  
  /**
   * 请求的数据
   **/
  @ApiModelProperty(required = false, value = "请求的数据")
  @JsonProperty("data")
  public CoordinatePosition getData() {
    return data;
  }
  public void setData(CoordinatePosition data) {
    this.data = data;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultModelOfCoordinatePosition {\n");
    
    sb.append("  message: ").append(message).append("\n");
    sb.append("  ext: ").append(ext).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  time: ").append(time).append("\n");
    sb.append("  data: ").append(data).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
