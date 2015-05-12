package com.eeeya.fantuan.api.android.client.api;

import com.eeeya.fantuan.api.android.client.invoker.ApiException;
import com.eeeya.fantuan.api.android.client.invoker.ApiInvoker;
import com.eeeya.fantuan.api.android.client.model.ResultModelOfTableInfo;
import com.eeeya.fantuan.api.android.client.model.ResultModelOfTableStatus;

import java.util.HashMap;
import java.util.Map;

public class TableApi {
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

  
  
  public ResultModelOfTableInfo  changeTableByTableId (Long tableId) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/change.do".replaceAll("\\{format\\}","json").replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    

    

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
  
  
  public ResultModelOfTableInfo  getTableInfo (Long tableId) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/info.json".replaceAll("\\{format\\}","json").replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    

    

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
  
  
  public ResultModelOfTableInfo  joinTable (Long tableId, Long userId, String userToken) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/join.do".replaceAll("\\{format\\}","json").replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("userId", String.valueOf(userId));
    if(!"null".equals(String.valueOf(userToken)))
      queryParams.put("userToken", String.valueOf(userToken));
    

    

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
  
  
  public ResultModelOfTableInfo  startMeal (Long tableId, Long userId, String userToken) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/start.do".replaceAll("\\{format\\}","json").replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("userId", String.valueOf(userId));
    if(!"null".equals(String.valueOf(userToken)))
      queryParams.put("userToken", String.valueOf(userToken));
    

    

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
  
  
  public ResultModelOfTableStatus  getTableStatus (Long tableId) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/status.json".replaceAll("\\{format\\}","json").replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    

    

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, contentType);
      if(response != null){
        return (ResultModelOfTableStatus) ApiInvoker.deserialize(response, "", ResultModelOfTableStatus.class);
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
  
  
  public ResultModelOfTableInfo  voteFoodItem (Long tableId, Long foodItemId, Long userId, String userToken) throws ApiException {
    Object postBody = null;

    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/vote.do".replaceAll("\\{format\\}","json").replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(foodItemId)))
      queryParams.put("foodItemId", String.valueOf(foodItemId));
    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("userId", String.valueOf(userId));
    if(!"null".equals(String.valueOf(userToken)))
      queryParams.put("userToken", String.valueOf(userToken));
    

    

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
