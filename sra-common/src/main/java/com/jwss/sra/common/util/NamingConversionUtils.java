package com.jwss.sra.common.util;

import com.jwss.sra.common.constant.DataBaseTypeConstant;
import com.jwss.sra.common.constant.JavaTypeConstant;

import java.util.Locale;

/**
 * 命名转换工具类
 * 例：sys_user 转 sysUser
 *
 * @author jwss
 */
public class NamingConversionUtils {
    /**
     * 下划线命名转驼峰命名
     *
     * @param s 下划线命名字符串（例：sys_user）
     * @param type 0小驼峰 1大驼峰
     * @return 驼峰命名字符串
     */
    public static String underlineToHump(String s, Integer type) {
        if (s == null || StringUtils.EMPTY_STRING.equals(s)) {
            return null;
        }
        s = s.toLowerCase(Locale.ROOT);
        String[] strings = s.split(StringUtils.UNDERLINE);
        if (strings.length <= 1) {
            return s.toLowerCase(Locale.ROOT);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String s1 = strings[i];
            if (i != 0 && type == 0) {
                s1 = String.valueOf(s1.charAt(0)).toUpperCase(Locale.ROOT) + s1.substring(1);
            } else if(type == 1){
                s1 = String.valueOf(s1.charAt(0)).toUpperCase(Locale.ROOT) + s1.substring(1);
            }
            builder.append(s1);
        }
        return builder.toString();
    }

    /**
     * 数据库字段类型转java类型
     *
     * @param s 数据库数据类型
     * @return Java属性类型
     */
    public static String dbDataTypeToJava(String s) {
        if (s == null || StringUtils.EMPTY_STRING.equals(s)) {
            return null;
        }
        String upperCase = s.toUpperCase(Locale.ROOT);
        switch (upperCase) {
            case DataBaseTypeConstant.VARCHAR:
            case DataBaseTypeConstant.CHAR:
            case DataBaseTypeConstant.TEXT:
                return JavaTypeConstant.STRING;
            case DataBaseTypeConstant.BIGINT:
            case DataBaseTypeConstant.TIMESTAMP:
                return JavaTypeConstant.LONG;
            case DataBaseTypeConstant.INT:
                return JavaTypeConstant.INTEGER;
            case DataBaseTypeConstant.DATETIME:
                return JavaTypeConstant.LOCAL_DATETIME;
            default:
                return null;
        }
    }
}
