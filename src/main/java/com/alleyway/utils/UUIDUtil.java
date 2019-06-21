package com.alleyway.utils;

import java.util.UUID;
public class UUIDUtil {

    /**
     * 获取完整UUID
     * @return
     */
    public static String getUUID(){
        // 获取UUID
        String uuid = UUID.randomUUID().toString();
        // 清除其中的到‘-’符号
        uuid = uuid.replace("-","");
        return uuid;
    }

    /**
     * 获取前6位的UUID
     * @return
     */
    public static String getUUIDLimitSix(){
        String uuid = getUUID();
        return uuid.substring(0,6);
    }

    /**
     * 获取前4位的UUID
     * @return
     */
    public static String getUUIDLimitFour(){
        String uuid = getUUID();
        return uuid.substring(0,4);
    }

    /**
     * 获取前x位的UUID
     * @return
     */
    public static String getUUIDLimit(int index){
        String uuid = getUUID();
        return uuid.substring(0,index);
    }
}
