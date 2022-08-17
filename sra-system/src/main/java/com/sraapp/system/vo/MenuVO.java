package com.sraapp.system.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_menu,系统菜单表  
 */
public class MenuVO implements Serializable {

	private static final long serialVersionUID = 6856092554842076547L;

	private String id;
	
	private String menuName;
	
	private String permissionCode;
	
	private String routerPath;
	
	private String parentId;
	
	private String menuType;
	
	private String isMenu;

	private String menuStatus;
	
	private Integer sort;
	
	private String componentPath;
	
	private String isExternalLink;
	
	private String iconPath;

	private List<MenuVO> children;

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
				", menuStatus='" + menuStatus + '\'' +
				", sort=" + sort +
				", componentPath='" + componentPath + '\'' +
				", isExternalLink='" + isExternalLink + '\'' +
				", iconPath='" + iconPath + '\'' +
				", children=" + children +
				'}';
	}

	public String getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}

	public List<MenuVO> getChildren() {
		return children;
	}

	public void setChildren(List<MenuVO> children) {
		this.children = children;
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
