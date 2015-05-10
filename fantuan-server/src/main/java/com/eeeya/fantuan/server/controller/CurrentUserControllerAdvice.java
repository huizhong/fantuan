package com.eeeya.fantuan.server.controller;

import com.eeeya.fantuan.server.api.v1.model.UserLoginModel;
import com.eeeya.fantuan.server.service.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author zhonghui
 * @since 5/10/15.
 */
@ControllerAdvice
public class CurrentUserControllerAdvice {
    @ModelAttribute("CurrentUser")
    public UserLoginModel getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : ((UserServiceImpl.CurrentUser) authentication.getPrincipal()).getUserLoginAuthModel();
    }
}