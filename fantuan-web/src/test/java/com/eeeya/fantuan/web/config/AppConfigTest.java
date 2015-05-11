package com.eeeya.fantuan.web.config;

import com.eeeya.fantuan.server.BaseControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppConfigTest extends BaseControllerTest {

    @Autowired
    AppConfig appConfig;

    @Test
    public void testGetAppProfileName() throws Exception {
        Assert.assertTrue(appConfig.getAppProfileName() != null);
    }

    @Test
    public void testGetAppName() throws Exception {
        Assert.assertTrue(appConfig.getAppName().equals("Fantuan"));
    }

    @Test
    public void testGetAppDescription() throws Exception {
        Assert.assertThat(appConfig.getAppDescription(), CoreMatchers.containsString(appConfig.getAppName()));
    }
}