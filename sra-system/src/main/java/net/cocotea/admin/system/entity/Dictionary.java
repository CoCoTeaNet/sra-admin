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
	private Integer enableStatus;
	
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
	private Integer deleteStatus;

	public String getId() {
		return id;
	}

	public Dictionary setId(String id) {
		this.id = id;
		return this;
	}

	public String getParentId() {
		return parentId;
	}

	public Dictionary setParentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	public String getDictionaryName() {
		return dictionaryName;
	}

	public Dictionary setDictionaryName(String dictionaryName) {
		this.dictionaryName = dictionaryName;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public Dictionary setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getSort() {
		return sort;
	}

	public Dictionary setSort(Integer sort) {
		this.sort = sort;
		return this;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public Dictionary setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
		return this;
	}

	public Integer getRevision() {
		return revision;
	}

	public Dictionary setRevision(Integer revision) {
		this.revision = revision;
		return this;
	}

	public String getCreateBy() {
		return createBy;
	}

	public Dictionary setCreateBy(String createBy) {
		this.createBy = createBy;
		return this;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public Dictionary setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public Dictionary setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		return this;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public Dictionary setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public Dictionary setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
		return this;
	}

	@Override
	public String toString() {
		return "Dictionary{" +
				"id='" + id + '\'' +
				", parentId='" + parentId + '\'' +
				", dictionaryName='" + dictionaryName + '\'' +
				", remark='" + remark + '\'' +
				", sort=" + sort +
				", enableStatus=" + enableStatus +
				", revision=" + revision +
				", createBy='" + createBy + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				", deleteStatus=" + deleteStatus +
				'}';
	}
}
