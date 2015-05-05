package com.eeeya.fantuan.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhonghui
 * @since 1/18/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@ApiModel
public enum ApiError {

    /**
     * error code 前三位为 http的status，后两位用于区分不同场景。
     */
    BAD_REQUEST(        40000, "参数有误"),
    BAD_REQUEST_PARAM_TYPE(     40003, "请求参数类型有误"),
    BAD_TIME_FORMAT(    40005, "时间格式错误"),
    AUTHENTICATE_FAIL(  40100, "未通过授权验证"),
    NEED_LOGIN(         40101, "未登录"),

    FORBIDDEN(          40300, "拒绝访问"),

    INTERNAL_ERROR(     50000, "服务器错误"),

    UNKNOWN_EXCEPTION(  50099, "未知异常"),


    ;


    final private int errorCode;
    final private String errorMessage;

    ApiError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static ApiError valueOf(int errorCode) {
        for (ApiError apiError : values()) {
            if (apiError.getErrorCode() == errorCode) {
                return apiError;
            }
        }
        return null;
    }

    public static List<ApiError> getAllTypes() {
        return Arrays.asList(values());
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}