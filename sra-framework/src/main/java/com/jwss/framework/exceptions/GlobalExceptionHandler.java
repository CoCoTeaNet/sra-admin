package com.jwss.framework.exceptions;

import cn.dev33.satoken.exception.NotLoginException;
import com.jwss.common.enums.ApiResultEnum;
import com.jwss.common.model.ApiResult;
import com.jwss.common.model.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常
 *
 * @author jwss
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
        logger.error("error :" + e);
        if (e instanceof NotLoginException) {
            return ApiResult.error(ApiResultEnum.NOT_LOGIN.getDesc(), ApiResultEnum.NOT_LOGIN.getCode());
        } else if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return ApiResult.error(businessException.getErrorMsg(), businessException.getErrorCode());
        }
        return ApiResult.error();
    }

}
