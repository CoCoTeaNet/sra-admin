package net.cocotea.admin.system.param.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_user,系统用户表  
 */
public class UserAddParam implements Serializable {

	private static final long serialVersionUID = -75070990767806255L;

	@NotBlank(message = "账号名为空")
	private String username;

	private String nickname;

	private String sex;

	private String email;

	private String password;

	private String accountStatus;

	@NotNull(message = "角色ID为空")
	private List<String> roleIds;

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

	public List<String> getRoleIds() {
		return roleIds;
	}

	public UserAddParam setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
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

}
