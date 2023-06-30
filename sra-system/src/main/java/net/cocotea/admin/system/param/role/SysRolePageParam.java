package net.cocotea.admin.system.param.role;

import net.cocotea.admin.system.vo.SysMenuVO;
import net.cocotea.admin.system.vo.SysRoleVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_role,角色菜单表
 */
public class SysRolePageParam extends Page<SysMenuVO> implements Serializable {

	private static final long serialVersionUID = -8722226920902960302L;

	private SysRoleVO role;

	public SysRoleVO getRole() {
		return role;
	}

	public SysRolePageParam setRole(SysRoleVO role) {
		this.role = role;
		return this;
	}
}
