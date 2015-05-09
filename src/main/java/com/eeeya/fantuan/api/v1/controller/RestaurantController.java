package com.eeeya.fantuan.api.v1.controller;

import com.eeeya.fantuan.api.common.ResultModel;
import com.eeeya.fantuan.api.v1.contants.V1Constants;
import com.eeeya.fantuan.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.param.RestaurantSelectParam;
import com.eeeya.fantuan.service.RestaurantService;
import com.eeeya.fantuan.service.TableService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhonghui
 * @since 5/7/15.
 */
@Api(value = "餐厅接口", description = "用于换餐厅等操作")
@RestController
@RequestMapping(V1Constants.URL_PREFIX + "/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    TableService tableService;

    @ApiOperation("换餐厅")
    @RequestMapping(value = "/{tableId}/change.do", method = RequestMethod.POST)
    public ResultModel<TableInfo> changeRestaurantByTableId(
            @ApiParam("当前餐厅ID") @PathVariable Long tableId,
            @ApiParam("切换到更远") @RequestParam Boolean isFarther,
            @ApiParam("用户位置经度") @RequestParam Double userLatitude,
            @ApiParam("用户位置纬度") @RequestParam Double userLongitude
    ){
        RestaurantSelectParam restaurantSelectParam = new RestaurantSelectParam(isFarther, userLatitude, userLongitude, tableId);
        return new ResultModel<TableInfo>(restaurantService.getNewRestaurant(restaurantSelectParam));
    }

}
