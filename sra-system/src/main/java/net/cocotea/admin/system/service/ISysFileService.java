package net.cocotea.admin.system.service;

import net.cocotea.admin.system.vo.SysFileVO;
import net.cocotea.admin.system.param.file.SysFileAddParam;
import net.cocotea.admin.system.param.file.SysFilePageParam;
import net.cocotea.admin.system.param.file.SysFileUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

/**
 * 系统文件表
 *
 * @author CoCoTea 572315466@qq.com
 * @since 1.2.1 2022-12-28
 */
public interface ISysFileService extends IBaseService<Page<SysFileVO>, SysFilePageParam, SysFileAddParam, SysFileUpdateParam> {
}