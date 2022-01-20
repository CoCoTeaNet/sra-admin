package com.jwss.common.enums;

/**
 * @date 2022-1-19 20:48:49
 * @author jwss
 */
public enum DeleteStatusEnum {
    /**
     * 删除
     */
    DELETE(0, "删除"),
    /**
     * 未删除
     */
    NOT_DELETE(1, "未删除"),
    ;
    Integer code;
    String desc;

    DeleteStatusEnum(Integer code, String desc) {
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
