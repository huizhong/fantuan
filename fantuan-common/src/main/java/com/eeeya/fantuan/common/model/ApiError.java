package com.eeeya.fantuan.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

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
    BAD_REQUEST_PARAM_TYPE(     40001, "请求参数类型有误"),
    BAD_TIME_FORMAT(    40005, "时间格式错误"),
    AUTHENTICATE_FAIL(  40100, "未通过授权验证"),
    NEED_LOGIN(         40101, "未登录"),

    FORBIDDEN(          40300, "拒绝访问"),

    INTERNAL_ERROR(     50000, "服务器错误"),

    UNKNOWN_EXCEPTION(  50099, "未知异常"),


    BAD_REQUEST_ARGUMENT_NOT_MATCH_MODEL(4002, "参数值json值和期望的模型不一致"),
    BAD_REQUEST_ACTION(4003, "该动作不支持"),

    DATABASE_INSERT_FAILED(50301, "数据库插入失败"),
    USER_PHONE_NOT_FOUND(4004, "用户手机号未找到"),
    USER_PHONE_PASSWORD_NOT_MATCH(4005, "用户手机号和密码不匹配"),
    FAILED_TO_SEND_POST(4006, "请求发送失败"),
    DATABASE_DUPLICATE_KEY(50302, "不满足唯一性"),
    IM_ERROR(50303, "聊天系统出错"),
    DATABASE_REMOVE_FAILED(50304, "删除数据出错")
    ;


    @ApiModelProperty("错误代码")
    final private int errorCode;

    @ApiModelProperty("错误原因，面向开发人员")
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