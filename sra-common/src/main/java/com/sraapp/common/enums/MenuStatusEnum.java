package com.sraapp.common.enums;

/**
 * 菜单状态 枚举值
 *
 * @author jwss
 * @date 2022-4-2 14:16:05
 */
public enum MenuStatusEnum {
    /**
     * 显示&启用
     */
    SHOW_ENABLE(0, "显示&启用"),
    /**
     * 隐藏&启用
     */
    HIDE_ENABLE(1, "隐藏&启用"),
    /**
     * 显示&关闭
     */
    SHOW_CLOSE(2, "显示&关闭"),
    /**
     * 隐藏&关闭
     */
    HIDE_CLOSE(3, "隐藏&关闭");

    final Integer code;
    final String desc;

    MenuStatusEnum(Integer code, String desc) {
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
