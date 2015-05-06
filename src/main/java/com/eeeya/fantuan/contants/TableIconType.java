package com.eeeya.fantuan.contants;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TableIconType {

    NOT_FULL((byte) 1, "拼桌中"),
    FULL((byte) 2, "已完成"),
    ;

    private final Byte value;
    private final String name;

    TableIconType(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public static TableIconType load(Byte tableStatusTypeValue) {
        for (TableIconType tableIconType : values()) {
            if (tableIconType.getValue().equals(tableStatusTypeValue)) {
                return tableIconType;
            }
        }
        return null;
    }

    public static List<TableIconType> getAllTypes() {
        return Arrays.asList(values());
    }

    @Override
    public String toString() {
        return name;
    }

    public Byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
