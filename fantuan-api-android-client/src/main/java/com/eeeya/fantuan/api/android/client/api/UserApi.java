package com.eeeya.fantuan.api.android.client.api;

import com.eeeya.fantuan.api.android.client.invoker.ApiException;
import com.eeeya.fantuan.api.android.client.invoker.ApiInvoker;
import com.eeeya.fantuan.api.android.client.model.ResultModelOfCoordinatePosition;
import com.eeeya.fantuan.api.android.client.model.ResultModelOfUserLoginModel;

import java.util.HashMap;
import java.util.Map;

public class UserApi {
  String basePath = "http://test.daidaiduoduo.com/";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  
  
  public ResultModelOfUserLoginModel  getUserLoginModel (String userPhone, String password) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/user/login.json".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userPhone)))
      queryParams.put("userPhone", String.valueOf(userPhone));
    if(!"null".equals(String.valueOf(password)))
      queryParams.put("password", String.valueOf(password));
    

    

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, contentType);
      if(response != null){
        return (ResultModelOfUserLoginModel) ApiInvoker.deserialize(response, "", ResultModelOfUserLoginModel.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
        return  null;
      }
      else {
        throw ex;
      }
    }
  }
  
  
  public ResultModelOfCoordinatePosition  getUserCoordinatePosition (Long userId, String userToken) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/user/{userId}/coordinatePosition.json".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userId" + "\\}", apiInvoker.escapeString(userId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userToken)))
      queryParams.put("userToken", String.valueOf(userToken));
    

    

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, contentType);
      if(response != null){
        return (ResultModelOfCoordinatePosition) ApiInvoker.deserialize(response, "", ResultModelOfCoordinatePosition.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
        return  null;
      }
      else {
        throw ex;
      }
    }
  }
  
}
