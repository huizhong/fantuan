package com.eeeya.fantuan.controller.api;

import com.eeeya.fantuan.api.ListResultModel;
import com.eeeya.fantuan.api.ResultModel;
import com.eeeya.fantuan.config.FantuanConfig;
import com.eeeya.fantuan.model.table.TableInfo;
import com.eeeya.fantuan.model.table.TableStatus;
import com.eeeya.fantuan.model.UserInfo;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */

@RestController
@RequestMapping(FantuanConfig.URL_PREFIX + "/api/table")
public class TableController {

    @RequestMapping(value = "{tableId}/users/join", method = RequestMethod.GET)
    ListResultModel<UserInfo> getUserListJoin(
            @PathVariable Integer tableId
    ){
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        for(int i=0; i<3; i++){
            userInfoList.add(new UserInfo(tableId * 2 + i));
        }
        return new ListResultModel<UserInfo>(userInfoList);
    }

    @ApiOperation("查看下一桌信息")
    @RequestMapping(value = "{tableId}/next/table/info.json", method = RequestMethod.GET)
    ResultModel<TableInfo> getNextTableInfo(
            @PathVariable Integer tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }


    @ApiOperation("查看下一餐馆信息")
    @RequestMapping(value = "{tableId}/next/restaurant/info.json", method = RequestMethod.GET)
    ResultModel<TableInfo> getNextRestaurantTableInfo(
            @PathVariable Integer tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }

    @ApiOperation("查看餐桌信息")
    @RequestMapping(value = "{tableId}/info.json", method = RequestMethod.GET)
    ResultModel<TableInfo> getTableInfo(
            @PathVariable Integer tableId
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }

    @ApiOperation("查看餐桌状态")
    @RequestMapping(value = "{tableId}/status.json", method = RequestMethod.GET)
    ResultModel<TableStatus> getTableStatus(
            @PathVariable Integer tableId
    ){
        return new ResultModel<TableStatus>(new TableStatus());
    }
}
