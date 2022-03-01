package com.jwss.sra.system.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jwss
 * @version 1.0.0
 * @project sss-rbac-admin
 * @description sys_user, 系统用户表
 */
public class LoginUserVO implements Serializable {

    private static final long serialVersionUID = 1641777558644610990L;

    @ApiModelProperty("登录状态")
    private Boolean loginStatus;

    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("用户账号")
    private String username;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("权限集合")
    private List<MenuVO> menuList;

    @ApiModelProperty("token")
    private String token;

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<MenuVO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "LoginUserVO{" +
                "loginStatus=" + loginStatus +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", menuList=" + menuList +
                ", token='" + token + '\'' +
                '}';
    }
}
