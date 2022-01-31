package com.jwss.sra.system.param.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_menu,系统菜单表  
 */
@ApiModel("菜单更新参数")
public class MenuUpdateParam implements Serializable {

	private static final long serialVersionUID = -4698497422245539378L;

	@NotBlank(message = "主键ID为空")
	@ApiModelProperty(value = "主键ID", required = true)
	private String id;

	/**
	 * 菜单名称
	 */
	@NotBlank(message = "菜单名称为空")
	@ApiModelProperty(value = "菜单名称", required = true)
	private String menuName;
	
	/**
	 * 权限编号
	 */
	@NotBlank(message = "权限编号为空")
	@ApiModelProperty(value = "权限编号", required = true)
	private String permissionCode;
	
	/**
	 * 路由地址
	 */
	@NotBlank(message = "路由地址为空")
	@ApiModelProperty(value = "路由地址", required = true)
	private String routerPath;
	
	/**
	 * 父主键ID
	 */
	@ApiModelProperty(value = "父主键ID")
	private String parentId;
	
	/**
	 * 按钮类型;0目录 1菜单 2按钮
	 */
	@NotBlank(message = "按钮类型为空")
	@ApiModelProperty(value = "按钮类型;0目录 1菜单 2按钮", required = true)
	private String menuType;
	
	/**
	 * 是否菜单
	 */
	@NotBlank(message = "是否菜单为空")
	@ApiModelProperty(value = "是否菜单", required = true)
	private String isMenu;
	
	/**
	 * 显示顺序
	 */
	@ApiModelProperty(value = "显示顺序")
	private Integer sort;
	
	/**
	 * 组件路径
	 */
	@NotBlank(message = "组件路径为空")
	@ApiModelProperty(value = "组件路径", required = true)
	private String componentPath;
	
	/**
	 * 是否外链;0是 1否
	 */
	@NotBlank(message = "是否外链为空")
	@ApiModelProperty(value = "是否外链;0是 1否", required = true)
	private String isExternalLink;
	
	/**
	 * 菜单图标
	 */
	@ApiModelProperty(value = "菜单图标")
	private String iconPath;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getRouterPath() {
		return routerPath;
	}

	public void setRouterPath(String routerPath) {
		this.routerPath = routerPath;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(String isMenu) {
		this.isMenu = isMenu;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getComponentPath() {
		return componentPath;
	}

	public void setComponentPath(String componentPath) {
		this.componentPath = componentPath;
	}

	public String getIsExternalLink() {
		return isExternalLink;
	}

	public void setIsExternalLink(String isExternalLink) {
		this.isExternalLink = isExternalLink;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
