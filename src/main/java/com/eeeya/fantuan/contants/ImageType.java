package com.eeeya.fantuan.contants;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhonghui
 * @since 1/15/15.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ImageType {
    NORMAL_IMG((byte) 0, "普通图片"),
    USER_LOGO((byte) 1, "用户LOGO"),
    TABLE_LOGO((byte) 2, "饭桌LOGO"),
    ;


    private final Byte value;
    private final String name;

    ImageType(Byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ImageType load(Byte imageTypeValue) {
        for (ImageType imageType : values()) {
            if (imageType.getValue().equals(imageTypeValue)) {
                return imageType;
            }
        }
        return null;
    }

    public static List<ImageType> getAllTypes() {
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
