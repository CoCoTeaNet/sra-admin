package net.cocotea.admin.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import net.cocotea.admin.system.entity.SysTheme;
import net.cocotea.admin.system.param.theme.SysThemeUpdateParam;
import net.cocotea.admin.system.service.ISysThemeService;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
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
        SysTheme sysTheme = Convert.convert(SysTheme.class, param);
        SysTheme loadSysTheme = sqlToyLazyDao.load(sysTheme);
        if (loadSysTheme == null) {
            sysTheme.setUserId(StpUtil.getLoginId().toString());
            return sqlToyLazyDao.save(sysTheme) != null;
        } else {
            return sqlToyLazyDao.update(sysTheme) > 0;
        }
    }
}