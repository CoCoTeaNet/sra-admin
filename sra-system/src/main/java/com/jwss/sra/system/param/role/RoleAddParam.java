package com.jwss.sra.system.param.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_role,系统角色表  
 */
@ApiModel("系统角色新增参数")
public class RoleAddParam implements Serializable {

	private static final long serialVersionUID = -6663565327923196565L;

	/**
	 * 角色名称
	 */
	@ApiModelProperty(value = "角色名称", required = true)
	@NotBlank(message = "角色名称为空")
	private String roleName;
	
	/**
	 * 角色标识
	 */
	@ApiModelProperty(value = "角色标识", required = true)
	@NotBlank(message = "角色标识为空")
	private String roleKey;
	
	/**
	 * 显示排序
	 */
	@ApiModelProperty(value = "显示顺序", required = false)
	private Integer sort;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
