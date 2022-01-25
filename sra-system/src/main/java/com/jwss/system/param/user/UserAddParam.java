package com.jwss.system.param.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_user,系统用户表  
 */
@ApiModel(value = "新增用户参数")
public class UserAddParam implements Serializable {

	private static final long serialVersionUID = -75070990767806255L;
	/**
	 * 用户账号
	 */
	@NotBlank(message = "账号名为空")
	@ApiModelProperty(name = "用户账号", required = true)
	private String username;
	
	/**
	 * 密码
	 */
	@NotBlank(message = "密码为空")
	@ApiModelProperty(name = "用户密码", required = true)
	private String password;

	@NotBlank(message = "角色ID为空")
	@ApiModelProperty(name = "角色ID", required = true)
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 *@param username the username to set
	 */
	public void setUsername(String username) {
		this.username=username;
	}
		
	/**
	 *@return the Username
	 */
	public String getUsername() {
	    return this.username;
	}
	
	/**
	 *@param password the password to set
	 */
	public void setPassword(String password) {
		this.password=password;
	}
		
	/**
	 *@return the Password
	 */
	public String getPassword() {
	    return this.password;
	}

}
