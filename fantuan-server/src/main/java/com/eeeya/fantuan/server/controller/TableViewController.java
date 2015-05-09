package com.eeeya.fantuan.server.controller;

import com.eeeya.fantuan.server.api.common.ApiError;
import com.eeeya.fantuan.server.api.common.ResultModel;
import com.eeeya.fantuan.server.api.v1.controller.RestaurantController;
import com.eeeya.fantuan.server.api.v1.controller.TableController;
import com.eeeya.fantuan.server.api.v1.controller.UserController;
import com.eeeya.fantuan.server.api.v1.model.CoordinatePosition;
import com.eeeya.fantuan.server.api.v1.model.table.TableInfo;
import com.eeeya.fantuan.server.api.v1.param.RestaurantParam;
import com.eeeya.fantuan.server.config.FantuanConfig;
import com.eeeya.fantuan.server.contants.TableActionType;
import com.eeeya.fantuan.server.exception.ApiException;
import com.eeeya.fantuan.server.utils.ApiUtils;
import com.eeeya.fantuan.server.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhonghui
 * @since 5/7/15.
 */
@Controller
public class TableViewController {

    @Autowired
    UserController userController;

    @Autowired
    TableController tableController;

    @Autowired
    RestaurantController restaurantController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView getIndexView(
            @RequestParam(required = false) String action,
            @RequestParam(required = false) Long tableId,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String argument
    ) throws ApiException {
        TableActionType tableActionType = TableActionType.loadByLabel(action);
        if (tableActionType == null) {
            tableActionType = TableActionType.SHOW_TABLE;
        }
        ResultModel<TableInfo> tableInfoResult;
        String viewPath;
        switch (tableActionType) {
            case SHOW_TABLE:
                viewPath = ApiViewPath.TABLE_VIEW;
                if(tableId == null) {
                    RestaurantParam restaurantParam = getRestaurantParam(userId, argument);
                    tableInfoResult = restaurantController.getRecommendTableInfo(restaurantParam.getUserLatitude(), restaurantParam.getUserLongitude());
                }
                else{
                    tableInfoResult = tableController.getTableInfo(tableId);
                }
                break;
            case ADD_TABLE:
                viewPath = ApiViewPath.TABLE_DETAIL_VIEW;
                tableInfoResult = tableController.addTable(tableId);
                break;
            case JOIN_TABLE:
                viewPath = ApiViewPath.TABLE_DETAIL_VIEW;
                tableInfoResult = tableController.joinTable(tableId);
                break;
            case CHANGE_TABLE:
                viewPath = ApiViewPath.TABLE_VIEW;
                tableInfoResult = tableController.changeTableByTableId(tableId);
                break;
            case CHANGE_RESTAURANT:
                viewPath = ApiViewPath.TABLE_VIEW;
                RestaurantParam restaurantParam = getRestaurantParam(userId, argument);

                tableInfoResult = restaurantController.changeRestaurantByTableId(
                        tableId,
                        restaurantParam.getIsFarther(),
                        restaurantParam.getUserLatitude(),
                        restaurantParam.getUserLongitude()
                );
                break;
            default:
                throw new ApiException(ApiError.BAD_REQUEST_ACTION, action);

        }
        return ApiUtils.getModelAndViewByResultModel(tableInfoResult, viewPath);
    }

    private RestaurantParam getRestaurantParam(Long userId, String argument) throws ApiException {
        RestaurantParam restaurantParam;
        if(argument != null) {
            restaurantParam = JsonUtils.readValue(argument, RestaurantParam.class);
            if (restaurantParam == null) {
                throw new ApiException(ApiError.BAD_REQUEST_ARGUMENT_NOT_MATCH_MODEL, argument, RestaurantParam.class);
            }
        }
        else {
            restaurantParam = new RestaurantParam();
        }

        if(restaurantParam.getUserLatitude() == null || restaurantParam.getUserLongitude() == null){
            ResultModel<CoordinatePosition> userPositionResult = userController.getUserCoordinatePosition(userId);
            if(userPositionResult.getStatus() == FantuanConfig.SUCCESS_STATUS_CODE){
                CoordinatePosition userPosition = userPositionResult.getData();
                restaurantParam.setUserLatitude(userPosition.getLatitudeValue());
                restaurantParam.setUserLongitude(userPosition.getLongitudeValue());
            }
        }
        return restaurantParam;
    }

}
