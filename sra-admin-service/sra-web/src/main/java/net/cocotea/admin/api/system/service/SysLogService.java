package net.cocotea.admin.api.system.service;

import jakarta.servlet.http.HttpServletRequest;
import net.cocotea.admin.api.system.model.dto.SysLogAddDTO;
import net.cocotea.admin.api.system.model.dto.SysLogPageDTO;
import net.cocotea.admin.api.system.model.dto.SysLogUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysLogVO;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.service.BaseService;

/**
 * @author CoCoTea
 * @version 2.0.0
 */
public interface SysLogService extends BaseService<ApiPage<SysLogVO>, SysLogPageDTO, SysLogAddDTO, SysLogUpdateDTO> {
    /**
     * 通过日志类型保存
     *
     * @param logType {@link net.cocotea.admin.common.enums.LogTypeEnum}
     * @param request {@link HttpServletRequest}
     * @throws BusinessException 异常抛出
     */
    void saveByLogType(Integer logType, HttpServletRequest request) throws BusinessException;

    /**
     * 错误日志保存
     *
     * @param request {@link HttpServletRequest}
     */
    void saveErrorLog(HttpServletRequest request);
}
