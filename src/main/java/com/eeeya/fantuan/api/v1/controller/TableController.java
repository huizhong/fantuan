package com.eeeya.fantuan.api.v1.controller;

import com.eeeya.fantuan.api.common.ResultModel;
import com.eeeya.fantuan.api.v1.contants.V1Constants;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;


/**
 * @author zhonghui
 * @since 5/6/15.
 */

@Api(value = "餐桌接口", description = "用于查看餐桌信息，获取餐桌状态，和换桌、换餐厅等操作")
@RestController
@RequestMapping(V1Constants.URL_PREFIX + "/table")
public class TableController {


    @ApiOperation("餐桌推荐")
    @RequestMapping(value = "recommend.json", method = RequestMethod.GET)
    public ResultModel<TableInfo> getRecommendTableInfo(){
        return new ResultModel<TableInfo>(new TableInfo());
    }

    @ApiOperation("餐桌信息")
    @RequestMapping(value = "{tableId}/info.json", method = RequestMethod.GET)
    public ResultModel<TableInfo> getTableInfo(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }

    @ApiOperation("餐桌状态")
    @RequestMapping(value = "{tableId}/status.json", method = RequestMethod.GET)
    ResultModel<TableInfo> getTableStatus(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }


    @ApiOperation("换桌")
    @RequestMapping(value = "{tableId}/change.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> changeTableByTableId(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }

    @ApiOperation("拼桌")
    @RequestMapping(value = "{tableId}/join.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> joinTable(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }

    @ApiOperation("开桌")
    @RequestMapping(value = "{tableId}/add.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> addTable(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }

    @ApiOperation("投票")
    @RequestMapping(value = "{tableId}/vote.do", method = RequestMethod.POST)
    ResultModel<TableInfo> voteFoodItem(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId,
            @ApiParam("投票菜品ID") @RequestParam Long foodItemId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }


    @ApiOperation("出发")
    @RequestMapping(value = "{tableId}/start.do", method = RequestMethod.POST)
    ResultModel<TableInfo> startMeal(
            @ApiParam("当前餐桌ID") @PathVariable Long tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }



}