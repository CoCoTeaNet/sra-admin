package net.cocotea.admin.system.service.impl;

import net.cocotea.admin.common.enums.DeleteStatusEnum;
import net.cocotea.admin.common.util.GenerateDsUtils;
import net.cocotea.admin.common.constant.CharConstant;
import net.cocotea.admin.system.entity.SysDictionary;
import net.cocotea.admin.system.param.dictionary.SysDictionaryAddParam;
import net.cocotea.admin.system.param.dictionary.SysDictionaryPageParam;
import net.cocotea.admin.system.param.dictionary.SysDictionaryUpdateParam;
import net.cocotea.admin.system.service.SysDictionaryService;
import net.cocotea.admin.system.vo.SysDictionaryVO;
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
public class SysDictionaryServiceImpl implements SysDictionaryService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(SysDictionaryAddParam param) {
        SysDictionary sysDictionary = sqlToyLazyDao.convertType(param, SysDictionary.class);
        if (StringUtil.isBlank(sysDictionary.getParentId())) {
            sysDictionary.setParentId(CharConstant.ZERO);
        }
        Object o = sqlToyLazyDao.save(sysDictionary);
        return o != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBatch(List<String> idList) {
        idList.forEach(this::delete);
        return idList.size() > 0;
    }

    @Override
    public boolean update(SysDictionaryUpdateParam param) {
        SysDictionary sysDictionary = sqlToyLazyDao.convertType(param, SysDictionary.class);
        Long update = sqlToyLazyDao.update(sysDictionary);
        return update != null;
    }

    @Override
    public Page<SysDictionaryVO> listByPage(SysDictionaryPageParam param) {
        return sqlToyLazyDao.findPageBySql(param, "system_dictionary_findByPageParam", param.getDictionary());
    }

    @Override
    public Collection<SysDictionaryVO> listByTree(SysDictionaryPageParam param) {
        List<SysDictionaryVO> list = sqlToyLazyDao.findBySql("system_dictionary_findByPageParam", param.getDictionary());
        GenerateDsUtils<SysDictionaryVO> dsUtils = new GenerateDsUtils<>();
        return dsUtils.buildTreeDefault(list).values();
    }

    @Override
    public boolean delete(String id) {
        SysDictionary sysDictionary = new SysDictionary().setId(id).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        Long update = sqlToyLazyDao.update(sysDictionary);
        if (update <= 0) {
            return false;
        }
        // 获取子节点
        HashMap<String, Object> paramsMap = new HashMap<>(Character.UPPERCASE_LETTER);
        paramsMap.put("parentId", id);
        List<SysDictionary> list = sqlToyLazyDao.findBySql(
                "select id from sys_dictionary where #[PARENT_ID=:parentId] and DELETE_STATUS=1",
                paramsMap, SysDictionary.class);
        if (list.size() > 0) {
            // 存在子节点，删除子节点
            list.forEach(item -> delete(item.getId()));
        }
        return true;
    }

}
