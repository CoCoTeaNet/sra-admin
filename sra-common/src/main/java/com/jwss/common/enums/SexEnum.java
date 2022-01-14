package com.jwss.common.enums;

/**
 * @date 2022-1-12 16:30:04
 * @author jwss
 */
public enum SexEnum {
    /**
     * 未知
     */
    UNKNOWN(0, "未知"),
    /**
     * 男
     */
    MAN(1, "男"),
    /**
     * 女
     */
    WOMAN(1, "女");

    Integer code;
    String desc;

    SexEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
