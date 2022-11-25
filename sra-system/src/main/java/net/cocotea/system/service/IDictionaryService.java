package net.cocotea.system.service;

import net.cocotea.common.service.IBaseService;
import net.cocotea.system.param.dictionary.DictionaryAddParam;
import net.cocotea.system.param.dictionary.DictionaryPageParam;
import net.cocotea.system.param.dictionary.DictionaryUpdateParam;
import net.cocotea.system.vo.DictionaryVO;
import org.sagacity.sqltoy.model.Page;

import java.util.Collection;

/**
 * 字典 接口服务类
 * @author jwss
 * @date 2022-3-22
 */
public interface IDictionaryService extends IBaseService<Page<DictionaryVO>, DictionaryPageParam, DictionaryAddParam, DictionaryUpdateParam> {

    /**
     * 获取树形结构
     * @param param 分页参数
     * @return 分页对象
     */
    Collection<DictionaryVO> listByTree(DictionaryPageParam param);
}
