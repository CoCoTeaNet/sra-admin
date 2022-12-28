package ${package}.${moduleName}.service.impl;

import ${package}.${moduleName}.vo.${ClassName}VO;
import ${package}.${moduleName}.entity.${ClassName};
import ${package}.${moduleName}.param.${functionName}.${ClassName}AddParam;
import ${package}.${moduleName}.param.${functionName}.${ClassName}PageParam;
import ${package}.${moduleName}.param.${functionName}.${ClassName}UpdateParam;
import ${package}.${moduleName}.service.I${ClassName}Service;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import cn.hutool.core.convert.Convert;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

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
    public boolean add(${ClassName}AddParam param) {
         ${ClassName} ${className} = Convert.convert(${ClassName}.class, param);
         Object save = sqlToyLazyDao.save(${className});
         return save != null;
    }
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBatch(List<String> idList) {
         for (String s : idList) {
              delete(s);
         }
         return !idList.isEmpty();
    }
    
    @Override
    public boolean update(${ClassName}UpdateParam param) {
         ${ClassName} ${className} = Convert.convert(${ClassName}.class, param);
         Long count = sqlToyLazyDao.update(${className});
         return count > 0;
    }
    
    @Override
    public Page<${ClassName}VO> listByPage(${ClassName}PageParam param) { 
         Page<${ClassName}VO> page = sqlToyLazyDao.findPageBySql(param, "${moduleName}_${className}_findByPageParam", param.get${ClassName}());
         return page;
    }
    
    @Override
    public boolean delete(String id) {
         return sqlToyLazyDao.delete(new ${ClassName}().setID(id)) > 0;
    }

}