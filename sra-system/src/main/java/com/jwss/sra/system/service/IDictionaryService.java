package com.jwss.sra.system.service;

import com.jwss.sra.system.param.dictionary.DictionaryAddParam;
import com.jwss.sra.system.param.dictionary.DictionaryPageParam;
import com.jwss.sra.system.param.dictionary.DictionaryUpdateParam;
import com.jwss.sra.system.vo.DictionaryVO;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * 字典 接口服务类
 * @author jwss
 * @date 2022-3-22
 */
public interface IDictionaryService {

    /**
     * 新增字典
     * @param param 字典新增参数
     * @return 成功返回true
     */
    boolean add(DictionaryAddParam param);

    /**
     * 批量删除字典
     * @param idList id集合
     * @return 成功返回true
     */
    boolean deleteBatch(List<String> idList);

    /**
     * 更新字典信息
     * @param param 字典更新参数
     * @return 成功返回true
     */
    boolean update(DictionaryUpdateParam param);

    /**
     * 分页获取字典
     * @param param 字典分页参数
     * @return 字典列表
     */
    List<DictionaryVO> listByPage(DictionaryPageParam param);

    /**
     * 获取字典树形结构
     * @param param 字典分页参数
     * @return 字典分页对象
     */
    Page<DictionaryVO> listByTree(DictionaryPageParam param);
}
