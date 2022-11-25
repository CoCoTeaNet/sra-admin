package net.cocotea.admin.system.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_role,系统角色表  
 */
public class RoleVO implements Serializable {

	private static final long serialVersionUID = 2107981556352042830L;
	
	/*---begin-auto-generate-don't-update-this-area--*/
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
	 * 删除状态;0删除 1未删除
	 */
	private String deleteStatus;
	
	/**
	 * 角色名称
	 */
	private String roleName;

	private String roleId;
	
	/**
	 * 角色标识
	 */
	private String roleKey;
	
	/**
	 * 显示排序
	 */
	private Integer sort;
	
	/**
	 * 备注
	 */
	private String remark;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 *@param id the id to set
	 */
	public RoleVO setId(String id) {
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
	public RoleVO setRevision(Integer revision) {
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
	public RoleVO setCreateBy(String createBy) {
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
	public RoleVO setCreateTime(LocalDateTime createTime) {
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
	public RoleVO setUpdateBy(String updateBy) {
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
	public RoleVO setUpdateTime(LocalDateTime updateTime) {
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
	public RoleVO setDeleteStatus(String deleteStatus) {
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
	public RoleVO setRoleName(String roleName) {
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
	public RoleVO setRoleKey(String roleKey) {
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
	public RoleVO setSort(Integer sort) {
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
	public RoleVO setRemark(String remark) {
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
/*---end-auto-generate-don't-update-this-area--*/	
}
