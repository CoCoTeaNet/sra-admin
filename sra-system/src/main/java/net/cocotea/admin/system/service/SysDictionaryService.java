package net.cocotea.admin.system.service;

import net.cocotea.admin.system.param.dictionary.SysDictionaryAddParam;
import net.cocotea.admin.system.param.dictionary.SysDictionaryPageParam;
import net.cocotea.admin.system.param.dictionary.SysDictionaryUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
import net.cocotea.admin.system.vo.SysDictionaryVO;
import org.sagacity.sqltoy.model.Page;

import java.util.Collection;

/**
 * 字典 接口服务类
 * @author jwss
 * @date 2022-3-22
 */
public interface SysDictionaryService extends IBaseService<Page<SysDictionaryVO>, SysDictionaryPageParam, SysDictionaryAddParam, SysDictionaryUpdateParam> {

    /**
     * 获取树形结构
     * @param param 分页参数
     * @return 分页对象
     */
    Collection<SysDictionaryVO> listByTree(SysDictionaryPageParam param);
}
