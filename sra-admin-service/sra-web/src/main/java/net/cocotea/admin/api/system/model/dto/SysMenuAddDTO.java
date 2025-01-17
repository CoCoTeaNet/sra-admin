package net.cocotea.admin.api.system.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author CoCoTea
 * @project sss-rbac-admin
 * @version 2.0.0
 * @description sys_menu,系统菜单表  
 */
@Data
@Accessors(chain = true)
public class SysMenuAddDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = -4698497422245539378L;
	
	/**
	 * 菜单名称
	 */
	@NotBlank(message = "菜单名称为空")
	private String menuName;
	
	/**
	 * 权限编号
	 */
	private String permissionCode;
	
	/**
	 * 路由地址
	 */
	private String routerPath;
	
	/**
	 * 父主键ID
	 */
	private String parentId;
	
	/**
	 * 按钮类型;0目录 1菜单 2按钮
	 */
	private String menuType;
	
	/**
	 * 是否菜单
	 */
	@NotBlank(message = "是否菜单为空")
	private String isMenu;

	/**
	 * 菜单状态
	 */
	private String menuStatus;

	/**
	 * 显示顺序
	 */
	private Integer sort;
	
	/**
	 * 组件路径
	 */
	private String componentPath;
	
	/**
	 * 是否外链;0是 1否
	 */
	private String isExternalLink;
	
	/**
	 * 菜单图标
	 */
	private String iconPath;

}
