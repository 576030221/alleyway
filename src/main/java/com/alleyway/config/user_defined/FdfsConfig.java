package com.alleyway.config.user_defined;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FdfsConfig {
    // nginx 访问ip
    @Value("${fdfs.resHost}")
    private String resHost;

    // nginx 访问端口
    @Value("${fdfs.storagePort}")
    private String storagePort;

    // 文件服务器地址/ 组名
    @Value("${fdfs.webServerUrl}")
    private String webServerUrl;


    public String getWebServerUrl() {
        return webServerUrl;
    }

    public void setWebServerUrl(String webServerUrl) {
        this.webServerUrl = webServerUrl;
    }

    public String getResHost() {
        return resHost;
    }

    public void setResHost(String resHost) {
        this.resHost = resHost;
    }

    public String getStoragePort() {
        return storagePort;
    }

    public void setStoragePort(String storagePort) {
        this.storagePort = storagePort;
    }

}