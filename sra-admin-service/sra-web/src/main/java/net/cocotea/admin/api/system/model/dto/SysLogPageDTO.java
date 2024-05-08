package net.cocotea.admin.api.system.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.cocotea.admin.api.system.model.po.SysLog;
import net.cocotea.admin.api.system.model.vo.SysLogVO;
import org.sagacity.sqltoy.model.Page;

import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

/**
 * 系统操作日志 分页查询参数
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SysLogPageDTO extends Page<SysLog> implements Serializable {
    @Serial
    private static final long serialVersionUID = -2889574415371661414L;

    /**
     * 查询参数
     */
    @NotNull(message = "查询参数为空")
    private SysLogVO sysLog;
}
