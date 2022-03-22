package com.jwss.sra.system.service.impl;

import com.jwss.sra.system.entity.Dictionary;
import com.jwss.sra.system.param.dictionary.DictionaryAddParam;
import com.jwss.sra.system.param.dictionary.DictionaryPageParam;
import com.jwss.sra.system.param.dictionary.DictionaryUpdateParam;
import com.jwss.sra.system.service.IDictionaryService;
import com.jwss.sra.system.vo.DictionaryVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jwss
 */
public class DictionaryServiceImpl implements IDictionaryService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(DictionaryAddParam param) {
        Dictionary dictionary = sqlToyLazyDao.convertType(param, Dictionary.class);
        Object o = sqlToyLazyDao.save(dictionary);
        return o != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) {
        return false;
    }

    @Override
    public boolean update(DictionaryUpdateParam param) {
        Dictionary dictionary = sqlToyLazyDao.convertType(param, Dictionary.class);
        Long update = sqlToyLazyDao.update(dictionary);
        return update != null;
    }

       @Override
    public List<DictionaryVO> listByPage(DictionaryPageParam param) {
        return null;
    }

    @Override
    public Page<DictionaryVO> listByTree(DictionaryPageParam param) {
        return null;
    }

}
