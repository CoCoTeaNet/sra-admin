package com.jwss.sra.system.entity;

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
	private String deleteStatus;
	
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
	
	/** default constructor */
	public Role() {
	}
	
	/** pk constructor */
	public Role(String id)
	{
		this.id=id;
	}
	
	/**
	 *@param id the id to set
	 */
	public Role setId(String id) {
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
	public Role setRevision(Integer revision) {
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
	public Role setCreateBy(String createBy) {
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
	public Role setCreateTime(LocalDateTime createTime) {
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
	public Role setUpdateBy(String updateBy) {
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
	public Role setUpdateTime(LocalDateTime updateTime) {
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
	 *@param deleteStatus the deleteStatus to set
	 */
	public Role setDeleteStatus(String deleteStatus) {
		this.deleteStatus=deleteStatus;
		return this;
	}
		
	/**
	 *@return the DeleteStatus
	 */
	public String getDeleteStatus() {
	    return this.deleteStatus;
	}
	
	/**
	 *@param roleName the roleName to set
	 */
	public Role setRoleName(String roleName) {
		this.roleName=roleName;
		return this;
	}
		
	/**
	 *@return the RoleName
	 */
	public String getRoleName() {
	    return this.roleName;
	}
	
	/**
	 *@param roleKey the roleKey to set
	 */
	public Role setRoleKey(String roleKey) {
		this.roleKey=roleKey;
		return this;
	}
		
	/**
	 *@return the RoleKey
	 */
	public String getRoleKey() {
	    return this.roleKey;
	}
	
	/**
	 *@param sort the sort to set
	 */
	public Role setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
		
	/**
	 *@return the Sort
	 */
	public Integer getSort() {
	    return this.sort;
	}
	
	/**
	 *@param remark the remark to set
	 */
	public Role setRemark(String remark) {
		this.remark=remark;
		return this;
	}
		
	/**
	 *@return the Remark
	 */
	public String getRemark() {
	    return this.remark;
	}


	/**
     * @todo vo columns to String
     */
    @Override
	public String toString() {
		StringBuilder columnsBuffer=new StringBuilder();
		columnsBuffer.append("id=").append(getId()).append("\n");
		columnsBuffer.append("revision=").append(getRevision()).append("\n");
		columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
		columnsBuffer.append("createTime=").append(getCreateTime()).append("\n");
		columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
		columnsBuffer.append("updateTime=").append(getUpdateTime()).append("\n");
		columnsBuffer.append("deleteStatus=").append(getDeleteStatus()).append("\n");
		columnsBuffer.append("roleName=").append(getRoleName()).append("\n");
		columnsBuffer.append("roleKey=").append(getRoleKey()).append("\n");
		columnsBuffer.append("sort=").append(getSort()).append("\n");
		columnsBuffer.append("remark=").append(getRemark()).append("\n");
		return columnsBuffer.toString();
	}
	
}
