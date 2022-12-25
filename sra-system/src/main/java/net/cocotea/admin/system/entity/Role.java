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
 * Table: sys_role,Remark:系统角色表  
 */
@Entity(tableName="sys_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 5393144765802306160L;
	
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
	 * 角色名称
	 */
	@Column(name="ROLE_NAME",length=30L,type=java.sql.Types.VARCHAR,nullable=false)
	private String roleName;
	
	/**
	 * jdbcType:VARCHAR
	 * 角色标识
	 */
	@Column(name="ROLE_KEY",length=255L,type=java.sql.Types.VARCHAR,nullable=false)
	private String roleKey;
	
	/**
	 * jdbcType:INT
	 * 显示排序
	 */
	@Column(name="SORT",length=10L,type=java.sql.Types.INTEGER,nullable=false)
	private Integer sort;
	
	/**
	 * jdbcType:VARCHAR
	 * 备注
	 */
	@Column(name="REMARK",length=255L,type=java.sql.Types.VARCHAR,nullable=true)
	private String remark;

	public String getId() {
		return id;
	}

	public Role setId(String id) {
		this.id = id;
		return this;
	}

	public Integer getRevision() {
		return revision;
	}

	public Role setRevision(Integer revision) {
		this.revision = revision;
		return this;
	}

	public String getCreateBy() {
		return createBy;
	}

	public Role setCreateBy(String createBy) {
		this.createBy = createBy;
		return this;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public Role setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public Role setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		return this;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public Role setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public Role setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
		return this;
	}

	public String getRoleName() {
		return roleName;
	}

	public Role setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public Role setRoleKey(String roleKey) {
		this.roleKey = roleKey;
		return this;
	}

	public Integer getSort() {
		return sort;
	}

	public Role setSort(Integer sort) {
		this.sort = sort;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Role setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id='" + id + '\'' +
				", revision=" + revision +
				", createBy='" + createBy + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				", deleteStatus=" + deleteStatus +
				", roleName='" + roleName + '\'' +
				", roleKey='" + roleKey + '\'' +
				", sort=" + sort +
				", remark='" + remark + '\'' +
				'}';
	}
}
