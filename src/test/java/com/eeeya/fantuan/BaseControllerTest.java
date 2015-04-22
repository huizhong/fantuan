package com.eeeya.fantuan;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author ben@eeeya.com
 * @since 4/22/15
 */
@Component
@WebAppConfiguration
abstract public class BaseControllerTest extends BaseTest {

    protected MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {

        this.mockMvc = webAppContextSetup(this.wac).build();
    }

}
