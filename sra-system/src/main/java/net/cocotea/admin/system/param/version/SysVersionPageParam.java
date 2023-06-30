package net.cocotea.admin.system.param.version;

import net.cocotea.admin.system.vo.SysVersionVO;
import org.sagacity.sqltoy.model.Page;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SysVersionPageParam extends Page<SysVersionVO> implements Serializable {
	private static final long serialVersionUID = 2569886533383934522L;

	@NotNull(message = "version is null")
	private SysVersionVO version;

	public SysVersionVO getVersion() {
		return version;
	}

	public SysVersionPageParam setVersion(SysVersionVO version) {
		this.version = version;
		return this;
	}
}
