package com.eeeya.fantuan.server;

import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.common.model.ApiError;
import com.eeeya.fantuan.common.model.ResultModel;
import com.eeeya.fantuan.server.config.FantuanServerConfig;
import com.eeeya.fantuan.server.utils.JsonUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class DefaultExceptionHandler {
    
    private ErrorResultModel handleExceptionWithApiError(ApiError apiError, Exception exception) {
        exception.printStackTrace();
        return getExceptionResultModel(apiError, exception);
    }

    @ExceptionHandler
    public ErrorResultModel defaultApiExceptionHandler(ApiException apiException){
        return handleExceptionWithApiError(apiException.getApiError(), apiException);
    }

    @ExceptionHandler
    public ErrorResultModel defaultTypeMismatchExceptionHandler(TypeMismatchException typeMismatchException){
        return handleExceptionWithApiError(ApiError.BAD_REQUEST_PARAM_TYPE, typeMismatchException);
    }

    @ExceptionHandler
    public ErrorResultModel defaultExceptionHandler(Exception unknownException){
        return handleExceptionWithApiError(ApiError.UNKNOWN_EXCEPTION, unknownException);
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