package com.eeeya.fantuan.im.server.exception;

/**
 * @author zhonghui
 * @since 5/13/15.
 */
public class ImException extends Exception {
    final Integer statusCode;
    final String detail;

    public ImException(String message, Integer statusCode, String detail) {
        super(message);
        this.statusCode = statusCode;
        this.detail = detail;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getDetail() {
        return detail;
    }
}
