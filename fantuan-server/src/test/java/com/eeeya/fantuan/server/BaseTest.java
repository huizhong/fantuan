package com.eeeya.fantuan.server;

import com.eeeya.fantuan.server.config.DatabaseConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, DatabaseConfig.class})
abstract public class BaseTest {
}