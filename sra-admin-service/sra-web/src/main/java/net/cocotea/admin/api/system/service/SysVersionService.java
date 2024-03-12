package net.cocotea.admin.api.system.service;

import net.cocotea.admin.api.system.model.dto.SysVersionAddDTO;
import net.cocotea.admin.api.system.model.dto.SysVersionPageDTO;
import net.cocotea.admin.api.system.model.dto.SysVersionUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysVersionVO;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.service.BaseService;

public interface SysVersionService extends BaseService<ApiPage<SysVersionVO>, SysVersionPageDTO, SysVersionAddDTO, SysVersionUpdateDTO> {
}
