package com.jwss.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_menu,系统菜单表  
 */
@ApiModel("系统菜单表返回对象")
public class MenuVO implements Serializable {

	private static final long serialVersionUID = 6856092554842076547L;

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("菜单名称")
	private String menuName;
	
	@ApiModelProperty("权限编号")
	private String permissionCode;
	
	@ApiModelProperty("路由地址")
	private String routerPath;
	
	@ApiModelProperty("父主键ID")
	private String parentId;
	
	@ApiModelProperty("按钮类型;0目录 1菜单 2按钮")
	private String menuType;
	
	@ApiModelProperty("是否菜单")
	private String isMenu;
	
	@ApiModelProperty("显示顺序")
	private Integer sort;
	
	@ApiModelProperty("组件路径")
	private String componentPath;
	
	@ApiModelProperty("是否外链;0是 1否")
	private String isExternalLink;
	
	@ApiModelProperty("菜单图标")
	private String iconPath;

	@ApiModelProperty("菜单子节点")
	private MenuVO child;

	@Override
	public String toString() {
		return "MenuVO{" +
				"id='" + id + '\'' +
				", menuName='" + menuName + '\'' +
				", permissionCode='" + permissionCode + '\'' +
				", routerPath='" + routerPath + '\'' +
				", parentId='" + parentId + '\'' +
				", menuType='" + menuType + '\'' +
				", isMenu='" + isMenu + '\'' +
				", sort=" + sort +
				", componentPath='" + componentPath + '\'' +
				", isExternalLink='" + isExternalLink + '\'' +
				", iconPath='" + iconPath + '\'' +
				'}';
	}

	public MenuVO getChild() {
		return child;
	}

	public void setChild(MenuVO child) {
		this.child = child;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
}
