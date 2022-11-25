package net.cocotea.system.service.impl;

import cn.hutool.core.util.StrUtil;
import net.cocotea.common.util.NamingConversionUtils;
import net.cocotea.system.param.generator.TablePageParam;
import net.cocotea.system.properties.DefaultProperties;
import net.cocotea.system.properties.DevEnableProperties;
import net.cocotea.system.service.IGeneratorService;
import net.cocotea.system.vo.TableColVO;
import net.cocotea.system.vo.TableVO;
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
public class GeneratorServiceImpl implements IGeneratorService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;
    @Resource
    private DevEnableProperties devEnableProperties;
    @Resource
    private DefaultProperties defaultProperties;

    @Override
    public Map<String, Object> getEntityCode(String dbName, String tableName) {
        String db = StrUtil.isEmpty(dbName) ? defaultProperties.getDbName() : dbName;
        // 获取表信息
        String sql = String.format("select * from information_schema.TABLES where TABLE_NAME = '%s' and TABLE_SCHEMA='%s'", tableName, db);
        TableVO tableVO = sqlToyLazyDao.loadBySql(sql, new TableVO());
        tableVO.setJavaClassName(NamingConversionUtils.underlineToHump(tableVO.getTableName(), 1));
        Map<String, Object> objectMap = new HashMap<>(10);
        // 获取表字段信息
        sql = String.format("select * from information_schema.COLUMNS where TABLE_NAME = '%s' and TABLE_SCHEMA = '%s'", tableName, db);
        List<TableColVO> colList = sqlToyLazyDao.findBySql(sql, new TableColVO());
        colList.forEach(item -> {
            item.setTsDataType(NamingConversionUtils.dbDataTypeToTs(item.getDataType()));
            item.setJavaColName(NamingConversionUtils.underlineToHump(item.getColumnName(), 0));
            item.setJavaColNameBigHump(NamingConversionUtils.underlineToHump(item.getColumnName(), 1));
            item.setJavaDataType(NamingConversionUtils.dbDataTypeToJava(item.getDataType()));
            item.setDataType(NamingConversionUtils.dbDataTypeToSqlJavaTypes(item.getDataType()));
        });
        objectMap.put("colList", colList);
        objectMap.put("author", devEnableProperties.getAuthor());
        objectMap.put("modulePackage", devEnableProperties.getModulePackage());
        objectMap.put("table", tableVO);
        return objectMap;
    }

    @Override
    public Page<TableVO> findTablesByPage(TablePageParam param) {
        if (StrUtil.isBlank(param.getTableVO().getDbName())) {
            param.getTableVO().setDbName(defaultProperties.getDbName());
        }
        String sql = "select * from information_schema.TABLES where #[and TABLE_SCHEMA = :dbName] #[and TABLE_NAME like :tableName]";
        return sqlToyLazyDao.findPageBySql(param, sql, param.getTableVO());
    }

}
