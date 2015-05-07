package com.eeeya.fantuan.controller.view;

import com.eeeya.fantuan.api.ApiError;
import com.eeeya.fantuan.api.ApiViewPath;
import com.eeeya.fantuan.api.ResultModel;
import com.eeeya.fantuan.contants.TableActionType;
import com.eeeya.fantuan.controller.api.RestaurantController;
import com.eeeya.fantuan.controller.api.TableController;
import com.eeeya.fantuan.exception.ApiException;
import com.eeeya.fantuan.model.table.TableInfo;
import com.eeeya.fantuan.param.RestaurantChangeParam;
import com.eeeya.fantuan.utils.ApiUtils;
import com.eeeya.fantuan.utils.JsonUtils;
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
    TableController tableController;

    @Autowired
    RestaurantController restaurantController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView getIndexView(
            @RequestParam(required = false) String action,
            @RequestParam(required = false) Long tableId,
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
                    tableInfoResult = tableController.getRecommendTableInfo();
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
                RestaurantChangeParam restaurantChangeParam = JsonUtils.readValue(argument, RestaurantChangeParam.class);
                if (restaurantChangeParam == null) {
                    throw new ApiException(ApiError.BAD_REQUEST_ARGUMENT_NOT_MATCH_MODEL, argument, RestaurantChangeParam.class);
                }
                tableInfoResult = restaurantController.changeRestaurantByTableId(
                        tableId,
                        restaurantChangeParam.getIsFarther(),
                        restaurantChangeParam.getUserLatitude(),
                        restaurantChangeParam.getUserLongitude()
                );
                break;
            default:
                throw new ApiException(ApiError.BAD_REQUEST_ACTION, action);

        }
        return ApiUtils.getModelAndViewByResultModel(tableInfoResult, viewPath);
    }

}
