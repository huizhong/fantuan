package com.eeeya.fantuan.utils;


import com.eeeya.fantuan.api.ApiViewPath;
import com.eeeya.fantuan.api.ResultModel;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhonghui
 * @since 1/27/15.
 */
public class ApiUtils {
    public static ModelAndView getModelAndViewByResultModel(ResultModel result, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("data", result.getData());
        return mav;
    }
}
