package com.eeeya.fantuan.controller;

import com.eeeya.fantuan.api.common.ApiMessage;
import com.eeeya.fantuan.config.AppConfig;
import com.eeeya.fantuan.config.FantuanConfig;
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
@RequestMapping(FantuanConfig.URL_PREFIX + "/error")
public class ErrorController {

    @Autowired
    AppConfig appConfig;

    @RequestMapping(value = {"/404", ""}, method = RequestMethod.GET)
    @ResponseBody
    String getNotFoundPage() {
        return ApiMessage.ERROR_PAGE_NOT_FOUND;
    }

}