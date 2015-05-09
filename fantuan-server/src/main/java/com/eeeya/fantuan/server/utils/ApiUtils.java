package com.eeeya.fantuan.server.utils;


import com.eeeya.fantuan.server.api.common.ResultModel;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhonghui
 * @since 1/27/15.
 */
public class ApiUtils {
    public static ModelAndView getModelAndViewByResultModel(ResultModel result, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("data", result.getData());
        mav.addObject("time", result.getTime());
        return mav;
    }
}
