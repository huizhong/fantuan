package com.eeeya.fantuan.server.api;

import com.eeeya.fantuan.server.config.AppConfig;
import com.eeeya.fantuan.server.config.FantuanConfig;
import com.mangofactory.swagger.annotations.ApiIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ben@eeeya.com
 * @since 4/16/15
 */
@ApiIgnore
@RestController
@RequestMapping(FantuanConfig.URL_PREFIX + "/api")
public class ApiController {

    @Autowired
    AppConfig appConfig;

    @ApiIgnore
    @RequestMapping(value = "/app/config.json", method = RequestMethod.GET)
    AppConfig getAppConfig() {
        return appConfig;
    }

}
