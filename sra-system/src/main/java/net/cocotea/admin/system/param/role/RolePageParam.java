package net.cocotea.admin.system.param.role;

import net.cocotea.admin.system.vo.MenuVO;
import net.cocotea.admin.system.vo.RoleVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_role,角色菜单表
 */
public class RolePageParam extends Page<MenuVO> implements Serializable {

	private static final long serialVersionUID = -8722226920902960302L;

	private RoleVO roleVO;

	public RoleVO getRoleVO() {
		return roleVO;
	}

	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}
}
