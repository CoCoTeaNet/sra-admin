package com.jwss.sra.system.service.impl;

import com.jwss.sra.common.util.NamingConversionUtils;
import com.jwss.sra.config.properties.DevEnableProperties;
import com.jwss.sra.system.param.generator.TablePageParam;
import com.jwss.sra.system.service.ICodeGeneratorService;
import com.jwss.sra.system.vo.TableColVO;
import com.jwss.sra.system.vo.TableVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jwss
 */
@Service
public class CodeGeneratorServiceImpl implements ICodeGeneratorService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;
    @Resource
    private DevEnableProperties devEnableProperties;

    @Override
    public Map<String, Object> getEntityCode(String tableName) {
        // 获取表信息
        String sql = String.format("select * from information_schema.TABLES where TABLE_NAME = '%s'", tableName);
        TableVO tableVO = sqlToyLazyDao.loadBySql(sql, new TableVO());
        tableVO.setJavaClassName(NamingConversionUtils.underlineToHump(tableVO.getTableName(), 1));
        Map<String, Object> objectMap = new HashMap<>(10);
        // 获取表字段信息
        sql = String.format("select * from information_schema.COLUMNS where TABLE_NAME = '%s'", tableName);
        List<TableColVO> colList = sqlToyLazyDao.findBySql(sql, new TableColVO());
        colList.forEach(item -> {
            item.setJavaColName(NamingConversionUtils.underlineToHump(item.getColumnName(), 0));
            item.setJavaColNameBigHump(NamingConversionUtils.underlineToHump(item.getColumnName(), 1));
            item.setJavaDataType(NamingConversionUtils.dbDataTypeToJava(item.getDataType()));
        });
        objectMap.put("colList", colList);
        objectMap.put("author", devEnableProperties.getAuthor());
        objectMap.put("modulePackage", devEnableProperties.getModulePackage());
        objectMap.put("table", tableVO);
        return objectMap;
    }

    @Override
    public Page<TableVO> findTablesByPage(TablePageParam param) {
        return null;
    }
}
