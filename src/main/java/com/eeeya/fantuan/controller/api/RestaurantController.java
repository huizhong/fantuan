package com.eeeya.fantuan.controller.api;

import com.eeeya.fantuan.api.ResultModel;
import com.eeeya.fantuan.config.FantuanConfig;
import com.eeeya.fantuan.model.table.TableInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhonghui
 * @since 5/7/15.
 */
@Api(value = "餐厅接口", description = "用于换餐厅等操作")
@RestController
@RequestMapping(FantuanConfig.URL_PREFIX + "/api/restaurant")
public class RestaurantController {

    @ApiOperation("换餐厅")
    @RequestMapping(value = "/{tableId}/change.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> changeRestaurantByTableId(
            @ApiParam("当前餐厅ID") @PathVariable Long tableId,
            @ApiParam("切换到更远") @RequestParam Boolean isFarther,
            @ApiParam("用户位置经度") @RequestParam Double userLatitude,
            @ApiParam("用户位置纬度") @RequestParam Double userLongitude
    ){
        return new ResultModel<TableInfo>(new TableInfo());
    }

}
