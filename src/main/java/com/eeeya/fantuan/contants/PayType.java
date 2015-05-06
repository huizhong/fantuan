package com.eeeya.fantuan.contants;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PayType {
    AA((byte) 1, "AA"),
    ;

    private final Byte value;
    private final String name;

    PayType(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public static PayType load(Byte payTypeValue) {
        for (PayType payType : values()) {
            if (payType.getValue().equals(payTypeValue)) {
                return payType;
            }
        }
        return null;
    }

    public static List<PayType> getAllTypes() {
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
