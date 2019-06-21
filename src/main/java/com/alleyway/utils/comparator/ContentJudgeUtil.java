package com.alleyway.utils.comparator;

import java.util.regex.Pattern;

/**
 * describe: 内容判断
 *
 * 1.判断是否为手机号
 *
 * @author: 洪
 */
public class ContentJudgeUtil {


    // 判断是否为手机号的正则
    public final static String PHONE_PATTERN="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17([0,1,6,7,]))|(18[0-2,5-9]))\\d{8}$";
    /**
     * 判断是否为手机号
     * @param number 号码
     * @return
     */
    public static boolean isPhoneNumber(String number) {
        return Pattern.compile(PHONE_PATTERN).matcher(number).matches();
    }
}
