package com.jwss.sra.system.service;

import com.jwss.sra.common.enums.LogTypeEnum;
import com.jwss.sra.common.model.BusinessException;
import com.jwss.sra.common.service.IBaseService;
import com.jwss.sra.system.param.log.OperationLogAddParam;
import com.jwss.sra.system.param.log.OperationLogPageParam;
import com.jwss.sra.system.param.log.OperationLogUpdateParam;
import com.jwss.sra.system.vo.OperationLogVO;
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
