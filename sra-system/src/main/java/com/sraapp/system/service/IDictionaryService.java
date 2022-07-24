package com.sraapp.system.service;

import com.sraapp.common.service.IBaseService;
import com.sraapp.system.param.dictionary.DictionaryAddParam;
import com.sraapp.system.param.dictionary.DictionaryPageParam;
import com.sraapp.system.param.dictionary.DictionaryUpdateParam;
import com.sraapp.system.vo.DictionaryVO;
import org.sagacity.sqltoy.model.Page;

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
    Page<DictionaryVO> listByTree(DictionaryPageParam param);
}
