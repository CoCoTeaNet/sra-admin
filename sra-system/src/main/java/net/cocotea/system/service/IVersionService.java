package net.cocotea.system.service;

import net.cocotea.common.service.IBaseService;
import net.cocotea.system.param.version.VersionAddParam;
import net.cocotea.system.param.version.VersionPageParam;
import net.cocotea.system.param.version.VersionUpdateParam;
import net.cocotea.system.vo.VersionVO;
import org.sagacity.sqltoy.model.Page;

public interface IVersionService extends IBaseService<Page<VersionVO>, VersionPageParam, VersionAddParam, VersionUpdateParam> {
}
