package com.eeeya.fantuan.server.controller;

import com.eeeya.fantuan.api.v1.contants.V1Constants;
import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.eeeya.fantuan.api.v1.model.UserLoginModel;
import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.common.model.ResultModel;
import com.eeeya.fantuan.server.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
@Api(value = "用户接口", description = "用于查看用户信息")
@RestController
@RequestMapping(value = V1Constants.URL_PREFIX + "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户位置信息")
    @RequestMapping(value = "/{userId}/coordinatePosition.json", method = RequestMethod.GET)
    public ResultModel<CoordinatePosition> getUserCoordinatePosition(
            @ApiParam("用户ID") @PathVariable Long userId,
            @ApiParam("用户Token") @RequestParam String userToken
    ) throws ApiException {
        userService.checkPermission(userId, userToken);
        CoordinatePosition coordinatePosition = userService.getUserCoordinatePosition(userId);

        return new ResultModel<CoordinatePosition>(coordinatePosition);
    }

    @ApiOperation("用户登录")
    @RequestMapping(value="/login.json", method = RequestMethod.GET)
    public ResultModel<UserLoginModel> getUserLoginModel(
            @ApiParam("用户手机号") @RequestParam String userPhone,
            @ApiParam("用户密码") @RequestParam String password
    ) throws ApiException {
        return new ResultModel<UserLoginModel>(userService.getUserLoginModelByPassword(userPhone, password));
    }

    @ApiOperation("获取用户基本信息")
    @RequestMapping(value = "/info.json", method = RequestMethod.GET)
    public ResultModel<UserInfo> getUserInfo(
            @ApiParam("用户ID") @RequestParam Long userId
    ){
        return new ResultModel<UserInfo>(userService.getUserInfo(userId));
    }

}
