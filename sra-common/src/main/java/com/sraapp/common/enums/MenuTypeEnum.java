package com.sraapp.common.enums;

/**
 * @date 2022-1-12 16:30:04
 * @author jwss
 */
public enum MenuTypeEnum {
    /**
     * 菜单
     */
    MENU(0, "菜单"),
    /**
     * 权限
     */
    PERMISSION(1, "权限");

    final Integer code;
    final String desc;

    MenuTypeEnum(Integer code, String desc) {
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
