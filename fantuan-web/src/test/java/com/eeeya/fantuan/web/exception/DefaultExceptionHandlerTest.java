package com.eeeya.fantuan.web.exception;

import com.eeeya.fantuan.common.model.ApiError;
import com.eeeya.fantuan.server.config.FantuanServerConfig;
import com.eeeya.fantuan.web.BaseControllerTest;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


@Component
@WebAppConfiguration
public class DefaultExceptionHandlerTest extends BaseControllerTest {

    @Test
    public void testDefaultApiViewExceptionHandler() throws Exception {

        mockMvc.perform(get(FantuanServerConfig.URL_PREFIX+"/test/exception/defaultApiViewException"))
                .andExpect(redirectedUrl(FantuanServerConfig.ERROR_REDIRECT_URL));

    }

    @Test
    public void testDefaultApiExceptionHandler() throws Exception {

        mockMvc.perform(get(FantuanServerConfig.URL_PREFIX+"/test/exception/defaultApiException.json"))
                .andExpect(jsonPath("status").value(ApiError.BAD_REQUEST.getErrorCode()));
    }

    @Test
    public void testDefaultTypeMismatchExceptionHandler() throws Exception {
        mockMvc.perform(get(FantuanServerConfig.URL_PREFIX+"/test/exception/defaultTypeMismatchException/it_is_not_a_id.json"))
                .andExpect(jsonPath("status").value(ApiError.BAD_REQUEST_PARAM_TYPE.getErrorCode()));

    }

    @Test
    public void testDefaultExceptionHandler() throws Exception {
        mockMvc.perform(get(FantuanServerConfig.URL_PREFIX+"/test/exception/defaultException.json"))
                .andExpect(jsonPath("status").value(ApiError.UNKNOWN_EXCEPTION.getErrorCode()));
    }
}