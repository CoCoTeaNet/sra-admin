package net.cocotea.admin.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 默认值配置项
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@Data
@Component
public class DefaultProp {

    /**
     * 默认密码
     */
    @Value("${sra-admin.password}")
    private String password;

    /**
     * 密码加密的盐
     */
    @Value("${sra-admin.password-salt}")
    private String passwordSalt;

    /**
     * 1秒内限制api访问的次数
     */
    @Value("${sra-admin.once-visits}")
    private Integer onceVisits;

    /**
     * 是否开启权限缓存: true开启，false关闭
     */
    @Value("${sra-admin.permission-cache}")
    private Boolean permissionCache;

    /**
     * 是否开启系统日志保存功能
     */
    @Value("${sra-admin.save-log}")
    private Boolean saveLog;

    /**
     * 强密码：启用后会关闭图片验证码验证
     */
    @Value("${sra-admin.strong-password}")
    private String strongPassword;

    /**
     * 路由放行地址
     */
    @Value("${sra-admin.excludes}")
    private String excludes;

}
