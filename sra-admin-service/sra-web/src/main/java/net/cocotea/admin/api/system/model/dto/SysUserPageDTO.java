package net.cocotea.admin.api.system.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.cocotea.admin.api.system.model.vo.SysUserVO;
import org.sagacity.sqltoy.model.Page;

import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author CoCoTea
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_menu,系统菜单表  
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SysUserPageDTO extends Page<SysUserVO> implements Serializable{

	@Serial
	private static final long serialVersionUID = 5565588370362046172L;

	@NotNull(message = "查询参数为空")
	private SysUserVO sysUser;
}
