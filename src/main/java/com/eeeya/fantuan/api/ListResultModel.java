package com.eeeya.fantuan.api;

import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author zhonghui
 * @since 1/17/15.
 */
@SuppressWarnings("UnusedDeclaration")
@ApiModel("通用列表返回结果")
public class ListResultModel<T> extends ResultModel<ListDataModel<T>> {
    public ListResultModel() {
        this((List<T>) null);
    }

    public ListResultModel(ListDataModel<T> data) {
        super(data);
    }

    public ListResultModel(List<T> items) {
        this(new ListDataModel<T>(items));
    }

}
