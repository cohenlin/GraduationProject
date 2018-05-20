package com.cohen.scheduletracking.utils;

import java.util.Date;

public class TimeUtils {

    /**
     * 获得两个日期的小时差
     * 
     * @return double类型的小时数
     */
    public static double getDifferenceOfHours(Date begin, Date end) {
        double result = 0;
        if (end.after(begin)) {
            result = (end.getTime() - begin.getTime()) / (1000 * 60 * 60);
        } else {
            result = 0;
        }

        return result;
    }
}
