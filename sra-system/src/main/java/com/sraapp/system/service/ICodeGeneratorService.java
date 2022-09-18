package com.sraapp.system.service;

import com.sraapp.system.param.generator.TablePageParam;
import com.sraapp.system.vo.TableVO;
import org.sagacity.sqltoy.model.Page;

import java.util.Map;

/**
 * 代码生成器服务
 *
 * @author jwss
 * @date 2022-4-14 22:53:07
 */
public interface ICodeGeneratorService {

    /**
     * 根据表名称生成实体类属性集合
     *
     * @param tableName 表名称
     * @return 实体类属性
     */
    Map<String, Object> getEntityCode(String dbName, String tableName);

    /**
     * 分页查找数据库表
     *
     * @param param 数据库表分页参数
     * @return 数据库表集合
     */
    Page<TableVO> findTablesByPage(TablePageParam param);
}
