package com.alleyway.utils;

import sun.security.provider.MD5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

public class MD5Util {
    /**
     * 将字符串转化为MD5
     * @param string 需要加密的字符串
     * @return
     */
    public final static String getMD5(String string) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = string.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断普通字符串加密后，是否与加密值相等
     * @param strFrom 普通字符串
     * @param strTo 加密值
     * @return
     */
    public static boolean equalsTo(String strFrom,String strTo){
        if(strTo.equals(getMD5(strFrom))){
            return true;
        }else{
            return false;
        }
    }





    /**
     * 获取文件的MD5码
     * @param filePath 文件的绝对路径
     * @return
     */
    public static String getFileMD5(String filePath){
        File file = new File(filePath);
        if(file.exists()){
            return getFileMD5(file);
        }else{
            throw new RuntimeException("该文件不存在");
        }
    }

    /**
     * 获取MD5码
     * @param file 文件，已经new好的文件
     * @return
     */
    public static String getFileMD5(File file){
        String value = null;
        FileInputStream in=null;
        try {
            in = new FileInputStream(file);
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(in !=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

}
