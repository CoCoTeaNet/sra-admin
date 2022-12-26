package net.cocotea.admin.common.enums;

/**
 * 操作状态 枚举类
 *
 * @date 2022-5-1 23:05:27
 * @author jwss
 */
public enum OperationStatusEnum {
    /**
     * 0异常 1成功
     */
    ERROR(0, "异常"),
    SUCCESS(1, "成功");

    final Integer code;
    final String desc;

    OperationStatusEnum(Integer code, String desc) {
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
