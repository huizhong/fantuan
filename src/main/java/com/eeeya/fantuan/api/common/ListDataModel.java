package com.eeeya.fantuan.api.common;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Collections;
import java.util.List;

/**
 * @author zhonghui
 * @since 1/17/15.
 */
@SuppressWarnings("UnusedDeclaration")
@ApiModel(description = "能用列表返回结果数据")
public class ListDataModel<T> {

    public final static int PAGE = 1;
    public final static int SIZE = 10;

    @ApiModelProperty(value = "列表items总数，可能比items的数量大")
    private int total;

    @ApiModelProperty(value = "页号")
    private int page;

    @ApiModelProperty(value = "每页items个数")
    private int size;

    @ApiModelProperty(value = "请求的数据列表，个数可能比size小")
    private List<T> items;


    public ListDataModel() {
        this(null);
    }


    public ListDataModel(List<T> items) {
        if(items == null || items.isEmpty()){
            init(items, 0, PAGE, SIZE);
        }else{
            init(items, items.size(),PAGE,items.size());
        }

    }


    public ListDataModel(List<T> items, int total, int page, int size){
        init(items,total,page,size);
    }

    private void init(List<T> items, int total, int page, int size) {
        if (items == null || items.isEmpty()) {
            items = Collections.emptyList();
        }
        this.total = total;
        this.items = items;
        this.page = page;
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
