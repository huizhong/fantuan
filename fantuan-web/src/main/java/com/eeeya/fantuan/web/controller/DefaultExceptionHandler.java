package com.eeeya.fantuan.web.controller;

import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.common.model.ApiError;
import com.eeeya.fantuan.common.model.ResultModel;
import com.eeeya.fantuan.server.config.FantuanServerConfig;
import com.eeeya.fantuan.server.utils.JsonUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class DefaultExceptionHandler {
    Boolean isUrlReturnJson(String url){
        if(url == null){
            return false;
        }
        if(url.toLowerCase().endsWith(".json")){
            return true;
        }
        //noinspection RedundantIfStatement
        if(url.toLowerCase().endsWith(".do")){
            return true;
        }
        return false;
    }
    @SuppressWarnings("RedundantIfStatement")
    private ModelAndView handleExceptionWithApiError(HttpServletRequest request, HttpServletResponse response, ApiError apiError, Exception exception) {
        exception.printStackTrace();
        Boolean showJsonFormatData;

        if(request == null){
            showJsonFormatData = true;
        }
        else if( isUrlReturnJson(request.getPathInfo())){
            showJsonFormatData = true;
        }
        else if( isUrlReturnJson(request.getServletPath())){
            showJsonFormatData = true;
        }
        else{
            showJsonFormatData = false;
        }

        if(showJsonFormatData) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            return new ModelAndView(ApiViewPath.MODEL_VIEW).addObject("model", JsonUtils.getJson(getExceptionResultModel(apiError, exception)));
        }
        else{
            return new ModelAndView(new RedirectView(FantuanServerConfig.ERROR_REDIRECT_URL));
        }
    }

    @ExceptionHandler
    @ResponseBody
    public ModelAndView defaultApiExceptionHandler(HttpServletRequest request, HttpServletResponse response, ApiException apiException){
        return handleExceptionWithApiError(request, response, apiException.getApiError(), apiException);
    }

    @ExceptionHandler
    @ResponseBody
    public ModelAndView defaultTypeMismatchExceptionHandler(HttpServletRequest request, HttpServletResponse response, TypeMismatchException typeMismatchException){
        return handleExceptionWithApiError(request, response, ApiError.BAD_REQUEST_PARAM_TYPE, typeMismatchException);
    }

    @ExceptionHandler
    @ResponseBody
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception unknownException){
        return handleExceptionWithApiError(request, response, ApiError.UNKNOWN_EXCEPTION, unknownException);
    }

    private ErrorResultModel getExceptionResultModel(ApiError apiError, Exception exception) {

        ErrorResultModel resultModel;
        if (FantuanServerConfig.PRINT_EXCEPTION_IN_ERROR) {
            resultModel = new ErrorResultModel(apiError, exception);
        } else {
            resultModel = new ErrorResultModel(apiError, null);
        }

        return resultModel;
    }

    private class ErrorResultModel extends ResultModel<String> {

        public ErrorResultModel(ApiError apiError, Exception exception) {
            super(apiError.getErrorCode(), apiError.getErrorMessage(), JsonUtils.getJson(exception));
        }
    }
}