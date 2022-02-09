package com.jwss.sra.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 包扫描
 * @date 2022-2-9 11:19:47
 * @author jwss
 */
@Component
@ConfigurationProperties(prefix = "sra.package-scan")
public class PackageScanProperties {
    /**
     * 包列表
     */
    private String swaggerPackages;

    public String getSwaggerPackages() {
        return swaggerPackages;
    }

    public void setSwaggerPackages(String swaggerPackages) {
        this.swaggerPackages = swaggerPackages;
    }
}
