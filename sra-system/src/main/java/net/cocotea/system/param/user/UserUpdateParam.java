package net.cocotea.system.param.user;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_user,系统用户表  
 */
public class UserUpdateParam implements Serializable {

	private static final long serialVersionUID = -75070990767806255L;

	@NotBlank(message = "主键ID为空")
	private String id;

	/**
	 * 用户账号
	 */
	@NotBlank(message = "账号名为空")
	private String username;

	private String nickname;

	private String mobilePhone;

	private String sex;

	private String email;

	private String avatar;

	private String password;

	private String accountStatus;

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
