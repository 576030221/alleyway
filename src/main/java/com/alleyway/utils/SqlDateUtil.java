package com.alleyway.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 用于转化为数据库的时间类型
 */
public class SqlDateUtil {

    /**
     * 获取当前日期的字符串，带 时分秒
     * @return
     */
    public static String nowDataTimeToString(){
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        return df.format(new java.util.Date());
    }

    /**
     * 获取当前日期的字符串，不带 时分秒
     * @return
     */
    public static String nowDataToString(){
        return nowDataTimeToString().substring(0,10);
    }

    /**
     * 将字符串格式的时间转化为数据库的Date类型
     * @param dateString 2000-01-01 格式的时间字符串
     * @return
     */
    public static Date stringToSqlDate(String dateString){
        int dateStringLength = dateString.length();
        if (dateStringLength > 10) {
            dateString = dateString.substring(0,10);
        }
        Date date = Date.valueOf(dateString);
        return date;
    }
    /**
     * 将当前时间转化为数据库的时间类型 date 与 datetime 均可
     * @return
     */
    public static Timestamp nowToDate(){
        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        return timestamp;
    }

}
