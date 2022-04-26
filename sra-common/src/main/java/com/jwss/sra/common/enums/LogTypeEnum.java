package com.jwss.sra.common.enums;

/**
 * 操作类型;
 *
 * @author jwss
 * @date 2022-4-26 23:20:40
 */
public enum LogTypeEnum {
    /**
     * 0登录日志 1操作日志
     */
    LOGIN(0, "登录日志"),
    OPERATION(1, "操作日志");

    Integer code;
    String desc;

    LogTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return String.valueOf(code);
    }

    public String getDesc() {
        return desc;
    }
}
