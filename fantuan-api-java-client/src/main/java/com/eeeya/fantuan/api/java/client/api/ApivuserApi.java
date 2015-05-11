package com.eeeya.fantuan.api.java.client.api;

import com.eeeya.fantuan.api.java.client.invoker.ApiException;
import com.eeeya.fantuan.api.java.client.invoker.ApiInvoker;

import com.eeeya.fantuan.api.java.client.model.*;

import java.util.*;

import com.eeeya.fantuan.api.java.client.model.ResultModelOfUserLoginModel;
import com.eeeya.fantuan.api.java.client.model.ResultModelOfCoordinatePosition;

import com.sun.jersey.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class ApivuserApi {
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

  
    
  public ResultModelOfUserLoginModel getUserLoginModel (String userPhone, String password) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/user/login.json".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(userPhone)))
      queryParams.put("userPhone", String.valueOf(userPhone));
    if(!"null".equals(String.valueOf(password)))
      queryParams.put("password", String.valueOf(password));
    
    
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
  
    
  public ResultModelOfCoordinatePosition getUserCoordinatePosition (Long userId, String userToken) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/api/v1/user/{userId}/coordinatePosition.json".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "userId" + "\\}", apiInvoker.escapeString(userId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

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
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
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
