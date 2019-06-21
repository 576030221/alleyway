package com.alleyway.utils.compressImg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 公共 工具类
 * Created by zxy on 18/11/15.
 */
public class ToolsUtil {

    /**
     * InputStream转换为byte[]
     *
     * @param inStream
     * @return
     * @throws IOException
     */
    public static final byte[] getByteArray(InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
	  swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }


}