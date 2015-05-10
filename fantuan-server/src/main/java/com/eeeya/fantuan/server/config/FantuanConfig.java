package com.eeeya.fantuan.server.config;

import com.eeeya.fantuan.server.contants.ImageType;
import com.eeeya.fantuan.server.contants.MealType;
import com.eeeya.fantuan.server.contants.PayType;
import com.eeeya.fantuan.server.contants.TableType;
import com.eeeya.fantuan.server.utils.DateUtils;

/**
 * @author zhonghui
 * @since 3/24/15.
 */
public class FantuanConfig {

    public static final boolean PRINT_EXCEPTION_IN_ERROR = true;
    public static final int SUCCESS_STATUS_CODE = 0;
    public static final String ERROR_REDIRECT_URL = "/error/404";
    public static final String URL_PREFIX = "";

    public static final Long DEFAULT_TABLE_ID = 1L;
    public static final Integer DEFAULT_TABLE_INDEX = 1;

    public static final Integer DEFAULT_PRICE_VALUE = 30;
    public static final String DEFAULT_PRICE_UNIT = "元/位";

    public static final PayType DEFAULT_PAY_TYPE = PayType.AA;

    public static final ImageType DEFAULT_IMAGE_TYPE = ImageType.NORMAL_IMG;
    public static final String DEFAULT_IMG_URL = "http://t.meituan.com/qrc/s?c=0";

    public static final Long DEFAULT_RESTAURANT_ID = 1001L;
    public static final String DEFAULT_RESTAURANT_SHORT_NAME = "百万庄园";
    public static final String DEFAULT_RESTAURANT_FULL_NAME = "百万庄园（知春路一店）";
    public static final Integer DEFAULT_RESTAURANT_MAX_TABLE = 10;
    public static final String DEFAULT_RESTAURANT_PHONE = "10086";
    public static final String DEFAULT_RESTAURANT_LOCATION = "知春路63号卫星大夏1层";

    public static final Double DEFAULT_COORDINATE_POSITION_LATITUDE_VALUE = 39.977047526042;
    public static final Double DEFAULT_COORDINATE_POSITION_LONGITUDE_VALUE = 116.33045057509;
    
    public static final Long DEFAULT_USER_ID = 101L;
    public static final String DEFAULT_USER_NAME = "小灰灰";
    
    public static final Long DEFAULT_FOOD_ID = 10001L;
    public static final String DEFAULT_FOOD_NAME = "烤鱼";
    public static final Integer DEFAULT_FOOD_PRICE = 30;
    public static final String DEFAULT_TABLE_STATUS_TITLE = "%d缺%d, 召唤小伙伴";
    public static final Boolean DEFAULT_TABLE_HAS_NEW_MESSAGE = true;
    public static final TableType DEFAULT_TABLE_TYPE = TableType.SIZE_4;
    public static final MealType DEFAULT_MEAL_TYPE = MealType.MEAL_NOON;
    public static final String DEFAULT_USER_PHONE = "10086";
    public static final Integer DEFAULT_TALK_GROUP_ID = 1;
    public static final String TABLE_AVERAGE_PRICE_UNIT = "元/位";
    public static final Long DEFAULT_LAST_UPDATE_TIME = DateUtils.parseDD("2015-05-10").getTime();
}
