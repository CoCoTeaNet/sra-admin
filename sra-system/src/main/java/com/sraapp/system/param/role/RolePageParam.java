package com.sraapp.system.param.role;

import com.sraapp.system.vo.MenuVO;
import com.sraapp.system.vo.RoleVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_role,角色菜单表
 */
@ApiModel("角色分页参数")
public class RolePageParam extends Page<MenuVO> implements Serializable {

	private static final long serialVersionUID = -8722226920902960302L;

	@ApiModelProperty(value = "角色属性")
	private RoleVO roleVO;

	public RoleVO getRoleVO() {
		return roleVO;
	}

	public void setRoleVO(RoleVO roleVO) {
		this.roleVO = roleVO;
	}
}
