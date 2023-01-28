package net.cocotea.admin.system.param.file;

import java.io.Serializable;
import com.alibaba.fastjson.JSONObject;
import java.util.Date;

/**
* 系统文件表
*
* @author CoCoTea 572315466@qq.com
* @since 1.2.1 2022-12-28
*/
public class SysFileUpdateParam implements Serializable {
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public SysFileUpdateParam setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}
	public String getFileSuffix() {
		return fileSuffix;
	}

	public SysFileUpdateParam setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
		return this;
	}
	public String getRealPath() {
		return realPath;
	}

	public SysFileUpdateParam setRealPath(String realPath) {
		this.realPath = realPath;
		return this;
	}
	public String getBrowsePath() {
		return browsePath;
	}

	public SysFileUpdateParam setBrowsePath(String browsePath) {
		this.browsePath = browsePath;
		return this;
	}
	public String getFullPath() {
		return fullPath;
	}

	public SysFileUpdateParam setFullPath(String fullPath) {
		this.fullPath = fullPath;
		return this;
	}
	public Long getFileSize() {
		return fileSize;
	}

	public SysFileUpdateParam setFileSize(Long fileSize) {
		this.fileSize = fileSize;
		return this;
	}
	public String getCreateBy() {
		return createBy;
	}

	public SysFileUpdateParam setCreateBy(String createBy) {
		this.createBy = createBy;
		return this;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public SysFileUpdateParam setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	public String getUpdateBy() {
		return updateBy;
	}

	public SysFileUpdateParam setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		return this;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public SysFileUpdateParam setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}
	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public SysFileUpdateParam setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}