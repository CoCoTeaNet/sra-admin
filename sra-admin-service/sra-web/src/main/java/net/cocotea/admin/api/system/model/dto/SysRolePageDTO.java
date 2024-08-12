package net.cocotea.admin.api.system.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.cocotea.admin.api.system.model.vo.SysRoleVO;
import net.cocotea.admin.common.model.ApiPageDTO;

import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author CoCoTea
 * @version 2.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SysRolePageDTO extends ApiPageDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = -8722226920902960302L;

	@NotNull(message = "查询参数为空")
	private Query sysRole;

	@Data
	public static class Query {

		/**
		 * 角色名称
		 */
		private String roleName;

		/**
		 * 角色key值
		 */
		private String roleKey;

		/**
		 * 备注
		 */
		private String remark;

	}

}
