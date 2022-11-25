package net.cocotea.admin.system.entity;

import java.io.Serializable;

import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;
import java.time.LocalDateTime;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * Table: sys_user,Remark:系统用户表  
 */
@Entity(tableName="sys_user")
public class User implements Serializable {

	private static final long serialVersionUID = 3203290987069291273L;
	
	/**
	 * jdbcType:VARCHAR
	 * 主键id
	 */
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
	@Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String id;
	
	/**
	 * jdbcType:INT
	 * 乐观锁
	 */
	@Column(name="REVISION",length=10L,type=java.sql.Types.INTEGER,nullable=true)
	private Integer revision;
	
	/**
	 * jdbcType:VARCHAR
	 * 创建人
	 */
	@Column(name="CREATE_BY",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String createBy;
	
	/**
	 * jdbcType:DATETIME
	 * 创建时间
	 */
	@Column(name="CREATE_TIME",length=19L,type=java.sql.Types.DATE,nullable=false)
	private LocalDateTime createTime;
	
	/**
	 * jdbcType:VARCHAR
	 * 更新人
	 */
	@Column(name="UPDATE_BY",length=32L,type=java.sql.Types.VARCHAR,nullable=true)
	private String updateBy;
	
	/**
	 * jdbcType:DATETIME
	 * 更新时间
	 */
	@Column(name="UPDATE_TIME",length=19L,type=java.sql.Types.DATE,nullable=true)
	private LocalDateTime updateTime;
	
	/**
	 * jdbcType:CHAR
	 * 删除状态;0删除 1未删除
	 */
	@Column(name="DELETE_STATUS",length=1L,type=java.sql.Types.CHAR,nullable=false)
	private Integer deleteStatus;
	
	/**
	 * jdbcType:VARCHAR
	 * 用户账号
	 */
	@Column(name="USERNAME",length=30L,type=java.sql.Types.VARCHAR,nullable=false)
	private String username;
	
	/**
	 * jdbcType:VARCHAR
	 * 用户昵称
	 */
	@Column(name="NICKNAME",length=30L,type=java.sql.Types.VARCHAR,nullable=false)
	private String nickname;
	
	/**
	 * jdbcType:VARCHAR
	 * 密码
	 */
	@Column(name="PASSWORD",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String password;
	
	/**
	 * jdbcType:CHAR
	 * 用户性别;0未知 1男 2女
	 */
	@Column(name="SEX",length=1L,type=java.sql.Types.CHAR,nullable=false)
	private String sex;
	
	/**
	 * jdbcType:VARCHAR
	 * 用户邮箱
	 */
	@Column(name="EMAIL",length=64L,type=java.sql.Types.VARCHAR,nullable=true)
	private String email;
	
	/**
	 * jdbcType:VARCHAR
	 * 手机号
	 */
	@Column(name="MOBILE_PHONE",length=11L,type=java.sql.Types.VARCHAR,nullable=true)
	private String mobilePhone;
	
	/**
	 * jdbcType:VARCHAR
	 * 部门id
	 */
	@Column(name="DEPARTMENT_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=true)
	private String departmentId;
	
	/**
	 * jdbcType:CHAR
	 * 账号状态;0停用 1正常 2冻结 3封禁
	 */
	@Column(name="ACCOUNT_STATUS",length=1L,type=java.sql.Types.CHAR,nullable=false)
	private Integer accountStatus;
	
	/**
	 * jdbcType:VARCHAR
	 * 头像地址
	 */
	@Column(name="AVATAR",length=255L,type=java.sql.Types.VARCHAR,nullable=true)
	private String avatar;
	
	/**
	 * jdbcType:VARCHAR
	 * 最后登录IP
	 */
	@Column(name="LAST_LOGIN_IP",length=64L,type=java.sql.Types.VARCHAR,nullable=true)
	private String lastLoginIp;
	
	/**
	 * jdbcType:DATETIME
	 * 最后登录时间
	 */
	@Column(name="LAST_LOGIN_TIME",length=19L,type=java.sql.Types.DATE,nullable=true)
	private LocalDateTime lastLoginTime;

	public String getId() {
		return id;
	}

	public User setId(String id) {
		this.id = id;
		return this;
	}

	public Integer getRevision() {
		return revision;
	}

	public User setRevision(Integer revision) {
		this.revision = revision;
		return this;
	}

	public String getCreateBy() {
		return createBy;
	}

	public User setCreateBy(String createBy) {
		this.createBy = createBy;
		return this;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public User setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public User setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		return this;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public User setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public User setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public User setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public User setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public User setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public User setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
		return this;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public User setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
		return this;
	}

	public String getAvatar() {
		return avatar;
	}

	public User setAvatar(String avatar) {
		this.avatar = avatar;
		return this;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public User setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
		return this;
	}

	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}

	public User setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		return this;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", revision=" + revision +
				", createBy='" + createBy + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				", deleteStatus=" + deleteStatus +
				", username='" + username + '\'' +
				", nickname='" + nickname + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", email='" + email + '\'' +
				", mobilePhone='" + mobilePhone + '\'' +
				", departmentId='" + departmentId + '\'' +
				", accountStatus=" + accountStatus +
				", avatar='" + avatar + '\'' +
				", lastLoginIp='" + lastLoginIp + '\'' +
				", lastLoginTime=" + lastLoginTime +
				'}';
	}
}
