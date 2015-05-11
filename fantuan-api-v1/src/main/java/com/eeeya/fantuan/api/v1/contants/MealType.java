package com.eeeya.fantuan.api.v1.contants;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public enum MealType {

    MEAL_NOON((byte) 1, "午餐"),

    ;

    private final Byte value;
    private final String label;

    MealType(Byte value, String label) {
        this.value = value;
        this.label = label;
    }

    public static MealType load(Byte mealTypeValue) {
        for (MealType mealType : values()) {
            if (mealType.getValue().equals(mealTypeValue)) {
                return mealType;
            }
        }
        return null;
    }

    public static MealType loadByLabel(String mealTypeLabel) {
        for (MealType mealType : values()) {
            if (mealType.getLabel().equals(mealTypeLabel)) {
                return mealType;
            }
        }
        return null;
    }

    public static List<MealType> getAllTypes() {
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
