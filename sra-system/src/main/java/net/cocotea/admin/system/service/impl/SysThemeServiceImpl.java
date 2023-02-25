package net.cocotea.admin.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import net.cocotea.admin.system.entity.SysTheme;
import net.cocotea.admin.system.param.theme.SysThemeUpdateParam;
import net.cocotea.admin.system.service.ISysThemeService;
import net.cocotea.admin.system.vo.SysThemeVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.EntityQuery;
import org.sagacity.sqltoy.model.QueryExecutor;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 系统主题表
 *
 * @author CoCoTea 572315466@qq.com
 * @since 1.2.4 2023-02-25
 */
@Service
public class SysThemeServiceImpl implements ISysThemeService {

    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean updateByUser(SysThemeUpdateParam param) {
        String userId = StpUtil.getLoginId().toString();
        SysTheme sysTheme = Convert.convert(SysTheme.class, param);
        SysTheme loadSysTheme = sqlToyLazyDao.loadEntity(SysTheme.class, new EntityQuery().values("userId").names(userId));
        if (loadSysTheme == null) {
            sysTheme.setLayoutMode(0);
            sysTheme.setUserId(userId);
            return sqlToyLazyDao.save(sysTheme) != null;
        } else {
            sysTheme.setID(loadSysTheme.getID());
            return sqlToyLazyDao.update(sysTheme) > 0;
        }
    }

    @Override
    public SysThemeVO loadByUser() {
        String userId = StpUtil.getLoginId().toString();
        SysTheme loadSysTheme = sqlToyLazyDao.loadEntity(SysTheme.class, new EntityQuery().values("userId").names(userId));
        return Convert.convert(SysThemeVO.class, loadSysTheme);
    }
}