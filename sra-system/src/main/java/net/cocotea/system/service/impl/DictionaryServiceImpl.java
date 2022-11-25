package net.cocotea.system.service.impl;

import net.cocotea.common.enums.DeleteStatusEnum;
import net.cocotea.common.util.GenerateDsUtils;
import net.cocotea.common.constant.CharConstant;
import net.cocotea.system.entity.Dictionary;
import net.cocotea.system.param.dictionary.DictionaryAddParam;
import net.cocotea.system.param.dictionary.DictionaryPageParam;
import net.cocotea.system.param.dictionary.DictionaryUpdateParam;
import net.cocotea.system.service.IDictionaryService;
import net.cocotea.system.vo.DictionaryVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.sagacity.sqltoy.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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
        if (StringUtil.isBlank(dictionary.getParentId())) {
            dictionary.setParentId(CharConstant.ZERO);
        }
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
    public Collection<DictionaryVO> listByTree(DictionaryPageParam param) {
        List<DictionaryVO> list = sqlToyLazyDao.findBySql("system_dictionary_findByPageParam", param.getDictionaryVO());
        GenerateDsUtils<DictionaryVO> dsUtils = new GenerateDsUtils<>();
        return dsUtils.buildTreeDefault(list).values();
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
