package net.cocotea.admin.bootstrap.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @date 2022-9-13 14:33:34
 * @author CoCoTea
 */
@Component
public class AopProperties {
    /**
     * 1秒内限制api访问的次数
     */
    @Value("${sra.aop.visits}")
    private Integer visits;

    public Integer getVisits() {
        return visits;
    }

    public AopProperties setVisits(Integer visits) {
        this.visits = visits;
        return this;
    }
}
