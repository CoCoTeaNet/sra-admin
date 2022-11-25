package net.cocotea.admin.common.enums;

/**
 * @date 2022-1-19 20:48:49
 * @author jwss
 */
public enum DeleteStatusEnum {
    /**
     * 删除
     */
    DELETE(0, "已删除"),
    /**
     * 未删除
     */
    NOT_DELETE(1, "未删除"),
    ;
    final Integer code;
    final String desc;

    DeleteStatusEnum(Integer code, String desc) {
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
