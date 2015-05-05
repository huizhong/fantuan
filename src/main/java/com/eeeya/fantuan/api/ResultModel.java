package com.eeeya.fantuan.api;

import com.eeeya.fantuan.config.FantuanConfig;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 1/19/15.
 */
@SuppressWarnings("UnusedDeclaration")
public class ResultModel<T> {

    @ApiModelProperty(value = "请求状态, 0表示正常", required = true)
    private final int status;

    @ApiModelProperty(value = "请求的数据。")
    private final T data;

    @ApiModelProperty(value = "错误信息。")
    private final String message;

    @ApiModelProperty(value = "其它信息。")
    private final Object ext;

    private ResultModel(int status, T data, String message, Object ext) {
        this.ext = ext;
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public ResultModel(T data) {
        this(FantuanConfig.SUCCESS_STATUS_CODE, data, null, null);
    }

    protected ResultModel(int errorCode, String errorMessage, Object ext) {
        this(errorCode, null, errorMessage, ext);
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Object getExt() {
        return ext;
    }
}