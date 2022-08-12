package com.sraapp.framework.exceptions;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.sraapp.common.enums.ApiResultEnum;
import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常
 *
 * @author jwss
 * @date 2022-2-7 02:52:00
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ApiResult<?> handlerException(Exception e) {
        logger.error("全局异常捕获，异常消息:" + e.getMessage());
        return ApiResult.error("系统异常，请联系管理员~");
    }

    @ExceptionHandler(NotLoginException.class)
    public ApiResult<?> handlerNotLoginException(NotLoginException e) {
        logger.error("登录失效异常:" + e.getMessage());
        return ApiResult.error(ApiResultEnum.NOT_LOGIN.getCode(), ApiResultEnum.NOT_LOGIN.getDesc());
    }

    @ExceptionHandler(NotPermissionException.class)
    public ApiResult<?> handlerNotPermissionException(NotPermissionException e) {
        logger.error("权限不足异常:" + e.getMessage());
        return ApiResult.error(ApiResultEnum.NOT_PERMISSION.getCode(), ApiResultEnum.NOT_PERMISSION.getDesc());
    }

    @ExceptionHandler(BusinessException.class)
    public ApiResult<?> handlerBusinessException(BusinessException e) {
        logger.error("业务逻辑异常: " + e.getMessage());
        return ApiResult.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(NotRoleException.class)
    public ApiResult<?> handlerNotRoleException(NotRoleException e) {
        logger.error("角色未知异常: " + e.getMessage());
        return ApiResult.error(ApiResultEnum.NOT_PERMISSION.getCode(), ApiResultEnum.NOT_PERMISSION.getDesc());
    }

}
