package net.cocotea.admin.system.service;

import net.cocotea.admin.common.service.IBaseService;
import net.cocotea.admin.system.param.version.VersionAddParam;
import net.cocotea.admin.system.param.version.VersionPageParam;
import net.cocotea.admin.system.param.version.VersionUpdateParam;
import net.cocotea.admin.system.vo.VersionVO;
import org.sagacity.sqltoy.model.Page;

public interface IVersionService extends IBaseService<Page<VersionVO>, VersionPageParam, VersionAddParam, VersionUpdateParam> {
}
