package net.cocotea.bootstrap.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * satoken配置
 * @date 2022-1-17 16:33:35
 * @author jwss
 */
@Component
@ConfigurationProperties(prefix = "sra.sa-token")
public class SatokenProperties {
    /**
     * 路由放行
     */
    private List<String> excludes;

    public List<String> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }
}
