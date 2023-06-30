package net.cocotea.admin.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import net.cocotea.admin.common.enums.LogTypeEnum;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.framework.util.IpUtils;
import net.cocotea.admin.system.entity.SysOperationLog;
import net.cocotea.admin.system.param.log.SysOperationLogUpdateParam;
import net.cocotea.admin.system.vo.SysOperationLogVO;
import net.cocotea.admin.common.enums.OperationStatusEnum;
import net.cocotea.admin.system.param.log.SysOperationLogAddParam;
import net.cocotea.admin.system.param.log.SysOperationLogPageParam;
import net.cocotea.admin.system.service.SysOperationLogService;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author jwss
 */
@Service
public class SysOperationLogServiceImpl implements SysOperationLogService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(SysOperationLogAddParam param) throws BusinessException {
        SysOperationLog sysOperationLog = Convert.convert(SysOperationLog.class, param);
        Object save = sqlToyLazyDao.save(sysOperationLog);
        return save != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        idList.forEach(this::delete);
        return idList.size() > 0;
    }

    @Override
    public boolean update(SysOperationLogUpdateParam param) throws BusinessException {
        return false;
    }

    @Override
    public Page<SysOperationLogVO> listByPage(SysOperationLogPageParam param) throws BusinessException {
        Page<SysOperationLogVO> vo = sqlToyLazyDao.findPageBySql(param, "system_operationLog_findByPageParam", param.getOperationLog());
        return vo;
    }

    @Override
    public boolean delete(String id) {
        return sqlToyLazyDao.deleteByIds(SysOperationLog.class, id) > 0;
    }

    @Override
    public void saveByLogType(Integer logType, HttpServletRequest request) throws BusinessException {
        SysOperationLogAddParam logAddParam = new SysOperationLogAddParam();
        logAddParam.setIpAddress(IpUtils.getIp(request));
        logAddParam.setLogType(logType);
        logAddParam.setRequestWay(request.getMethod());
        logAddParam.setLogNumber(System.currentTimeMillis());
        logAddParam.setOperator(String.valueOf(StpUtil.getLoginId()));
        logAddParam.setOperationStatus(OperationStatusEnum.SUCCESS.getCode());
        logAddParam.setOperationTime(LocalDateTime.now());
        add(logAddParam);
    }

    @Override
    public void saveErrorLog(HttpServletRequest request) {
        if (StpUtil.isLogin()) {
            SysOperationLogAddParam logAddParam = new SysOperationLogAddParam();
            logAddParam.setIpAddress(IpUtils.getIp(request));
            logAddParam.setLogType(LogTypeEnum.OPERATION.getCode());
            logAddParam.setRequestWay(request.getMethod());
            logAddParam.setLogNumber(System.currentTimeMillis());
            logAddParam.setOperator(String.valueOf(StpUtil.getLoginId()));
            logAddParam.setOperationStatus(OperationStatusEnum.ERROR.getCode());
            logAddParam.setOperationTime(LocalDateTime.now());
            try {
                add(logAddParam);
            } catch (BusinessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
