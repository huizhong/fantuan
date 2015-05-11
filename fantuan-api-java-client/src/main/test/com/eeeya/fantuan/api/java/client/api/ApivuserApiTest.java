package com.eeeya.fantuan.api.java.client.api;

import com.eeeya.fantuan.api.java.client.invoker.ApiException;
import com.eeeya.fantuan.api.java.client.model.ResultModelOfUserLoginModel;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ApivuserApiTest {

    @Test
    public void testGetUserLoginModel() throws ApiException {
        ApivuserApi apivuserApi = new ApivuserApi();
        apivuserApi.setBasePath("http://test.daidaiduoduo.com/");
        ResultModelOfUserLoginModel resultModelOfUserLoginModel = apivuserApi.getUserLoginModel("15201030105", "1");
        assertTrue(resultModelOfUserLoginModel.getStatus().equals(0));
    }


}