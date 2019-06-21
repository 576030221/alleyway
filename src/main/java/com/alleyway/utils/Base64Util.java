package com.alleyway.utils;


import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Util {

    private static final Charset DEFAULT_CHARSET;

    public Base64Util() {
    }



    // 字节数组转base64.  使用基本型 base64 编码方案。
    public static String encodeToString(byte[] src) {
        return src.length == 0 ? "" : new String(encode(src), DEFAULT_CHARSET);
    }

    // base64转字节数组， 使用基本型 base64 解码方案。
    public static byte[] decodeFromString(String src) {
        return src.isEmpty() ? new byte[0] : decode(src.getBytes(DEFAULT_CHARSET));
    }

    // 字节数组转base64 ， 编码使用 URL 和文件名安全型 base64 编码方案。
    public static String encodeToUrlSafeString(byte[] src) {
        return new String(encodeUrlSafe(src), DEFAULT_CHARSET);
    }

    // base64转字节数组，  解码使用 URL 和文件名安全型 base64 编码方案。
    public static byte[] decodeFromUrlSafeString(String src) {
        return decodeUrlSafe(src.getBytes(DEFAULT_CHARSET));
    }


    // 编码使用基本型 base64 编码方案。
    public static byte[] encode(byte[] src) {
        return src.length == 0 ? src : Base64.getEncoder().encode(src);
    }

    // 解码使用基本型 base64 编码方案。
    public static byte[] decode(byte[] src) {
        return src.length == 0 ? src : Base64.getDecoder().decode(src);
    }

    // 编码使用 URL 和文件名安全型 base64 编码方案。
    public static byte[] encodeUrlSafe(byte[] src) {
        return src.length == 0 ? src : Base64.getUrlEncoder().encode(src);
    }

    // 解码使用 URL 和文件名安全型 base64 编码方案。
    public static byte[] decodeUrlSafe(byte[] src) {
        return src.length == 0 ? src : Base64.getUrlDecoder().decode(src);
    }

    static {
        DEFAULT_CHARSET = StandardCharsets.UTF_8;
    }



    public static byte[] Base64StrToPNG(String base64Str){
        if (base64Str == null) //图像数据为空
	  return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            base64Str = base64Str.replace("data:image/jpeg;base64,", "");
	  base64Str = base64Str.replace("data:image/png;base64,", "");
	  base64Str = base64Str.replaceAll(" ", "+");

	  //Base64解码
	  byte[] b = decoder.decodeBuffer(base64Str);
	  for(int i=0;i<b.length;++i)
	  {
	      if(b[i]<0)
	      {//调整异常数据
		b[i]+=256;
	      }
	  }
	  return b;
        }
        catch (Exception e)
        {
	  return null;
        }
    }
}
