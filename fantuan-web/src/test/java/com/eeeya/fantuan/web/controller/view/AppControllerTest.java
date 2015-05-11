package com.eeeya.fantuan.web.controller.view;

import com.eeeya.fantuan.web.BaseControllerTest;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AppControllerTest extends BaseControllerTest {

    @Test
    public void testGetAppInfo() throws Exception {
        mockMvc.perform(get("/app/info")).andExpect(
                view().name("appInfo")
        );
    }
}