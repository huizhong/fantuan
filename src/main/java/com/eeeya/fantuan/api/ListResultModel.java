package com.eeeya.fantuan.api;

import java.util.List;

/**
 * @author zhonghui
 * @since 1/17/15.
 */
@SuppressWarnings("UnusedDeclaration")
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
