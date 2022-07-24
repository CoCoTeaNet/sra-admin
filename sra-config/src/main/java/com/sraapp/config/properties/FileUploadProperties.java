package com.sraapp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 默认值配置项
 *
 * @author jwss
 * @date 2022-3-30 14:12:38
 */
@Component
@ConfigurationProperties(prefix = "sra.file-upload")
public class FileUploadProperties {
    /**
     * 本地位置
     */
    private String localUrl;

    /**
     * 浏览位置
     */
    private String browserUrl;

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public String getBrowserUrl() {
        return browserUrl;
    }

    public void setBrowserUrl(String browserUrl) {
        this.browserUrl = browserUrl;
    }
}
