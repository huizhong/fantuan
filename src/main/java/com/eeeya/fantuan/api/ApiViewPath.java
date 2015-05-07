package com.eeeya.fantuan.api;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author zhonghui
 * @since 1/23/15.
 */
public class ApiViewPath {

    @ApiModelProperty("数据页，返回data属性数据")
    public static final String MODEL_VIEW = "fantuan/data";

    public static final String INDEX_VIEW = "fantuan/index";
}
