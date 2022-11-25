package net.cocotea.admin.common.enums;

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
    WOMAN(2, "女");

    final Integer code;
    final String desc;

    SexEnum(Integer code, String desc) {
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
