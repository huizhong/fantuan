package com.eeeya.fantuan.server.controller;

import com.eeeya.fantuan.api.v1.contants.V1Constants;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.api.v1.model.table.TableStatus;
import com.eeeya.fantuan.common.exception.ApiException;
import com.eeeya.fantuan.common.model.ResultModel;
import com.eeeya.fantuan.server.service.RestaurantService;
import com.eeeya.fantuan.server.service.TableService;
import com.eeeya.fantuan.server.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author zhonghui
 * @since 5/6/15.
 */

@Api(value = "餐桌接口", description = "用于查看餐桌信息，获取餐桌状态，和换桌、换餐厅等操作")
@RestController
@RequestMapping(V1Constants.URL_PREFIX + "/table")
public class TableController {

    @Autowired
    TableService tableService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    UserService userService;

    @ApiOperation("餐桌信息")
    @RequestMapping(value = "{tableId}/info.json", method = RequestMethod.GET)
    public ResultModel<TableInfo> getTableInfo(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ){
        return new ResultModel<TableInfo>(tableService.getTableInfo(tableId));
    }

    @ApiOperation("餐桌状态")
    @RequestMapping(value = "{tableId}/status.json", method = RequestMethod.GET)
    ResultModel<TableStatus> getTableStatus(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ){
        return new ResultModel<TableStatus>(tableService.getTableInfo(tableId).getTableStatus());
    }


    @ApiOperation("换桌")
    @RequestMapping(value = "{tableId}/change.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> changeTableByTableId(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ) throws ApiException {
        return new ResultModel<TableInfo>(tableService.getNextTable(tableId));
    }

    @ApiOperation("拼桌")
    @RequestMapping(value = "{tableId}/join.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> joinTable(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId,
            @ApiParam("用户ID") @RequestParam Long userId,
            @ApiParam("用户Token") @RequestParam String userToken
    ) throws ApiException {
        userService.checkPermission(userId, userToken);
        return new ResultModel<TableInfo>(tableService.joinTable(tableId, userId));
    }

    @ApiOperation("投票")
    @RequestMapping(value = "{tableId}/vote.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> voteFoodItem(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId,
            @ApiParam("投票菜品ID") @RequestParam Long foodItemId,
            @ApiParam("用户ID") @RequestParam Long userId,
            @ApiParam("用户Token") @RequestParam String userToken
    ) throws ApiException {
        userService.checkPermission(userId, userToken);
        return new ResultModel<TableInfo>(tableService.voteMeal(tableId, userId, foodItemId));
    }


    @ApiOperation("出发")
    @RequestMapping(value = "{tableId}/start.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> startMeal(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId,
            @ApiParam("用户ID") @RequestParam Long userId,
            @ApiParam("用户Token") @RequestParam String userToken
    ) throws ApiException {
        userService.checkPermission(userId, userToken);
        return new ResultModel<TableInfo>(tableService.startMeal(tableId, userId));
    }
}
