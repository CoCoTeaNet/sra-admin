package net.cocotea.admin.common.model;

import net.cocotea.admin.common.constant.CharConstant;

import java.io.Serializable;

/**
* 文件信息表
*
* @author CoCoTea 572315466@qq.com
* @since 1.2.1 2022-12-29
*/
public class FileInfo implements Serializable {
	private static final long serialVersionUID = 1L;

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
	 *文件大小（单位：字节）
	 */
	private Long fileSize;

	/**
	 * 文件目录
	 */
	private String fileDir;

	/**
	 * 文件基础路径
	 */
	private String fileBasePath;

	public String getFileName() {
		return fileName;
	}

	public FileInfo setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public FileInfo setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
		return this;
	}

	public String getRealPath() {
		return realPath;
	}

	public FileInfo setRealPath(String realPath) {
		this.realPath = realPath;
		return this;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public FileInfo setFileSize(Long fileSize) {
		this.fileSize = fileSize;
		return this;
	}

	public String getFileDir() {
		return fileDir;
	}

	public FileInfo setFileDir(String fileDir) {
		this.fileDir = fileDir;
		return this;
	}

	public String getFileBasePath() {
		return fileBasePath;
	}

	public FileInfo setFileBasePath(String fileBasePath) {
		this.fileBasePath = fileBasePath;
		return this;
	}

	@Override
	public String toString() {
		return "FileInfo{" +
				"fileName='" + fileName + '\'' +
				", fileSuffix='" + fileSuffix + '\'' +
				", realPath='" + realPath + '\'' +
				", fileSize=" + fileSize +
				", fileDir='" + fileDir + '\'' +
				", fileBasePath='" + fileBasePath + '\'' +
				'}';
	}
}