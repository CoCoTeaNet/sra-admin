package net.cocotea.admin.util;

import cn.hutool.crypto.SmUtil;
import jakarta.annotation.Resource;
import net.cocotea.admin.properties.DefaultProp;
import org.springframework.stereotype.Component;

/**
 * 安全工具类
 *
 * @author CoCoTea
 * @date 2022-3-30 16:21:21
 */
@Component
public class SecurityUtils {

    @Resource
    private DefaultProp defaultProp;

    /**
     * 获取密码密文
     *
     * @param password 原始密码
     * @return 密文
     */
    public String getPwd(String password) {
        return SmUtil
                .sm3WithSalt(defaultProp.getPasswordSalt().getBytes())
                .digestHex(password)
                .toUpperCase();
    }

}
