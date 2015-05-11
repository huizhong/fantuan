package com.eeeya.fantuan.api.android.client.api;

import com.eeeya.fantuan.api.android.client.invoker.ApiException;
import com.eeeya.fantuan.api.android.client.model.ResultModelOfCoordinatePosition;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ApivuserApiTest {

    @Test
    public void testGetUserLoginModel() throws ApiException {
        ApivuserApi apivuserApi = new ApivuserApi();
        apivuserApi.setBasePath("http://test.daidaiduoduo.com/");
        ResultModelOfCoordinatePosition resultModelOfUserLoginModel = apivuserApi.getUserCoordinatePosition(101L, "0");
        assertTrue(resultModelOfUserLoginModel.getStatus().equals(0));
    }


}