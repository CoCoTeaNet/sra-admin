package com.sraapp.system.service;

import com.sraapp.common.enums.LogTypeEnum;
import com.sraapp.common.model.BusinessException;
import com.sraapp.common.service.IBaseService;
import com.sraapp.system.param.log.OperationLogAddParam;
import com.sraapp.system.param.log.OperationLogPageParam;
import com.sraapp.system.param.log.OperationLogUpdateParam;
import com.sraapp.system.vo.OperationLogVO;
import org.sagacity.sqltoy.model.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jwss
 * @date 2022-4-26 22:59:14
 */
public interface IOperationLogService extends IBaseService<Page<OperationLogVO>, OperationLogPageParam, OperationLogAddParam, OperationLogUpdateParam> {
    /**
     * 通过日志类型保存
     *
     * @param logType {@link LogTypeEnum}
     * @param request {@link HttpServletRequest}
     * @throws BusinessException 异常抛出
     */
    void saveByLogType(String logType, HttpServletRequest request) throws BusinessException;
}
