package net.cocotea.admin.system.service;

import net.cocotea.admin.system.param.theme.SysThemeUpdateParam;
import net.cocotea.admin.system.vo.SysThemeVO;

/**
 * 系统主题表
 *
 * @author CoCoTea 572315466@qq.com
 * @since 1.2.4 2023-02-25
 */
public interface ISysThemeService {
    boolean updateByUser(SysThemeUpdateParam param);

    SysThemeVO loadByUser();
}