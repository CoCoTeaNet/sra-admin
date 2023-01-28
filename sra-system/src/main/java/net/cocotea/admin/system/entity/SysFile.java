package net.cocotea.admin.system.entity;

import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
* 系统文件表
*
* @author CoCoTea 572315466@qq.com
* @since 1.2.1 2022-12-28
*/
@Entity(tableName="sys_file")
public class SysFile implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *主键ID
	 */
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
	@Column(name="ID",type=java.sql.Types.VARCHAR)
	private String id;
	/**
	 *文件名称
	 */
	@Column(name="FILE_NAME",type=java.sql.Types.VARCHAR)
	private String fileName;
	/**
	 *文件后缀
	 */
	@Column(name="FILE_SUFFIX",type=java.sql.Types.VARCHAR)
	private String fileSuffix;
	/**
	 *文件真实路径
	 */
	@Column(name="REAL_PATH",type=java.sql.Types.VARCHAR)
	private String realPath;
	/**
	 *浏览路径
	 */
	@Column(name="BROWSE_PATH",type=java.sql.Types.VARCHAR)
	private String browsePath;
	/**
	 *文件访问地址
	 */
	@Column(name="FULL_PATH",type=java.sql.Types.VARCHAR)
	private String fullPath;
	/**
	 *文件大小（单位：字节）
	 */
	@Column(name="FILE_SIZE",type=java.sql.Types.BIGINT)
	private Long fileSize;
	/**
	 *创建人
	 */
	@Column(name="CREATE_BY",type=java.sql.Types.VARCHAR)
	private String createBy;
	/**
	 *创建时间
	 */
	@Column(name="CREATE_TIME",type=java.sql.Types.TIMESTAMP)
	private Date createTime;
	/**
	 *更新人
	 */
	@Column(name="UPDATE_BY",type=java.sql.Types.VARCHAR)
	private String updateBy;
	/**
	 *更新时间
	 */
	@Column(name="UPDATE_TIME",type=java.sql.Types.TIMESTAMP)
	private Date updateTime;
	/**
	 *删除状态：0删除 1未删除
	 */
	@Column(name="DELETE_STATUS",type=java.sql.Types.TINYINT)
	private Integer deleteStatus;

	public String getId() {
		return id;
	}

	public SysFile setId(String id) {
		this.id = id;
		return this;
	}

	public String getFileName() {
		return fileName;
	}

	public SysFile setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}
	public String getFileSuffix() {
		return fileSuffix;
	}

	public SysFile setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
		return this;
	}
	public String getRealPath() {
		return realPath;
	}

	public SysFile setRealPath(String realPath) {
		this.realPath = realPath;
		return this;
	}
	public String getBrowsePath() {
		return browsePath;
	}

	public SysFile setBrowsePath(String browsePath) {
		this.browsePath = browsePath;
		return this;
	}
	public String getFullPath() {
		return fullPath;
	}

	public SysFile setFullPath(String fullPath) {
		this.fullPath = fullPath;
		return this;
	}
	public Long getFileSize() {
		return fileSize;
	}

	public SysFile setFileSize(Long fileSize) {
		this.fileSize = fileSize;
		return this;
	}
	public String getCreateBy() {
		return createBy;
	}

	public SysFile setCreateBy(String createBy) {
		this.createBy = createBy;
		return this;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public SysFile setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	public String getUpdateBy() {
		return updateBy;
	}

	public SysFile setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		return this;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public SysFile setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}
	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public SysFile setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}