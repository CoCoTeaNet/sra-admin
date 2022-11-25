package net.cocotea.admin.common.util;

import net.cocotea.admin.common.constant.CharConstant;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 安全工具类
 *
 * @author jwss
 * @date 2022-3-30 16:21:21
 */
public class SecurityUtils {

    /**
     * 构建md5密码字符串
     *
     * @param pwd  密码
     * @param salt 盐
     * @return 密码字符串
     */
    public static String buildMd5Pwd(String pwd, String salt) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String str = pwd + CharConstant.COLON + salt;
            md5.update(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder buffer = new StringBuilder();
            for (byte b : md5.digest()) {
                buffer.append(String.format("%02x", b & 0xff));
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
