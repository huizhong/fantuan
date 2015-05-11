package com.eeeya.fantuan.web.controller;

import com.eeeya.fantuan.common.config.FantuanConfig;
import com.eeeya.fantuan.web.config.AppConfig;
import com.eeeya.fantuan.web.constants.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@Controller
@RequestMapping(FantuanConfig.URL_PREFIX)
public class ErrorController {

    @Autowired
    AppConfig appConfig;

    @RequestMapping(value = {"/404", "/error"}, method = RequestMethod.GET)
    @ResponseBody
    String getNotFoundPage() {
        return ErrorMessages.ERROR_PAGE_NOT_FOUND;
    }

}