package net.cocotea.admin.system.service;

import net.cocotea.admin.system.param.log.OperationLogAddParam;
import net.cocotea.admin.system.param.log.OperationLogPageParam;
import net.cocotea.admin.system.param.log.OperationLogUpdateParam;
import net.cocotea.admin.common.enums.LogTypeEnum;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.service.IBaseService;
import net.cocotea.admin.system.vo.OperationLogVO;
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
    void saveByLogType(Integer logType, HttpServletRequest request) throws BusinessException;

    void saveErrorLog(HttpServletRequest request);
}
