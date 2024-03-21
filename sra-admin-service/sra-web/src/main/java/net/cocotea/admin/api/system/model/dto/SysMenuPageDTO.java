package net.cocotea.admin.api.system.model.dto;

import cn.hutool.core.convert.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.cocotea.admin.api.system.model.po.SysMenu;
import net.cocotea.admin.api.system.model.vo.SysMenuVO;
import org.sagacity.sqltoy.model.Page;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author CoCoTea
 * @version 2.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SysMenuPageDTO extends Page<SysMenuVO> implements Serializable {

    @Serial
    private static final long serialVersionUID = -772057092053351688L;

    /**
     * 详细查询条件
     */
    @NotNull(message = "查询参数为空")
    private SysMenuVO sysMenu;

    public SysMenu getPO() {
        return Convert.convert(SysMenu.class, sysMenu);
    }
}
