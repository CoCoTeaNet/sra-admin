package com.sraapp.system.param.user;

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
@ApiModel(value = "用户登录参数")
public class UserLoginParam implements Serializable {

	private static final long serialVersionUID = -75070990767806255L;

	@NotBlank(message = "账号名不能为空")
	@ApiModelProperty(name = "用户账号", required = true)
	private String username;
	
	@NotBlank(message = "密码不能为空")
	@ApiModelProperty(name = "用户密码", required = true)
	private String password;

	@NotBlank(message = "验证码不能为空")
	@ApiModelProperty(name = "验证码", required = true)
	private String verifyCode;

	@ApiModelProperty(name = "记住我")
	private Boolean rememberMe;

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
}
