package com.eeeya.fantuan.config;

import com.eeeya.fantuan.BaseControllerTest;
import com.eeeya.fantuan.server.config.AppConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Component
public class AppConfigTest extends BaseControllerTest {

    @Autowired
    AppConfig appConfig;

    @Test
    public void testGetAppProfileName() throws Exception {
        assertTrue(appConfig.getAppProfileName() != null);
    }

    @Test
    public void testGetAppName() throws Exception {
        assertTrue(appConfig.getAppName().equals("Fantuan"));
    }

    @Test
    public void testGetAppDescription() throws Exception {
        assertThat(appConfig.getAppDescription(), containsString(appConfig.getAppName()));
    }
}