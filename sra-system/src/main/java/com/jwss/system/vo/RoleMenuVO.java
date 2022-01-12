/**
 *@Generated by sagacity-quickvo 5.0
 */
package com.jwss.system.vo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_role_menu,角色菜单关联表  
 */
public class RoleMenuVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5632526424183418214L;
	
/*---begin-auto-generate-don't-update-this-area--*/	
	/**
	 * 角色ID
	 */
	private BigInteger roleId;
	
	/**
	 * 菜单ID
	 */
	private BigInteger menuId;
	
	/**
	 * 角色主键ID
	 */
	private String roleId;
	
	/**
	 * 菜单主键ID
	 */
	private String menuId;
	
	
	/**
	 *@param roleId the roleId to set
	 */
	public void setRoleId(BigInteger roleId) {
		this.roleId=roleId;
	}
		
	/**
	 *@return the RoleId
	 */
	public BigInteger getRoleId() {
	    return this.roleId;
	}
	
	/**
	 *@param menuId the menuId to set
	 */
	public void setMenuId(BigInteger menuId) {
		this.menuId=menuId;
	}
		
	/**
	 *@return the MenuId
	 */
	public BigInteger getMenuId() {
	    return this.menuId;
	}
	
	/**
	 *@param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId=roleId;
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
	public void setMenuId(String menuId) {
		this.menuId=menuId;
	}
		
	/**
	 *@return the MenuId
	 */
	public String getMenuId() {
	    return this.menuId;
	}
/*---end-auto-generate-don't-update-this-area--*/	
}
