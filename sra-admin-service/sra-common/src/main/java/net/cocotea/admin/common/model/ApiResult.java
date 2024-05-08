package net.cocotea.admin.common.model;

import lombok.Data;
import lombok.experimental.Accessors;
import net.cocotea.admin.common.enums.ApiResultEnum;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 返回数据模型
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@Data
@Accessors(chain = true)
public class ApiResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -4073679724104914374L;

    /**
     * 接口响应编号：{@link ApiResultEnum}
     */
    private Integer code;

    /**
     * 接口返回数据
     */
    private T data;

    /**
     * 接口提示信息
     */
    private String message;

    /**
     * 接口返回时间
     */
    private LocalDateTime time;

    public ApiResult(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.time = LocalDateTime.now();
    }

    /**
     * 根据布尔值判断成功通知还是失败通知
     *
     * @param b 布尔值
     * @return 结果集
     */
    public static ApiResult<?> flag(Boolean b) {
        if (b) {
            return ok();
        } else {
            return error();
        }
    }

    /**
     * 成功通知结果
     *
     * @param data 数据
     * @return 成功结果
     */
    public static <T> ApiResult<T> ok(T data) {
        return new ApiResult<>(ApiResultEnum.SUCCESS.getCode(), data, ApiResultEnum.SUCCESS.getDesc());
    }

    /**
     * 成功通知结果（无数据返回）
     *
     * @return 成功结果
     */
    public static ApiResult<?> ok() {
        return new ApiResult<>(ApiResultEnum.SUCCESS.getCode(), null, ApiResultEnum.SUCCESS.getDesc());
    }

    /**
     * 失败通知结果（无数据返回）
     *
     * @return 错误结果
     */
    public static ApiResult<?> error() {
        return new ApiResult<>(ApiResultEnum.ERROR.getCode(), null, ApiResultEnum.ERROR.getDesc());
    }

    /**
     * 失败通知结果
     *
     * @param data 数据
     * @return 成功结果
     */
    public static <T> ApiResult<T> error(T data) {
        return error(data, ApiResultEnum.ERROR.getCode());
    }

    /**
     * 失败通知结果
     *
     * @param data    通知数据
     * @param message 通知消息
     * @return 成功结果
     */
    public static <T> ApiResult<T> error(T data, String message) {
        return new ApiResult<>(ApiResultEnum.ERROR.getCode(), data, message);
    }

    /**
     * 失败通知结果
     *
     * @param message 通知消息
     * @return 成功结果
     */
    public static ApiResult<?> error(String message) {
        return error(ApiResultEnum.ERROR, message);
    }

    /**
     * 失败通知结果
     *
     * @param errorCode 错误码
     * @param message   通知消息
     * @return 成功结果
     */
    public static ApiResult<?> error(Integer errorCode, String message) {
        return new ApiResult<>(errorCode, null, message);
    }

    /**
     * 失败通知结果
     *
     * @param data 数据
     * @return 成功结果
     */
    public static <T> ApiResult<T> error(T data, Integer errorCode) {
        return new ApiResult<>(errorCode, data, ApiResultEnum.SUCCESS.getDesc());
    }

    public static ApiResult<?> error(ApiResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getDesc());
    }
}