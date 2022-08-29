package com.sraapp.common.enums;

/**
 * @date 2022-1-26 10:51:23
 * @author jwss
 */
public enum IsSomethingEnum {
    /**
     * 是
     */
    YSE(0, "是"),
    /**
     * 否
     */
    NO(1, "否");

    final Integer code;
    final String desc;

    IsSomethingEnum(Integer code, String desc) {
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
