package com.eeeya.fantuan.controller.view;

import com.eeeya.fantuan.BaseControllerTest;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ViewControllerTest extends BaseControllerTest {

    @Test
    public void testGetAppInfo() throws Exception {
        mockMvc.perform(get("/app/info")).andExpect(
                view().name("appInfo")
        );
    }
}