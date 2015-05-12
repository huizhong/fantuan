package com.eeeya.fantuan.api.android.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class UserLoginModel  {
  
  private String userToken = null;
  private Long userId = null;
  private String userName = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("userToken")
  public String getUserToken() {
    return userToken;
  }
  public void setUserToken(String userToken) {
    this.userToken = userToken;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("userName")
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserLoginModel {\n");
    
    sb.append("  userToken: ").append(userToken).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  userName: ").append(userName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
