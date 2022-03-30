package com.jwss.sra.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 开发模式功能启用配置项
 *
 * @author jwss
 * @date 2022-3-30 14:12:38
 */
@Component
@ConfigurationProperties(prefix = "sra.dev-enable")
public class DevEnableProperties {
    /**
     * 是否开启权限缓存: true开启，false关闭
     */
    private Boolean permissionCache;

    /**
     * 强密码：启用后会关闭图片验证码验证
     */
    private String strongPassword;

    public Boolean getPermissionCache() {
        return permissionCache;
    }

    public void setPermissionCache(Boolean permissionCache) {
        this.permissionCache = permissionCache;
    }

    public String getStrongPassword() {
        return strongPassword;
    }

    public void setStrongPassword(String strongPassword) {
        this.strongPassword = strongPassword;
    }
}
