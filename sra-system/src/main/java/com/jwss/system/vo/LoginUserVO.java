package com.jwss.system.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_user,系统用户表  
 */
public class LoginUserVO implements Serializable {

	private static final long serialVersionUID = 1641777558644610990L;

	@ApiModelProperty("是否登录")
	private Boolean loginStatus;

	@ApiModelProperty("用户详细信息")
	private UserVO userDetail;

	@ApiModelProperty("权限集合")
	private List<MenuVO> permissions;

	@ApiModelProperty("token")
	private String token;

	public Boolean getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public UserVO getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserVO userDetail) {
		this.userDetail = userDetail;
	}

	public List<MenuVO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<MenuVO> permissions) {
		this.permissions = permissions;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "LoginUserVO{" +
				"isLogin=" + loginStatus +
				", userDetail=" + userDetail +
				", permissions=" + permissions +
				", token='" + token + '\'' +
				'}';
	}
}
