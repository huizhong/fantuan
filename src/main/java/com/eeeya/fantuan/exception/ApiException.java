package com.eeeya.fantuan.exception;


import com.eeeya.fantuan.api.ApiError;

/**
 * @author zhonghui
 * @since 1/18/15.
 */
public class ApiException extends Exception {
    private final ApiError apiError;

    public ApiException(ApiError apiError) {
        super(apiError.getErrorCode() + ":" + apiError.getErrorMessage());
        this.apiError = apiError;
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
