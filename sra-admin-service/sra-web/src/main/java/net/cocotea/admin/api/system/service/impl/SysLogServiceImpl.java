package net.cocotea.admin.api.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.sagframe.sagacity.sqltoy.plus.dao.SqlToyHelperDao;
import net.cocotea.admin.api.system.model.dto.SysLogAddDTO;
import net.cocotea.admin.api.system.model.dto.SysLogPageDTO;
import net.cocotea.admin.api.system.model.dto.SysLogUpdateDTO;
import net.cocotea.admin.api.system.model.po.SysLog;
import net.cocotea.admin.api.system.model.vo.SysLogVO;
import net.cocotea.admin.api.system.service.SysLogService;
import net.cocotea.admin.common.enums.LogStatusEnum;
import net.cocotea.admin.common.enums.LogTypeEnum;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.util.IpUtils;
import net.cocotea.admin.properties.DefaultProp;
import net.cocotea.admin.util.LoginUtils;
import org.sagacity.sqltoy.model.Page;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SqlToyHelperDao sqlToyHelperDao;

    @Resource
    private DefaultProp defaultProp;

    @Override
    public boolean add(SysLogAddDTO param) throws BusinessException {
        SysLog sysOperationLog = Convert.convert(SysLog.class, param);
        Object save = sqlToyHelperDao.save(sysOperationLog);
        return save != null;
    }

    @Override
    public boolean deleteBatch(List<BigInteger> idList) throws BusinessException {
        idList.forEach(this::delete);
        return !idList.isEmpty();
    }

    @Override
    public boolean update(SysLogUpdateDTO param) throws BusinessException {
        return false;
    }

    @Override
    public boolean delete(BigInteger id) {
        return sqlToyHelperDao.deleteByIds(SysLog.class, id) > 0;
    }

    @Override
    public ApiPage<SysLogVO> listByPage(SysLogPageDTO pageDTO) throws BusinessException {
        String operator = pageDTO.getSysLog().getOperator();
        Map<String, Object> sysLogMap = BeanUtil.beanToMap(pageDTO.getSysLog());
        sysLogMap.put("operator", operator);
        Page<SysLogVO> page = sqlToyHelperDao.findPageBySql(pageDTO, "sys_log_JOIN_findList", sysLogMap, SysLogVO.class);
        return ApiPage.rest(page, SysLogVO.class);
    }

    @Async
    @Override
    public void saveByLogType(Integer logType, HttpServletRequest request) throws BusinessException {
        if (defaultProp.getSaveLog()) {
            SysLogAddDTO sysLogAddDTO = new SysLogAddDTO();
            sysLogAddDTO.setIpAddress(IpUtils.getIp(request));
            sysLogAddDTO.setLogType(logType);
            sysLogAddDTO.setRequestWay(request.getMethod());
            sysLogAddDTO.setOperator(LoginUtils.loginId());
            sysLogAddDTO.setLogStatus(LogStatusEnum.SUCCESS.getCode());
            add(sysLogAddDTO);
        }
    }

    @Override
    public void saveErrorLog(HttpServletRequest request) {
        if (StpUtil.isLogin() && defaultProp.getSaveLog()) {
            SysLogAddDTO sysLogAddDTO = new SysLogAddDTO();
            sysLogAddDTO.setIpAddress(IpUtils.getIp(request));
            sysLogAddDTO.setLogType(LogTypeEnum.OPERATION.getCode());
            sysLogAddDTO.setRequestWay(request.getMethod());
            sysLogAddDTO.setOperator(LoginUtils.loginId());
            sysLogAddDTO.setLogStatus(LogStatusEnum.ERROR.getCode());
            try {
                add(sysLogAddDTO);
            } catch (BusinessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
