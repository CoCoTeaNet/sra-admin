package net.cocotea.admin.system.param.version;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class VersionUpdateParam implements Serializable {

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

	public VersionUpdateParam setId(String id) {
		this.id = id;
		return this;
	}

	public String getUpdateNo() {
		return updateNo;
	}

	public VersionUpdateParam setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
		return this;
	}

	public String getUpdateDesc() {
		return updateDesc;
	}

	public VersionUpdateParam setUpdateDesc(String updateDesc) {
		this.updateDesc = updateDesc;
		return this;
	}

	public String getPlatformName() {
		return platformName;
	}

	public VersionUpdateParam setPlatformName(String platformName) {
		this.platformName = platformName;
		return this;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public VersionUpdateParam setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
		return this;
	}
}
