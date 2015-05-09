package com.eeeya.fantuan.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ben@eeeya.com
 * @since 4/17/15
 */
@Component
public class AppConfig {
    @Value("${app.profile}")
    String appProfileName;

    @Value("${app.name}")
    String appName;

    @Value("${app.description}")
    String appDescription;

    public String getAppProfileName() {
        return appProfileName;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppDescription() {
        return appDescription;
    }
}
