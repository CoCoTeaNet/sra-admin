package com.jwss.sra.system.param.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_role,系统角色表  
 */
@ApiModel("系统角色更新参数")
public class RoleUpdateParam implements Serializable {

	private static final long serialVersionUID = -551717904814153800L;

	@NotBlank(message = "主键ID不能为空")
	@ApiModelProperty(value = "主键ID", required = true)
	private String id;

	/**
	 * 角色名称
	 */
	@ApiModelProperty("角色名称")
	private String roleName;
	
	/**
	 * 角色标识
	 */
	@ApiModelProperty("角色标识")
	private String roleKey;
	
	/**
	 * 显示排序
	 */
	@ApiModelProperty("排序号")
	private Integer sort;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
