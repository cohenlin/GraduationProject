package com.cohen.scheduletracking.common;

import java.util.Calendar;

/**
 * 字符串工具类
 * 
 * @author 林金成
 *         2018年4月6日
 */
public class StringUtils {

    public static String addDateToString(String str) {
        Calendar calendar = Calendar.getInstance();
        str += "_";
        str += calendar.get(Calendar.YEAR);
        str += calendar.get(Calendar.MONTH) + 1;
        str += (calendar.get(Calendar.DAY_OF_MONTH));
        str += calendar.get(Calendar.HOUR_OF_DAY);
        str += calendar.get(Calendar.MINUTE);
        str += calendar.get(Calendar.SECOND);

        return str;
    }

    /**
     * @return 2018-4-6 22:48:15
     */
    public static String getDateWithLocaleString() {
        StringBuilder str = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        str.append(calendar.get(Calendar.YEAR));
        str.append("-");
        str.append(calendar.get(Calendar.MONTH) + 1);
        str.append("-");
        str.append(calendar.get(Calendar.DAY_OF_MONTH));
        str.append(" ");
        str.append(calendar.get(Calendar.HOUR_OF_DAY));
        str.append(":");
        str.append(calendar.get(Calendar.MINUTE));
        str.append(":");
        str.append(calendar.get(Calendar.SECOND));

        return str.toString();
    }

    /**
     * @return 2018-4-6-22-48-15
     */
    public static String getDateWithCommonString() {
        StringBuilder str = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        str.append(calendar.get(Calendar.YEAR));
        str.append("_");
        str.append(calendar.get(Calendar.MONTH) + 1);
        str.append("_");
        str.append(calendar.get(Calendar.DAY_OF_MONTH));
        str.append("_");
        str.append(calendar.get(Calendar.HOUR_OF_DAY));
        str.append("_");
        str.append(calendar.get(Calendar.MINUTE));
        str.append("_");
        str.append(calendar.get(Calendar.SECOND));

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.getDateWithCommonString());
    }
}
