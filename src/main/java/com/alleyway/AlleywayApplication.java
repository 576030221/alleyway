package com.alleyway;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableSwagger2 //使用/swagger-ui.html，进入文档地址，但是我用的是被封装过的，所以不需要
@SpringBootApplication
@MapperScan("com/alleyway/dao")
@EnableCaching    // 开启缓存
@EnableScheduling //开启基于注解的定时任务
@EnableAsync  //开启异步注解功能
@Import(FdfsClientConfig.class)// 引入fastDFS的配置文件
public class AlleywayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlleywayApplication.class, args);
    }

}
