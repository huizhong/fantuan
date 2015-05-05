package com.eeeya.fantuan.config;

import com.eeeya.fantuan.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Component
@WebAppConfiguration
public class AppConfigTest extends BaseTest {

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