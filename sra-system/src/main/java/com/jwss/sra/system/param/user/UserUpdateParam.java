package com.jwss.sra.system.param.user;

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
public class UserUpdateParam implements Serializable {

	private static final long serialVersionUID = -75070990767806255L;

	@NotBlank(message = "主键ID为空")
	@ApiModelProperty(name = "主键ID", required = true)
	private String id;

	/**
	 * 用户账号
	 */
	@NotBlank(message = "账号名为空")
	@ApiModelProperty(name = "用户账号", required = true)
	private String username;

	@ApiModelProperty(name = "用户昵称")
	private String nickname;

	@ApiModelProperty(name = "手机号码")
	private String mobilePhone;

	@ApiModelProperty(name = "性别")
	private String sex;

	@ApiModelProperty(name = "邮箱")
	private String email;

	@ApiModelProperty(name = "用户密码")
	private String password;

	@ApiModelProperty(name = "账号状态")
	private String accountStatus;

	@ApiModelProperty(name = "角色ID")
	private String roleId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
