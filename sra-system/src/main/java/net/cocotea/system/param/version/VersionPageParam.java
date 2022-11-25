package net.cocotea.system.param.version;

import net.cocotea.system.vo.VersionVO;
import org.sagacity.sqltoy.model.Page;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class VersionPageParam extends Page<VersionVO> implements Serializable {
	private static final long serialVersionUID = 2569886533383934522L;

	@NotNull(message = "version is null")
	private VersionVO version;

	public VersionVO getVersion() {
		return version;
	}

	public VersionPageParam setVersion(VersionVO version) {
		this.version = version;
		return this;
	}
}
