package com.eeeya.fantuan.api.v1.controller;

import com.eeeya.fantuan.api.common.ResultModel;
import com.eeeya.fantuan.api.v1.contants.V1Constants;
import com.eeeya.fantuan.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhonghui
 * @since 5/9/15.
 */
@Api(value = "用户接口", description = "用于查看用户信息")
@RestController
@RequestMapping(V1Constants.URL_PREFIX + "/table")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户位置信息")
    @RequestMapping(value = "/{userId}/coordinatePosition.json", method = RequestMethod.GET)
    public ResultModel<CoordinatePosition> getUserCoordinatePosition(
            @ApiParam("用户ID") @PathVariable Long userId
    ){
        CoordinatePosition coordinatePosition = userService.getUserCoordinatePosition(userId);

        return new ResultModel<CoordinatePosition>(coordinatePosition);
    }
}
