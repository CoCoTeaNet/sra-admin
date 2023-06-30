package net.cocotea.admin.system.param.version;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class SysVersionUpdateParam implements Serializable {

	private static final long serialVersionUID = 6284028262600112043L;

	@NotBlank(message = "id为空")
	private String id;
	private String updateNo;
	private String updateDesc;
	private String platformName;
	private String downloadUrl;

	public String getId() {
		return id;
	}

	public SysVersionUpdateParam setId(String id) {
		this.id = id;
		return this;
	}

	public String getUpdateNo() {
		return updateNo;
	}

	public SysVersionUpdateParam setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
		return this;
	}

	public String getUpdateDesc() {
		return updateDesc;
	}

	public SysVersionUpdateParam setUpdateDesc(String updateDesc) {
		this.updateDesc = updateDesc;
		return this;
	}

	public String getPlatformName() {
		return platformName;
	}

	public SysVersionUpdateParam setPlatformName(String platformName) {
		this.platformName = platformName;
		return this;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public SysVersionUpdateParam setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
		return this;
	}
}
