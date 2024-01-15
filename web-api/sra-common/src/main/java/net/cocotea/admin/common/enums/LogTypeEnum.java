package net.cocotea.admin.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 操作类型枚举值
 *
 * @author CoCoTea
 * @version v2.0.0
 */
@Getter
@AllArgsConstructor
public enum LogTypeEnum {
    /**
     * 0登录日志 1操作日志
     */
    LOGIN(0, "登录日志"),
    OPERATION(1, "操作日志");

    final Integer code;
    final String desc;
}
