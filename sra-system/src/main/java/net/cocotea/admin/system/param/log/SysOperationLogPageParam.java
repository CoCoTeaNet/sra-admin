package net.cocotea.admin.system.param.log;

import net.cocotea.admin.system.entity.SysOperationLog;
import net.cocotea.admin.system.vo.SysOperationLogVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * 系统操作日志 分页查询参数
 *
 * @author jwss
 * @date 2022-4-29 16:13:50
 */
public class SysOperationLogPageParam extends Page<SysOperationLog> implements Serializable {
    private static final long serialVersionUID = -2889574415371661414L;

    private SysOperationLogVO operationLog;

    public SysOperationLogVO getOperationLog() {
        return operationLog;
    }

    public SysOperationLogPageParam setOperationLog(SysOperationLogVO operationLog) {
        this.operationLog = operationLog;
        return this;
    }
}
