package com.jwss.sra.common.model;

import com.jwss.sra.common.enums.ApiResultEnum;
import com.jwss.sra.common.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回数据模型
 * @date 2022-1-12 16:21:52
 * @author jwss
 */
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = -4073679724104914374L;

    private Integer code;
    private T data;
    private String message;
    private Date time;

    public ApiResult(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.time = new Date();
    }

    /**
     * 根据布尔值判断成功通知还是失败通知
     * @param b 布尔值
     * @return 结果集
     */
    public static ApiResult<String> flag(Boolean b) {
        if (b) {
            return ok();
        } else {
            return error();
        }
    }

    /**
     * 成功通知结果
     * @param data 数据
     * @return 成功结果
     */
    public static<T> ApiResult<T> ok(T data) {
        return new ApiResult<>(ApiResultEnum.SUCCESS.getCode(), data, ApiResultEnum.SUCCESS.getDesc());
    }

    /**
     * 成功通知结果（无数据返回）
     * @return 成功结果
     */
    public static ApiResult<String> ok() {
        return new ApiResult<>(ApiResultEnum.SUCCESS.getCode(), StringUtils.EMPTY_STRING, ApiResultEnum.SUCCESS.getDesc());
    }

    /**
     * 失败通知结果（无数据返回）
     * @return 错误结果
     */
    public static ApiResult<String> error() {
        return new ApiResult<>(ApiResultEnum.ERROR.getCode(), StringUtils.EMPTY_STRING, ApiResultEnum.ERROR.getDesc());
    }

    /**
     * 失败通知结果
     * @param data 数据
     * @return 成功结果
     */
    public static<T> ApiResult<T> error(T data) {
        return error(data, ApiResultEnum.ERROR.getCode());
    }

    /**
     * 失败通知结果
     * @param data 数据
     * @return 成功结果
     */
    public static<T> ApiResult<T> error(T data, Integer errorCode) {
        return new ApiResult<>(errorCode, data, ApiResultEnum.SUCCESS.getDesc());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}