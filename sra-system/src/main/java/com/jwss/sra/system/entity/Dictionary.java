package com.jwss.sra.system.entity;

import java.io.Serializable;
import java.util.List;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.SqlToyEntity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;
import java.time.LocalDateTime;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * Table: sys_dictionary,Remark:系统字典表  
 */
@Entity(tableName="sys_dictionary")
public class Dictionary implements Serializable {

	private static final long serialVersionUID = 78532353037063296L;
	
	/**
	 * jdbcType:VARCHAR
	 * 主键id
	 */
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
	@Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String id;
	
	/**
	 * jdbcType:VARCHAR
	 * 父级ID
	 */
	@Column(name="PARENT_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=true)
	private String parentId;
	
	/**
	 * jdbcType:VARCHAR
	 * 字典名称
	 */
	@Column(name="DICTIONARY_NAME",length=30L,type=java.sql.Types.VARCHAR,nullable=false)
	private String dictionaryName;
	
	/**
	 * jdbcType:VARCHAR
	 * 备注
	 */
	@Column(name="REMARK",length=255L,type=java.sql.Types.VARCHAR,nullable=true)
	private String remark;
	
	/**
	 * jdbcType:INT
	 * 排序号
	 */
	@Column(name="SORT",length=10L,type=java.sql.Types.INTEGER,nullable=false)
	private Integer sort;
	
	/**
	 * jdbcType:CHAR
	 * 启用状态;0关闭 1启用
	 */
	@Column(name="ENABLE_STATUS",length=1L,type=java.sql.Types.CHAR,nullable=true)
	private String enableStatus;
	
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
	@Column(name="DELETE_STATUS",length=1L,type=java.sql.Types.CHAR,nullable=true)
	private String deleteStatus;
	
	/** default constructor */
	public Dictionary() {
	}
	
	/** pk constructor */
	public Dictionary(String id)
	{
		this.id=id;
	}
	
	/**
	 *@param id the id to set
	 */
	public Dictionary setId(String id) {
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
	public Dictionary setParentId(String parentId) {
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
	public Dictionary setDictionaryName(String dictionaryName) {
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
	public Dictionary setRemark(String remark) {
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
	public Dictionary setSort(Integer sort) {
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
	public Dictionary setEnableStatus(String enableStatus) {
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
	public Dictionary setRevision(Integer revision) {
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
	public Dictionary setCreateBy(String createBy) {
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
	public Dictionary setCreateTime(LocalDateTime createTime) {
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
	public Dictionary setUpdateBy(String updateBy) {
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
	public Dictionary setUpdateTime(LocalDateTime updateTime) {
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
	public Dictionary setDeleteStatus(String deleteStatus) {
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
	
}
