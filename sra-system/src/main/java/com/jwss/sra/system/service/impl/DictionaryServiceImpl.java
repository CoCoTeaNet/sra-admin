package com.jwss.sra.system.service.impl;

import com.jwss.sra.common.enums.DeleteStatusEnum;
import com.jwss.sra.common.model.BusinessException;
import com.jwss.sra.common.util.GenerateDsUtils;
import com.jwss.sra.system.entity.Dictionary;
import com.jwss.sra.system.entity.Menu;
import com.jwss.sra.system.param.dictionary.DictionaryAddParam;
import com.jwss.sra.system.param.dictionary.DictionaryPageParam;
import com.jwss.sra.system.param.dictionary.DictionaryUpdateParam;
import com.jwss.sra.system.service.IDictionaryService;
import com.jwss.sra.system.vo.DictionaryVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jwss
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(DictionaryAddParam param) {
        Dictionary dictionary = sqlToyLazyDao.convertType(param, Dictionary.class);
        Object o = sqlToyLazyDao.save(dictionary);
        return o != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBatch(List<String> idList) {
        idList.forEach(this::delete);
        return idList.size() > 0;
    }

    @Override
    public boolean update(DictionaryUpdateParam param) {
        Dictionary dictionary = sqlToyLazyDao.convertType(param, Dictionary.class);
        Long update = sqlToyLazyDao.update(dictionary);
        return update != null;
    }

    @Override
    public Page<DictionaryVO> listByPage(DictionaryPageParam param) {
        return sqlToyLazyDao.findPageBySql(param, "system_dictionary_findByPageParam", param.getDictionaryVO());
    }

    @Override
    public Page<DictionaryVO> listByTree(DictionaryPageParam param) {
        Page<DictionaryVO> page = listByPage(param);
        List<DictionaryVO> rows = page.getRows();
        GenerateDsUtils<DictionaryVO> generateDsUtils = new GenerateDsUtils<>();
        Map<String, DictionaryVO> voMap = generateDsUtils.buildTreeDefault(rows);
        page.setRows(new ArrayList<>(voMap.values()));
        return page;
    }

    @Override
    public boolean delete(String id) {
        Dictionary dictionary = new Dictionary().setId(id).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        Long update = sqlToyLazyDao.update(dictionary);
        if (update <= 0) {
            return false;
        }
        // 获取子节点
        HashMap<String, Object> paramsMap = new HashMap<>(Character.UPPERCASE_LETTER);
        paramsMap.put("parentId", id);
        List<Dictionary> list = sqlToyLazyDao.findBySql(
                "select id from sys_dictionary where #[PARENT_ID=:parentId] and DELETE_STATUS=1",
                paramsMap, Dictionary.class);
        if (list.size() > 0) {
            // 存在子节点，删除子节点
            list.forEach(item -> delete(item.getId()));
        }
        return true;
    }

}
