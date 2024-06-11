package net.cocotea.admin.api.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.sagframe.sagacity.sqltoy.plus.dao.SqlToyHelperDao;
import net.cocotea.admin.api.system.model.dto.SysVersionAddDTO;
import net.cocotea.admin.api.system.model.dto.SysVersionPageDTO;
import net.cocotea.admin.api.system.model.dto.SysVersionUpdateDTO;
import net.cocotea.admin.api.system.model.po.SysVersion;
import net.cocotea.admin.api.system.model.vo.SysVersionVO;
import net.cocotea.admin.api.system.service.SysVersionService;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.BusinessException;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class SysVersionServiceImpl implements SysVersionService {
    @Resource
    private SqlToyHelperDao sqlToyHelperDao;

    @Override
    public boolean add(SysVersionAddDTO param) throws BusinessException {
        SysVersion sysVersion = Convert.convert(SysVersion.class, param);
        Object save = sqlToyHelperDao.save(sysVersion);
        return save != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBatch(List<BigInteger> idList) throws BusinessException {
        for (BigInteger s : idList) {
            delete(s);
        }
        return !idList.isEmpty();
    }

    @Override
    public boolean update(SysVersionUpdateDTO param) throws BusinessException {
        SysVersion sysVersion = Convert.convert(SysVersion.class, param);
        Long count = sqlToyHelperDao.update(sysVersion);
        return count > 0;
    }

    @Override
    public ApiPage<SysVersionVO> listByPage(SysVersionPageDTO pageDTO) throws BusinessException {
        Map<String, Object> map = BeanUtil.beanToMap(pageDTO.getSysVersion());
        Page<SysVersionVO> page = sqlToyHelperDao.findPageBySql(pageDTO, "sys_version_findList", map, SysVersionVO.class);
        return ApiPage.rest(page, SysVersionVO.class);
    }

    @Override
    public boolean delete(BigInteger id) throws BusinessException {
        return sqlToyHelperDao.delete(new SysVersion().setId(id)) > 0;
    }
}
