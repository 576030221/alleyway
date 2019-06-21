package com.alleyway.utils.compressImg;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 获取图片尺寸和截图 工具类
 *
 * @author zhangxiaoyan
 */
public class CompressImgUtils {

    private final static Logger logger = LoggerFactory.getLogger(CompressImgUtils.class);


    /**
     * 压缩MultipartFile文件，一般只压缩图片,单个
     * @return
     */
    public static MultipartFile compressMultipartFile(MultipartFile fileImg){
        MultipartFile result = fileImg;
        BASE64Encoder encoder = new BASE64Encoder();
        String imgData1 = null;
        try {
            InputStream inputStream = fileImg.getInputStream();
            byte[] imgData = CompressImgUtils.compressPicForScale(ToolsUtil.getByteArray(inputStream),2000);
            imgData1 = "data:"+fileImg.getContentType()+";base64,"+encoder.encode(imgData);
            MultipartFile def = CompressImgUtils.base64ToMultipart(imgData1);
            result = def;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 压缩多个MultipartFile图片
     * @param fileImgs
     * @return
     */
    public static MultipartFile[] compressMultipartFile(MultipartFile[] fileImgs){
        int size = fileImgs.length;
        MultipartFile[] multipartFile = new MultipartFile[size];
        for(int i=0;i<size;i++){
            MultipartFile multipartFile1 = compressMultipartFile(fileImgs[i]);
            multipartFile[i] = multipartFile1;
        }
        return multipartFile;
    }




















    /**
     * 根据指定大小压缩图片
     *
     * @param imageBytes  源图片字节数组
     * @param desFileSize 指定图片大小，单位kb
     * @return 压缩质量后的图片字节数组
     */
    public static byte[] compressPicForScale(byte[] imageBytes, long desFileSize) {
        long srcSize = imageBytes.length;
        // 获取图片长宽应该压缩到多大
        double accuracy = getAccuracy(srcSize / 1024);
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageBytes.length);
            Thumbnails.of(inputStream)
                    .scale(1)    // 图片的长宽比例
                    .outputQuality(accuracy)    // 图片的质量比例
                    .toOutputStream(outputStream);
            imageBytes = outputStream.toByteArray();
        } catch (Exception e) {
        }
        return imageBytes;
    }

    /**
     * 自动调节精度(经验数值)
     *
     * @param size 源图片大小，单位kb
     * @return 图片压缩质量比
     */
    private static double getAccuracy(long size) {
        double accuracy;
        if (size < 1024) {
            accuracy = 0.5;
        } else if (size < 2047) {
            accuracy = 0.4;
        } else if (size < 3275) {
            accuracy = 0.2;
        } else {
            accuracy = 0.2;
        }
        return accuracy;
    }

    /**
     * 获取图片格式
     * @param params
     * @return
     */
    public static String getSuffixNameInfo(MultipartFile params){
        String result = "";
        // 图片后缀
        String suffixName = params.getOriginalFilename().substring(
                params.getOriginalFilename().lastIndexOf("."));
        if(suffixName.indexOf("png")>0){
            result = "png";
        }else if(suffixName.indexOf("jpg")>0){
            result = "jpg";
        }else if(suffixName.indexOf("jpeg")>0){
            result = "jpeg";
        }

        return result;
    }


    /**
     * base64 转MultipartFile
     * @param base64
     * @return
     */
    public static MultipartFile base64ToMultipart(String base64) {
        try {
            // 注意base64是否有头信息，如：data:image/jpeg;base64,。。。
            String[] baseStrs = base64.split(",");

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(baseStrs[1]);

            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            return new BASE64DecodedMultipartFile(b, baseStrs[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }







}