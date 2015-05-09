package com.eeeya.fantuan.controller.api;

import com.eeeya.fantuan.BaseControllerTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class ApiControllerTest extends BaseControllerTest {

    @Test
    public void testGetAppConfig() throws Exception {
        mockMvc.perform(get("/api/app/config.json")).andExpect(
                jsonPath("$.appName").value(any(String.class))

        );
    }
}