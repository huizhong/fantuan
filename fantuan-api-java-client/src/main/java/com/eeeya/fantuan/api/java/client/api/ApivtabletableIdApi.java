package com.eeeya.fantuan.api.java.client.api;

import com.eeeya.fantuan.api.java.client.invoker.ApiException;
import com.eeeya.fantuan.api.java.client.invoker.ApiInvoker;

import com.eeeya.fantuan.api.java.client.model.*;

import java.util.*;

import com.eeeya.fantuan.api.java.client.model.ResultModelOfTableInfo;
import com.eeeya.fantuan.api.java.client.model.ResultModelOfTableStatus;

import com.sun.jersey.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class ApivtabletableIdApi {
  String basePath = "http://null/";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  
    
  public ResultModelOfTableInfo changeTableByTableId (Long tableId) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/change.do".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    
    
    String[] contentTypes = {
      "application/json"
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
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
  
    
  public ResultModelOfTableInfo getTableInfo (Long tableId) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/info.json".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    
    
    String[] contentTypes = {
      "application/json"
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
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
  
    
  public ResultModelOfTableInfo joinTable (Long tableId, Long userId, String userToken) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/join.do".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("userId", String.valueOf(userId));
    if(!"null".equals(String.valueOf(userToken)))
      queryParams.put("userToken", String.valueOf(userToken));
    
    
    String[] contentTypes = {
      "application/json"
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
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
  
    
  public ResultModelOfTableInfo startMeal (Long tableId, Long userId, String userToken) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/start.do".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("userId", String.valueOf(userId));
    if(!"null".equals(String.valueOf(userToken)))
      queryParams.put("userToken", String.valueOf(userToken));
    
    
    String[] contentTypes = {
      "application/json"
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
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
  
    
  public ResultModelOfTableStatus getTableStatus (Long tableId) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/status.json".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    
    
    String[] contentTypes = {
      "application/json"
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
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
  
    
  public ResultModelOfTableInfo voteFoodItem (Long tableId, Long foodItemId, Long userId, String userToken) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/table/{tableId}/vote.do".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(foodItemId)))
      queryParams.put("foodItemId", String.valueOf(foodItemId));
    if(!"null".equals(String.valueOf(userId)))
      queryParams.put("userId", String.valueOf(userId));
    if(!"null".equals(String.valueOf(userToken)))
      queryParams.put("userToken", String.valueOf(userToken));
    
    
    String[] contentTypes = {
      "application/json"
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
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
