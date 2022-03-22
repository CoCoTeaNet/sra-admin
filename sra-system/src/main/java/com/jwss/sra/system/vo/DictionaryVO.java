package com.jwss.sra.system.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_dictionary,系统字典表  
 */
public class DictionaryVO implements Serializable {

	private static final long serialVersionUID = 79792592030448781L;
	
/*---begin-auto-generate-don't-update-this-area--*/	
	/**
	 * 主键id
	 */
	private String id;
	
	/**
	 * 父级ID
	 */
	private String parentId;
	
	/**
	 * 字典名称
	 */
	private String dictionaryName;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 排序号
	 */
	private Integer sort;
	
	/**
	 * 启用状态;0关闭 1启用
	 */
	private String enableStatus;
	
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
	 *@param id the id to set
	 */
	public DictionaryVO setId(String id) {
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
	 *@param parentId the parentId to set
	 */
	public DictionaryVO setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
		
	/**
	 *@return the ParentId
	 */
	public String getParentId() {
	    return this.parentId;
	}
	
	/**
	 *@param dictionaryName the dictionaryName to set
	 */
	public DictionaryVO setDictionaryName(String dictionaryName) {
		this.dictionaryName=dictionaryName;
		return this;
	}
		
	/**
	 *@return the DictionaryName
	 */
	public String getDictionaryName() {
	    return this.dictionaryName;
	}
	
	/**
	 *@param remark the remark to set
	 */
	public DictionaryVO setRemark(String remark) {
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
	 *@param sort the sort to set
	 */
	public DictionaryVO setSort(Integer sort) {
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
	 *@param enableStatus the enableStatus to set
	 */
	public DictionaryVO setEnableStatus(String enableStatus) {
		this.enableStatus=enableStatus;
		return this;
	}
		
	/**
	 *@return the EnableStatus
	 */
	public String getEnableStatus() {
	    return this.enableStatus;
	}
	
	/**
	 *@param revision the revision to set
	 */
	public DictionaryVO setRevision(Integer revision) {
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
	public DictionaryVO setCreateBy(String createBy) {
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
	public DictionaryVO setCreateTime(LocalDateTime createTime) {
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
	public DictionaryVO setUpdateBy(String updateBy) {
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
	public DictionaryVO setUpdateTime(LocalDateTime updateTime) {
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
	public DictionaryVO setDeleteStatus(String deleteStatus) {
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
	* @todo vo columns to String
	*/
	@Override
	public String toString() {
		StringBuilder columnsBuffer=new StringBuilder();
			columnsBuffer.append("id=").append(getId()).append("\n");
			columnsBuffer.append("parentId=").append(getParentId()).append("\n");
			columnsBuffer.append("dictionaryName=").append(getDictionaryName()).append("\n");
			columnsBuffer.append("remark=").append(getRemark()).append("\n");
			columnsBuffer.append("sort=").append(getSort()).append("\n");
			columnsBuffer.append("enableStatus=").append(getEnableStatus()).append("\n");
			columnsBuffer.append("revision=").append(getRevision()).append("\n");
			columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
			columnsBuffer.append("createTime=").append(getCreateTime()).append("\n");
			columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
			columnsBuffer.append("updateTime=").append(getUpdateTime()).append("\n");
			columnsBuffer.append("deleteStatus=").append(getDeleteStatus()).append("\n");
		return columnsBuffer.toString();
	}
/*---end-auto-generate-don't-update-this-area--*/	
}
