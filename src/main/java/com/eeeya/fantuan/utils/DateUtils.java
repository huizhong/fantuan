/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 *
 */
package com.eeeya.fantuan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private final static SimpleDateFormat HH_FORMAT = new SimpleDateFormat("HH");

    private final static SimpleDateFormat YYYYMMDD_FORMAT = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat YYMMDDHHMM_FORMAT = new SimpleDateFormat("yyMMddHHmm");
    private final static SimpleDateFormat YYMMDDHHMMSS_FORMAT = new SimpleDateFormat("yyMMddHHmmss");
    private final static SimpleDateFormat YYYY_MM_DD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat YYYY_MM_DD_HH_MM_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private final static SimpleDateFormat YYYY_MM_DD_HH_MM_SS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat M_D = new SimpleDateFormat("M.d");
    private final static long HALF_AN_HOUR = 30 * 60 * 1000;

    /**
     * yyyy-MM-dd HH:mm
     *
     * @param dateStr
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseMM(String dateStr) throws ParseException {
        return YYYY_MM_DD_HH_MM_FORMAT.parse(dateStr);
    }

    public static Date parseYYMMDDMM(String dateStr) throws ParseException {
        return YYMMDDHHMM_FORMAT.parse(dateStr);
    }

    /**
     * yyyy-MM-dd HH:mm
     *
     * @param date
     * @return
     */
    public static String formatMM(Date date) {
        return YYYY_MM_DD_HH_MM_FORMAT.format(date);
    }


    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseSS(String dateStr) throws ParseException {
        return YYYY_MM_DD_HH_MM_SS_FORMAT.parse(dateStr);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String formatSS(Date date) {
        return YYYY_MM_DD_HH_MM_SS_FORMAT.format(date);
    }

    public static String formatSS(Long timestamp) {
        return formatSS(new Date(timestamp));
    }

    public static String formatHH(Date date) {
        return HH_FORMAT.format(date);
    }

    /**
     * yyyy-MM-dd
     *
     * @param dateStr
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseDD(String dateStr) {
        try {
            return YYYY_MM_DD_FORMAT.parse(dateStr);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formatDD(Date date) {
        return YYYY_MM_DD_FORMAT.format(date);
    }

    public static String formatYYYYMMDD(Date date) {
        return YYYYMMDD_FORMAT.format(date);
    }

    public static String formatYYMMDDHHMM(Date date) {
        return YYMMDDHHMM_FORMAT.format(date);
    }

    public static String formatYYMMDDHHMMSS(Date date) {
        return YYMMDDHHMMSS_FORMAT.format(date);
    }

    /**
     * @param offsetDays 当前时间的偏移：-2前天，-1昨天，0今天，1明天，2后天
     * @return yyyy-MM-dd
     * @author yangxuehua
     */
    public static String getYYYY_MM_DD(int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        if (offsetDays != 0)
            calendar.add(Calendar.DATE, offsetDays);
        Date date = calendar.getTime();
        return formatDD(date);
    }

    public static long getTimeInNumber(int offsetDay) {
        return getTimeInDate(offsetDay).getTime();
    }

    public static Date getTimeInDate(int offsetDay) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, offsetDay);
        return cal.getTime();
    }

    public static long getTimeInNumber() {
        return getTimeInDate().getTime();
    }

    public static Date getTimeInDate() {
        return new Date();
    }

    /**
     * @param offsetDays 当前时间的偏移：-2前天，-1昨天，0今天，1明天，2后天
     * @return yyyyMMdd
     * @author yangxuehua
     */
    public static int getYYYYMMDD(int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        if (offsetDays != 0)
            calendar.add(Calendar.DATE, offsetDays);
        Date date = calendar.getTime();
        return Integer.parseInt(formatYYYYMMDD(date));
    }

    /**
     * @return yyyyMMddHHmm
     * @author yangxuehua
     */
    public static long getYYMMDDHHMM() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return Long.parseLong(formatYYMMDDHHMM(date));
    }

    /**
     * @return yyyyMMddHHmmss
     * @author yangxuehua
     */
    public static long getYYMMDDHHMMSS() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return Long.parseLong(formatYYMMDDHHMMSS(date));
    }

    /**
     * @param offsetDays 当前时间的偏移：-2前天，-1昨天，0今天，1明天，2后天
     * @return M.d or 明天(M.d)
     * @author yangxuehua
     */
    public static String getDisplayName(int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        if (offsetDays != 0)
            calendar.add(Calendar.DATE, offsetDays);
        Date date = calendar.getTime();
        String m_d = M_D.format(date);// e.g：5.2
        switch (offsetDays) {
            case -2:
                return "前天(" + m_d + ")";
            case -1:
                return "昨天(" + m_d + ")";
            case 0:
                return "今天(" + m_d + ")";
            case 1:
                return "明天(" + m_d + ")";
            case 2:
                return "后天(" + m_d + ")";
            default:
                return m_d;
        }
    }

    public static String getReadableTime(long modifiedTime) {
        long delay = getTimeInNumber() - modifiedTime;
        long delayMinutes = delay / (60 * 1000);
        if (delayMinutes < 1) {
            return "a few seconds ago";
        }
        long delayHours = delayMinutes / 60;
        if (delayHours < 1) {
            return delayMinutes + " minutes ago";
        }
        long delayDays = delayHours / 24;
        if (delayDays < 1) {
            return delayHours + " hours ago";
        }
        return delayDays + " days ago";
    }

    public static boolean inHalfAnHour(long ts) {
        long now = System.currentTimeMillis();
        return (now - ts) < HALF_AN_HOUR;
    }

}