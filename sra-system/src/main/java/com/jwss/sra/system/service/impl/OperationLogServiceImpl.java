package com.jwss.sra.system.service.impl;

import cn.hutool.core.convert.Convert;
import com.jwss.sra.common.model.BusinessException;
import com.jwss.sra.system.entity.OperationLog;
import com.jwss.sra.system.param.log.OperationLogAddParam;
import com.jwss.sra.system.param.log.OperationLogPageParam;
import com.jwss.sra.system.param.log.OperationLogUpdateParam;
import com.jwss.sra.system.service.IOperationLogService;
import com.jwss.sra.system.vo.OperationLogVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return null;
    }

    @Override
    public boolean delete(String id) {
        return sqlToyLazyDao.deleteByIds(OperationLog.class, id) > 0;
    }
}
