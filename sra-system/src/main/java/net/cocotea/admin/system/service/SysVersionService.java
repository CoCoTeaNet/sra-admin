package net.cocotea.admin.system.service;

import net.cocotea.admin.common.service.IBaseService;
import net.cocotea.admin.system.param.version.SysVersionAddParam;
import net.cocotea.admin.system.param.version.SysVersionPageParam;
import net.cocotea.admin.system.param.version.SysVersionUpdateParam;
import net.cocotea.admin.system.vo.SysVersionVO;
import org.sagacity.sqltoy.model.Page;

public interface SysVersionService extends IBaseService<Page<SysVersionVO>, SysVersionPageParam, SysVersionAddParam, SysVersionUpdateParam> {
}
