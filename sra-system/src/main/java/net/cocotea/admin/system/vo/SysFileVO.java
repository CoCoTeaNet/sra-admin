package net.cocotea.admin.system.vo;

import java.io.Serializable;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.util.Date;

/**
* 系统文件表
*
* @author CoCoTea 572315466@qq.com
* @since 1.2.1 2022-12-28
*/
public class SysFileVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *主键ID
	 */
	private String id;

	/**
	 *文件名称
	 */
	private String fileName;

	/**
	 *文件后缀
	 */
	private String fileSuffix;

	/**
	 *文件真实路径
	 */
	private String realPath;

	/**
	 *浏览路径
	 */
	private String browsePath;

	/**
	 *文件访问地址
	 */
	private String fullPath;

	/**
	 *文件大小（单位：字节）
	 */
	private Long fileSize;

	/**
	 *创建人
	 */
	private String createBy;

	/**
	 *创建时间
	 */
	private Date createTime;

	/**
	 *更新人
	 */
	private String updateBy;

	/**
	 *更新时间
	 */
	private Date updateTime;

	/**
	 *删除状态：0删除 1未删除
	 */
	private Integer deleteStatus;

	private LocalDateTime beginTime;
	private LocalDateTime endTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public SysFileVO setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}
	public String getFileSuffix() {
		return fileSuffix;
	}

	public SysFileVO setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
		return this;
	}
	public String getRealPath() {
		return realPath;
	}

	public SysFileVO setRealPath(String realPath) {
		this.realPath = realPath;
		return this;
	}
	public String getBrowsePath() {
		return browsePath;
	}

	public SysFileVO setBrowsePath(String browsePath) {
		this.browsePath = browsePath;
		return this;
	}
	public String getFullPath() {
		return fullPath;
	}

	public SysFileVO setFullPath(String fullPath) {
		this.fullPath = fullPath;
		return this;
	}
	public Long getFileSize() {
		return fileSize;
	}

	public SysFileVO setFileSize(Long fileSize) {
		this.fileSize = fileSize;
		return this;
	}
	public String getCreateBy() {
		return createBy;
	}

	public SysFileVO setCreateBy(String createBy) {
		this.createBy = createBy;
		return this;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public SysFileVO setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	public String getUpdateBy() {
		return updateBy;
	}

	public SysFileVO setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		return this;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public SysFileVO setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}
	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public SysFileVO setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
		return this;
	}

	public LocalDateTime getBeginTime() {
		return beginTime;
	}

	public SysFileVO setBeginTime(LocalDateTime beginTime) {
		this.beginTime = beginTime;
		return this;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public SysFileVO setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}