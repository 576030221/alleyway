package com.alleyway.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

import javax.servlet.MultipartConfigElement;

@Configuration
@EnableMBeanExport(registration=RegistrationPolicy.IGNORE_EXISTING)
public class FdfsConfiguration {
    // 解决文件上传的最大限制
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件最大
        factory.setMaxFileSize("30000KB");
        // 设置总上传大小
        factory.setMaxRequestSize("10000000KB");
        return factory.createMultipartConfig();
    }
}