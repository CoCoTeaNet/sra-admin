package com.sraapp.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import com.sraapp.common.enums.LogTypeEnum;
import com.sraapp.common.model.BusinessException;
import com.sraapp.framework.util.IpUtils;
import com.sraapp.system.param.log.OperationLogUpdateParam;
import com.sraapp.system.vo.OperationLogVO;
import com.sraapp.common.enums.OperationStatusEnum;
import com.sraapp.system.entity.OperationLog;
import com.sraapp.system.param.log.OperationLogAddParam;
import com.sraapp.system.param.log.OperationLogPageParam;
import com.sraapp.system.service.IOperationLogService;
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
public class OperationLogServiceImpl implements IOperationLogService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(OperationLogAddParam param) throws BusinessException {
        OperationLog operationLog = Convert.convert(OperationLog.class, param);
        Object save = sqlToyLazyDao.save(operationLog);
        return save != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        idList.forEach(this::delete);
        return idList.size() > 0;
    }

    @Override
    public boolean update(OperationLogUpdateParam param) throws BusinessException {
        return false;
    }

    @Override
    public Page<OperationLogVO> listByPage(OperationLogPageParam param) throws BusinessException {
        Page<OperationLogVO> vo = sqlToyLazyDao.findPageBySql(param, "system_operationLog_findByPageParam", param.getOperationLogVO());
        return vo;
    }

    @Override
    public boolean delete(String id) {
        return sqlToyLazyDao.deleteByIds(OperationLog.class, id) > 0;
    }

    @Override
    public void saveByLogType(Integer logType, HttpServletRequest request) throws BusinessException {
        OperationLogAddParam logAddParam = new OperationLogAddParam();
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
            OperationLogAddParam logAddParam = new OperationLogAddParam();
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
