package com.eeeya.fantuan.server.contants;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public enum TableActionType {

    SHOW_TABLE((byte) 1, "showTable"),
    CHANGE_TABLE((byte) 2, "changeTable"),
    ADD_TABLE((byte) 3, "addTable"),
    JOIN_TABLE((byte) 4, "joinTable"),
    CHANGE_RESTAURANT((byte) 5, "changeRestaurant"),
    USER_START((byte) 6, "userStart"),
    USER_VOTE((byte)7, "userVote")
    ;

    private final Byte value;
    private final String label;

    TableActionType(Byte value, String label) {
        this.value = value;
        this.label = label;
    }

    public static TableActionType load(Byte tableActionTypeValue) {
        for (TableActionType tableActionType : values()) {
            if (tableActionType.getValue().equals(tableActionTypeValue)) {
                return tableActionType;
            }
        }
        return null;
    }

    public static TableActionType loadByLabel(String tableActionTypeLabel) {
        for (TableActionType tableActionType : values()) {
            if (tableActionType.getLabel().equals(tableActionTypeLabel)) {
                return tableActionType;
            }
        }
        return null;
    }

    public static List<TableActionType> getAllTypes() {
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
