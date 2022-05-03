package com.jwss.sra.system.param.log;

import com.jwss.sra.system.entity.OperationLog;
import com.jwss.sra.system.vo.OperationLogVO;
import io.swagger.annotations.ApiModelProperty;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * 系统操作日志 分页查询参数
 *
 * @author jwss
 * @date 2022-4-29 16:13:50
 */
public class OperationLogPageParam extends Page<OperationLog> implements Serializable {
    private static final long serialVersionUID = -2889574415371661414L;

    @ApiModelProperty(value = "操作日志查询参数")
    private OperationLogVO operationLogVO;

    public OperationLogVO getOperationLogVO() {
        return operationLogVO;
    }

    public void setOperationLogVO(OperationLogVO operationLogVO) {
        this.operationLogVO = operationLogVO;
    }
}
