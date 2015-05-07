package com.eeeya.fantuan.contants;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/7/15.
 */
public enum TableType {
    SIZE_4((byte) 4, "四人拼桌"),
    ;


    @ApiModelProperty("餐桌能坐多少人")
    private final Byte value;

    @ApiModelProperty("餐桌型号名称")
    private final String label;

    TableType(Byte value, String label) {
        this.value = value;
        this.label = label;
    }

    public static TableType load(Byte tableTypeValue) {
        for (TableType tableType : values()) {
            if (tableType.getValue().equals(tableTypeValue)) {
                return tableType;
            }
        }
        return null;
    }

    public static List<TableType> getAllTypes() {
        return Arrays.asList(values());
    }

    @Override
    public String toString() {
        return label;
    }

    public Byte getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
