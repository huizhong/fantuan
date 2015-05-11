package com.eeeya.fantuan.common.exception;


import com.eeeya.fantuan.common.model.ApiError;

import java.util.Arrays;

/**
 * @author zhonghui
 * @since 1/18/15.
 */
public class ApiException extends RuntimeException {
    private final ApiError apiError;

    public ApiException(ApiError apiError) {
        this(apiError, apiError.getErrorCode() + ":" + apiError.getErrorMessage());
    }


    public ApiException(ApiError apiError, String message) {
        super(message);
        this.apiError = apiError;
    }
    public ApiException(ApiError apiError, String message, Throwable cause) {
        super(message, cause);
        this.apiError = apiError;
    }

    public ApiException(ApiError apiError, Object ... args) {
        this(apiError, Arrays.toString(args));
    }

    public ApiError getApiError() {
        return apiError;
    }

    @Override
    public void printStackTrace(){
        // todo log EXCEPTION getApiError(), this
        super.printStackTrace();
    }

}
