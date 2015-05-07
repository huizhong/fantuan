package com.eeeya.fantuan.exception;


import com.eeeya.fantuan.api.ApiError;
import com.eeeya.fantuan.param.RestaurantChangeParam;

import java.util.Arrays;

/**
 * @author zhonghui
 * @since 1/18/15.
 */
public class ApiException extends Exception {
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
