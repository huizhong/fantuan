package com.eeeya.fantuan.controller.view;

import com.eeeya.fantuan.api.ApiViewPath;
import com.eeeya.fantuan.controller.api.TableController;
import com.eeeya.fantuan.utils.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhonghui
 * @since 5/7/15.
 */
@Controller
public class IndexView {

    @Autowired
    TableController tableController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView getIndex(){
        return ApiUtils.getModelAndViewByResultModel(tableController.getRecommendTableInfo(), ApiViewPath.INDEX_VIEW );
    }

}
