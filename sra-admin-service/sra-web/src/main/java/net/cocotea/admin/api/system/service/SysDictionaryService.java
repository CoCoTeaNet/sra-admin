package net.cocotea.admin.api.system.service;

import net.cocotea.admin.api.system.model.dto.SysDictionaryAddDTO;
import net.cocotea.admin.api.system.model.dto.SysDictionaryPageDTO;
import net.cocotea.admin.api.system.model.dto.SysDictionaryTreeDTO;
import net.cocotea.admin.api.system.model.dto.SysDictionaryUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysDictionaryVO;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.service.BaseService;

import java.util.List;

/**
 * 字典 接口服务类
 * @author CoCoTea
 * @version 2.0.0
 */
public interface SysDictionaryService extends BaseService<ApiPage<SysDictionaryVO>, SysDictionaryPageDTO, SysDictionaryAddDTO, SysDictionaryUpdateDTO> {

    /**
     * 获取树形结构
     * @param param 分页参数
     * @return 分页对象
     */
    List<SysDictionaryVO> listByTree(SysDictionaryTreeDTO param);
}
