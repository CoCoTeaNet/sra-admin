package ${package}.${moduleName}.service.impl;

import ${package}.${moduleName}.vo.${ClassName}VO;
import ${package}.${moduleName}.param.${ClassName}AddParam;
import ${package}.${moduleName}.param.${ClassName}PageParam;
import ${package}.${moduleName}.param.${ClassName}UpdateParam;
import ${package}.${moduleName}.service.I${ClassName}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${tableComment}
 *
 * @author ${author} ${email}
 * @since ${version} ${date}
 */
@Service
public class ${ClassName}ServiceImpl implements I${ClassName}Service {

    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(${ClassName}AddParam param) throws BusinessException {
         ${ClassName} ${className} = Convert.convert(${ClassName}.class, param);
         Object save = sqlToyLazyDao.save(${className});
         return save != null;
    }
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
         for (String s : idList) {
              delete(s);
         }
         return !idList.isEmpty();
    }
    
    @Override
    public boolean update(${ClassName}UpdateParam param) throws BusinessException {
         ${ClassName} ${className} = Convert.convert(${ClassName}.class, param);
         Long count = sqlToyLazyDao.update(${className});
         return count > 0;
    }
    
    @Override
    public Page<${ClassName}VO> listByPage(${ClassName}PageParam param) throws BusinessException { 
         Page<${ClassName}VO> page = sqlToyLazyDao.findPageBySql(param, "${moduleName}_${className}_findByPageParam", param.get${ClassName}());
         return page;
    }
    
    @Override
    public boolean delete(String id) throws BusinessException {
         return sqlToyLazyDao.delete(new ${ClassName}().setId(id)) > 0;
    }

}