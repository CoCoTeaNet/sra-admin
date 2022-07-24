package com.sraapp.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_role_menu,角色菜单关联表  
 */
@ApiModel("角色菜单关联表")
public class RoleMenuVO implements Serializable {

	private static final long serialVersionUID = 5632526424183418214L;
	
/*---begin-auto-generate-don't-update-this-area--*/	
	/**
	 * 角色主键ID
	 */
	@ApiModelProperty(value = "角色主键ID", required = true)
	private String roleId;
	
	/**
	 * 菜单主键ID
	 */
	@ApiModelProperty(value = "菜单主键ID", required = true)
	private String menuId;
	
	
	/**
	 *@param roleId the roleId to set
	 */
	public RoleMenuVO setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
		
	/**
	 *@return the RoleId
	 */
	public String getRoleId() {
	    return this.roleId;
	}
	
	/**
	 *@param menuId the menuId to set
	 */
	public RoleMenuVO setMenuId(String menuId) {
		this.menuId=menuId;
		return this;
	}
		
	/**
	 *@return the MenuId
	 */
	public String getMenuId() {
	    return this.menuId;
	}

	/**
	* @todo vo columns to String
	*/
	@Override
	public String toString() {
		StringBuilder columnsBuffer=new StringBuilder();
			columnsBuffer.append("roleId=").append(getRoleId()).append("\n");
			columnsBuffer.append("menuId=").append(getMenuId()).append("\n");
		return columnsBuffer.toString();
	}
/*---end-auto-generate-don't-update-this-area--*/	
}
