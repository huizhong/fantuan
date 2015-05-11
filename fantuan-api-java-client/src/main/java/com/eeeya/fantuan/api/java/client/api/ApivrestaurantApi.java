package com.eeeya.fantuan.api.java.client.api;

import com.eeeya.fantuan.api.java.client.invoker.ApiException;
import com.eeeya.fantuan.api.java.client.invoker.ApiInvoker;

import com.eeeya.fantuan.api.java.client.model.*;

import java.util.*;

import com.eeeya.fantuan.api.java.client.model.ResultModelOfTableInfo;

import com.sun.jersey.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class ApivrestaurantApi {
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

  
    
  public ResultModelOfTableInfo getRecommendTableInfo (Double userLatitude, Double userLongitude) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/restaurant/recommend.json".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userLatitude)))
      queryParams.put("userLatitude", String.valueOf(userLatitude));
    if(!"null".equals(String.valueOf(userLongitude)))
      queryParams.put("userLongitude", String.valueOf(userLongitude));
    
    
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
  
    
  public ResultModelOfTableInfo changeRestaurantByTableId (Long tableId, Boolean isFarther, Double userLatitude, Double userLongitude) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/restaurant/{tableId}/change.do".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "tableId" + "\\}", apiInvoker.escapeString(tableId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(isFarther)))
      queryParams.put("isFarther", String.valueOf(isFarther));
    if(!"null".equals(String.valueOf(userLatitude)))
      queryParams.put("userLatitude", String.valueOf(userLatitude));
    if(!"null".equals(String.valueOf(userLongitude)))
      queryParams.put("userLongitude", String.valueOf(userLongitude));
    
    
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
