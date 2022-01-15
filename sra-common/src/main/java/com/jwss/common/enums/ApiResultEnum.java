package com.jwss.common.enums;

/**
 * @date 2022-1-12 16:30:04
 * @author jwss
 */
public enum ApiResultEnum {
    /**
     * 成功
     */
    SUCCESS(200, "请求成功"),
    /**
     * 内部错误
     */
    ERROR(500, "内部错误"),
    /**
     * 未找到资源
     */
    NOT_FOUNT(404, "未找到资源"),
    /**
     * 拒绝请求
     */
    REFUSE(401, "拒绝请求"),
    /**
     * 未登录
     */
    NOT_LOGIN(4001, "未登录"),
    ;
    Integer code;
    String desc;

    ApiResultEnum(Integer code, String desc) {
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
