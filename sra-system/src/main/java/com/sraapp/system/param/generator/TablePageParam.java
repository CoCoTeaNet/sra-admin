package com.sraapp.system.param.generator;

import com.sraapp.system.vo.TableVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * 数据库表分页查询参数
 * @author jwss
 * @date 2022-4-21 11:01:42
 */
public class TablePageParam extends Page<TableVO> implements Serializable {
    private static final long serialVersionUID = 4368969316134501076L;

    private TableVO tableVO;

    public TableVO getTableVO() {
        return tableVO;
    }

    public void setTableVO(TableVO tableVO) {
        this.tableVO = tableVO;
    }
}
