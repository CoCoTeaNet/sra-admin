package com.sraapp.common.enums;

/**
 * 常用枚举之是否枚举
 *
 * @date 2022-1-26 10:51:23
 * @author jwss
 */
public enum IsSomethingEnum {
    /**
     * 是
     */
    N(0, "否"),
    /**
     * 否
     */
    Y(1, "是");

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
