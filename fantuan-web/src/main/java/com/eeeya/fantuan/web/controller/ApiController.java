package com.eeeya.fantuan.web.controller;

import com.eeeya.fantuan.common.config.FantuanConfig;
import com.eeeya.fantuan.web.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ben@eeeya.com
 * @since 4/16/15
 */
@RestController
@RequestMapping(FantuanConfig.URL_PREFIX + "/api")
public class ApiController {

    @Autowired
    AppConfig appConfig;

    @RequestMapping(value = "/app/config.json", method = RequestMethod.GET)
    AppConfig getAppConfig() {
        return appConfig;
    }

}
