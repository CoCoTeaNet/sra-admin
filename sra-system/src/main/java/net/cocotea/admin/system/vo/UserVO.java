package net.cocotea.admin.system.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author CoCoTea
 * @project sss-rbac-admin
 * @version 1.2.3
 * @description sys_user,系统用户表  
 */
public class UserVO implements Serializable {

	private static final long serialVersionUID = 8964336332716926878L;
	
	/**
	 * 主键id
	 */
	private String id;
	
	/**
	 * 乐观锁
	 */
	private Integer revision;
	
	/**
	 * 创建人
	 */
	private String createBy;
	
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	
	/**
	 * 更新人
	 */
	private String updateBy;
	
	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 用户账号
	 */
	private String username;
	
	/**
	 * 用户昵称
	 */
	private String nickname;
	
	/**
	 * 角色名称列表
	 */
	private String roleName;

	/**
	 * 角色ID列表
	 */
	private String roleId;

	/**
	 * 用户性别;0未知 1男 2女
	 */
	private Integer sex;
	
	/**
	 * 用户邮箱
	 */
	private String email;
	
	/**
	 * 手机号
	 */
	private String mobilePhone;
	
	/**
	 * 部门id
	 */
	private String departmentId;
	
	/**
	 * 账号状态;0停用 1正常 2冻结 3封禁
	 */
	private Integer accountStatus;
	
	/**
	 * 头像地址
	 */
	private String avatar;
	
	/**
	 * 最后登录IP
	 */
	private String lastLoginIp;
	
	/**
	 * 最后登录时间
	 */
	private LocalDateTime lastLoginTime;
	
	
	/**
	 *@param id the id to set
	 */
	public UserVO setId(String id) {
		this.id=id;
		return this;
	}
		
	/**
	 *@return the Id
	 */
	public String getId() {
	    return this.id;
	}
	
	/**
	 *@param revision the revision to set
	 */
	public UserVO setRevision(Integer revision) {
		this.revision=revision;
		return this;
	}
		
	/**
	 *@return the Revision
	 */
	public Integer getRevision() {
	    return this.revision;
	}
	
	/**
	 *@param createBy the createBy to set
	 */
	public UserVO setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
		
	/**
	 *@return the CreateBy
	 */
	public String getCreateBy() {
	    return this.createBy;
	}
	
	/**
	 *@param createTime the createTime to set
	 */
	public UserVO setCreateTime(LocalDateTime createTime) {
		this.createTime=createTime;
		return this;
	}
		
	/**
	 *@return the CreateTime
	 */
	public LocalDateTime getCreateTime() {
	    return this.createTime;
	}
	
	/**
	 *@param updateBy the updateBy to set
	 */
	public UserVO setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
		
	/**
	 *@return the UpdateBy
	 */
	public String getUpdateBy() {
	    return this.updateBy;
	}
	
	/**
	 *@param updateTime the updateTime to set
	 */
	public UserVO setUpdateTime(LocalDateTime updateTime) {
		this.updateTime=updateTime;
		return this;
	}
		
	/**
	 *@return the UpdateTime
	 */
	public LocalDateTime getUpdateTime() {
	    return this.updateTime;
	}
	
	/**
	 *@param username the username to set
	 */
	public UserVO setUsername(String username) {
		this.username=username;
		return this;
	}
		
	/**
	 *@return the Username
	 */
	public String getUsername() {
	    return this.username;
	}
	
	/**
	 *@param nickname the nickname to set
	 */
	public UserVO setNickname(String nickname) {
		this.nickname=nickname;
		return this;
	}
		
	/**
	 *@return the Nickname
	 */
	public String getNickname() {
	    return this.nickname;
	}

	/**
	 *@param email the email to set
	 */
	public UserVO setEmail(String email) {
		this.email=email;
		return this;
	}
		
	/**
	 *@return the Email
	 */
	public String getEmail() {
	    return this.email;
	}
	
	/**
	 *@param mobilePhone the mobilePhone to set
	 */
	public UserVO setMobilePhone(String mobilePhone) {
		this.mobilePhone=mobilePhone;
		return this;
	}
		
	/**
	 *@return the MobilePhone
	 */
	public String getMobilePhone() {
	    return this.mobilePhone;
	}
	
	/**
	 *@param departmentId the departmentId to set
	 */
	public UserVO setDepartmentId(String departmentId) {
		this.departmentId=departmentId;
		return this;
	}
		
	/**
	 *@return the DepartmentId
	 */
	public String getDepartmentId() {
	    return this.departmentId;
	}

	/**
	 *@param avatar the avatar to set
	 */
	public UserVO setAvatar(String avatar) {
		this.avatar=avatar;
		return this;
	}
		
	/**
	 *@return the Avatar
	 */
	public String getAvatar() {
	    return this.avatar;
	}
	
	/**
	 *@param lastLoginIp the lastLoginIp to set
	 */
	public UserVO setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp=lastLoginIp;
		return this;
	}
		
	/**
	 *@return the LastLoginIp
	 */
	public String getLastLoginIp() {
	    return this.lastLoginIp;
	}
	
	/**
	 *@param lastLoginTime the lastLoginTime to set
	 */
	public UserVO setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime=lastLoginTime;
		return this;
	}
		
	/**
	 *@return the LastLoginTime
	 */
	public LocalDateTime getLastLoginTime() {
	    return this.lastLoginTime;
	}

	public Integer getSex() {
		return sex;
	}

	public UserVO setSex(Integer sex) {
		this.sex = sex;
		return this;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public UserVO setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
		return this;
	}

	public String getRoleName() {
		return roleName;
	}

	public UserVO setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public String getRoleId() {
		return roleId;
	}

	public UserVO setRoleId(String roleId) {
		this.roleId = roleId;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
