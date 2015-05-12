package com.eeeya.fantuan.api.android.client.api;

import com.eeeya.fantuan.api.android.client.invoker.ApiException;
import com.eeeya.fantuan.api.android.client.invoker.ApiInvoker;
import com.eeeya.fantuan.api.android.client.model.ResultModelOfTableInfo;

import java.util.HashMap;
import java.util.Map;

public class RestaurantApi {
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

  
  
  public ResultModelOfTableInfo  getRecommendTableInfo (Double userLatitude, Double userLongitude) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/restaurant/recommend.json".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userLatitude)))
      queryParams.put("userLatitude", String.valueOf(userLatitude));
    if(!"null".equals(String.valueOf(userLongitude)))
      queryParams.put("userLongitude", String.valueOf(userLongitude));
    

    

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, contentType);
      if(response != null){
        return (ResultModelOfTableInfo) ApiInvoker.deserialize(response, "", ResultModelOfTableInfo.class);
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
  
  
  public ResultModelOfTableInfo  changeRestaurantByTableId (Long tableId, Boolean isFarther, Double userLatitude, Double userLongitude) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/restaurant/{tableId}/change.do".replaceAll("\\{format\\}","json").replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(isFarther)))
      queryParams.put("isFarther", String.valueOf(isFarther));
    if(!"null".equals(String.valueOf(userLatitude)))
      queryParams.put("userLatitude", String.valueOf(userLatitude));
    if(!"null".equals(String.valueOf(userLongitude)))
      queryParams.put("userLongitude", String.valueOf(userLongitude));
    

    

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, contentType);
      if(response != null){
        return (ResultModelOfTableInfo) ApiInvoker.deserialize(response, "", ResultModelOfTableInfo.class);
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
