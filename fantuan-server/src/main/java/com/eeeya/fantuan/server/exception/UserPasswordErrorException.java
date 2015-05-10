package com.eeeya.fantuan.server.exception;

import com.eeeya.fantuan.server.api.common.ApiMessage;

/**
 * @author zhonghui
 * @since 5/10/15.
 */
public class UserPasswordErrorException extends Throwable {
    public UserPasswordErrorException(String userPhone, String encodePassword) {
        super(String.format(ApiMessage.USER_PASSWORD_ERROR, userPhone, encodePassword));
    }
}
