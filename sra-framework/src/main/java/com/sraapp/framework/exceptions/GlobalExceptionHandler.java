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

    /**
     * 异常捕获
     *
     * @param e 捕获的异常
     * @return 封装的返回对象
     **/
    @ExceptionHandler(Exception.class)
    public ApiResult<String> handlerException(Exception e) {
        logger.error("全局异常捕获，异常消息:" + e.getMessage());
        if (e instanceof NotLoginException) {
            return ApiResult.error(ApiResultEnum.NOT_LOGIN.getCode(), ApiResultEnum.NOT_LOGIN.getDesc());
        } else if (e instanceof NotPermissionException) {
            return ApiResult.error(ApiResultEnum.NOT_PERMISSION.getCode(), ApiResultEnum.NOT_PERMISSION.getDesc());
        } else if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return ApiResult.error(businessException.getErrorCode(), businessException.getErrorMsg());
        } else if (e instanceof NotRoleException) {
            return ApiResult.error(ApiResultEnum.NOT_PERMISSION.getCode(), ApiResultEnum.NOT_PERMISSION.getDesc());
        }
        return ApiResult.error();
    }

}
