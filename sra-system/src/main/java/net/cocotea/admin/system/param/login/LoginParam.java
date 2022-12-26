package net.cocotea.admin.system.param.login;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author CoCoTea
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_user,系统用户表  
 */
public class LoginParam implements Serializable {

	private static final long serialVersionUID = -75070990767806255L;

	@NotBlank(message = "账号名不能为空")
	private String username;
	
	@NotBlank(message = "密码不能为空")
	private String password;

	@NotBlank(message = "验证码不能为空")
	private String captcha;

	private Boolean rememberMe;

	public String getCaptcha() {
		return captcha;
	}

	public LoginParam setCaptcha(String captcha) {
		this.captcha = captcha;
		return this;
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
