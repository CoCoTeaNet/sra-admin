package net.cocotea.admin.api.system.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author CoCoTea
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_user,系统用户表  
 */
@Data
@Accessors(chain = true)
public class SysLoginDTO implements Serializable {

	private static final long serialVersionUID = -75070990767806255L;

	@NotBlank(message = "账号名不能为空")
	private String username;
	
	@NotBlank(message = "密码不能为空")
	private String password;

	@NotBlank(message = "验证码不能为空")
	private String captcha;

	private Boolean rememberMe;

}
