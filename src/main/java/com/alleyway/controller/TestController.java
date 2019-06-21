package com.alleyway.controller;

import com.alleyway.config.user_defined.FdfsConfig;
import com.alleyway.service.TimerService;
import com.alleyway.utils.FastDFSUtil;
import com.alleyway.utils.compressImg.CompressImgUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author linchenyu
 * @date 2019/5/13 -10:23
 */
@Api(tags = "自用_测试")
@Controller
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/up")
    public String index() {
        return "upload";
    }

    // ######################################################## 测试fastDFS ####################################################
    @Autowired
    private FastDFSUtil fileUtil;
    @Autowired
    private FdfsConfig fdfsConfig;

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        try {
            // 原图上传
            String path = fileUtil.uploadFile(file);
            System.out.println("需要存到数据库的地址为：" + path);   //   M00/00/00/wKgASlzk3kGAFVF7AABeEJ_iOs4683.png
            System.out.println("返回给客户端的地址为："+fdfsConfig.getWebServerUrl() + path);   //   http://122.112.213.121:88/files/M00/00/00/wKgASlzk3kGAFVF7AABeEJ_iOs4683.png

            // 压缩再上传
            MultipartFile multipartFiles = CompressImgUtils.compressMultipartFile(file);
            path = fileUtil.uploadFile(multipartFiles);
            System.out.println("压缩-需要存到数据库的地址为：" + path);   //   M00/00/00/wKgASlzk3kGAFVF7AABeEJ_iOs4683.png
            System.out.println("压缩-返回给客户端的地址为："+fdfsConfig.getWebServerUrl() + path);   //   http://122.112.213.121:88/files/M00/00/00/wKgASlzk3kGAFVF7AABeEJ_iOs4683.png

        } catch (Exception e) {
        }
        return "uploadStatus";
    }
// ######################################################## 测试redis ####################################################
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("redisTest")
    public String redisTest(){
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        return "upload";
    }

    @GetMapping("textSave")
    @ResponseBody
    public String savea(HttpServletResponse response){
        System.out.println("成功进入testSave方法");
        return "成功进入Svae方法";
    }

    @Autowired
    private TimerService timerService;

    @GetMapping("clearRedis")
    @ResponseBody
    public String clearRedis(){
        timerService.userOperationSizeRestore();
        return "成功";
    }



}
