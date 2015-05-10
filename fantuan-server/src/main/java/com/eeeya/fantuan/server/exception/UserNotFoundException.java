package com.eeeya.fantuan.server.exception;

import com.eeeya.fantuan.server.api.common.ApiMessage;

/**
 * @author zhonghui
 * @since 5/10/15.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super(ApiMessage.PHONE_NOT_FOUND);
    }
}
