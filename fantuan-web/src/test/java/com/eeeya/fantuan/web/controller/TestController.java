package com.eeeya.fantuan.web.controller;

import com.eeeya.fantuan.common.config.FantuanConfig;
import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.common.model.ApiError;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhonghui
 * @since 2/28/15.
 */

@Api(value = "测试接口", description = "内部调试使用，外部请勿调用，需要MIS登录")
@RestController
@RequestMapping(value = FantuanConfig.URL_PREFIX+"/test")
public class TestController {

    @ApiOperation("页面接口异常")
    @RequestMapping(value = "/exception/defaultApiViewException", method = RequestMethod.GET)
    public void getDefaultApiViewException() throws ApiException {
        throw new ApiException(ApiError.BAD_REQUEST);
    }

    @ApiOperation("数据接口异常")
    @RequestMapping(value = "/exception/defaultApiException.json", method = RequestMethod.GET)
    public void getDefaultApiException() throws ApiException {
        throw new ApiException(ApiError.BAD_REQUEST);
    }

    @ApiOperation("输入数据格式异常")
    @RequestMapping(value = "/exception/defaultTypeMismatchException/{id}.json", method = RequestMethod.GET)
    public Integer getDefaultTypeMismatchException(@PathVariable Integer id)
    {
        return id;
    }

    @ApiOperation("未知异常")
    @RequestMapping(value = "/exception/defaultException.json", method = RequestMethod.GET)
    public void getDefaultException(){
        throw new RuntimeException();
    }

}
