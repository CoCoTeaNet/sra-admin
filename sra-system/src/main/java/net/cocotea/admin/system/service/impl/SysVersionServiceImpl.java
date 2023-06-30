package net.cocotea.admin.system.service.impl;

import cn.hutool.core.convert.Convert;
import net.cocotea.admin.system.entity.SysVersion;
import net.cocotea.admin.system.service.SysVersionService;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.param.version.SysVersionAddParam;
import net.cocotea.admin.system.param.version.SysVersionPageParam;
import net.cocotea.admin.system.param.version.SysVersionUpdateParam;
import net.cocotea.admin.system.vo.SysVersionVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysVersionServiceImpl implements SysVersionService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(SysVersionAddParam param) throws BusinessException {
        SysVersion sysVersion = Convert.convert(SysVersion.class, param);
        Object save = sqlToyLazyDao.save(sysVersion);
        return save != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        for (String s : idList) {
            delete(s);
        }
        return !idList.isEmpty();
    }

    @Override
    public boolean update(SysVersionUpdateParam param) throws BusinessException {
        SysVersion sysVersion = Convert.convert(SysVersion.class, param);
        Long count = sqlToyLazyDao.update(sysVersion);
        return count > 0;
    }

    @Override
    public Page<SysVersionVO> listByPage(SysVersionPageParam param) throws BusinessException {
        Page<SysVersionVO> page = sqlToyLazyDao.findPageBySql(param, "system_version_findByPageParam", param.getVersion());
        return page;
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        return sqlToyLazyDao.delete(new SysVersion().setId(id)) > 0;
    }
}
