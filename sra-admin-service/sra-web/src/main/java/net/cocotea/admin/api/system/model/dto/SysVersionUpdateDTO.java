package net.cocotea.admin.api.system.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class SysVersionUpdateDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 6284028262600112043L;

	/**
	 * 版本ID
	 */
	@NotBlank(message = "id为空")
	private String id;

	/**
	 * 版本号
	 */
	private String updateNo;

	/**
	 * 更新描述
	 */
	private String updateDesc;

	/**
	 * 平台名称
	 */
	private String platformName;

	/**
	 * 下载地址
	 */
	private String downloadUrl;

}
