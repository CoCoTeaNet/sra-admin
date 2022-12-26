package net.cocotea.admin.system.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.time.LocalDateTime;
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
	
	private Integer menuType;
	
	private String isMenu;

	private Integer menuStatus;
	
	private Integer sort;
	
	private String componentPath;
	
	private Integer isExternalLink;

	private String iconPath;

	private LocalDateTime createTime;
	private LocalDateTime updateTime;

	private List<MenuVO> children;

	public String getId() {
		return id;
	}

	public MenuVO setId(String id) {
		this.id = id;
		return this;
	}

	public String getMenuName() {
		return menuName;
	}

	public MenuVO setMenuName(String menuName) {
		this.menuName = menuName;
		return this;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public MenuVO setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
		return this;
	}

	public String getRouterPath() {
		return routerPath;
	}

	public MenuVO setRouterPath(String routerPath) {
		this.routerPath = routerPath;
		return this;
	}

	public String getParentId() {
		return parentId;
	}

	public MenuVO setParentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public MenuVO setMenuType(Integer menuType) {
		this.menuType = menuType;
		return this;
	}

	public String getIsMenu() {
		return isMenu;
	}

	public MenuVO setIsMenu(String isMenu) {
		this.isMenu = isMenu;
		return this;
	}

	public Integer getMenuStatus() {
		return menuStatus;
	}

	public MenuVO setMenuStatus(Integer menuStatus) {
		this.menuStatus = menuStatus;
		return this;
	}

	public Integer getSort() {
		return sort;
	}

	public MenuVO setSort(Integer sort) {
		this.sort = sort;
		return this;
	}

	public String getComponentPath() {
		return componentPath;
	}

	public MenuVO setComponentPath(String componentPath) {
		this.componentPath = componentPath;
		return this;
	}

	public Integer getIsExternalLink() {
		return isExternalLink;
	}

	public MenuVO setIsExternalLink(Integer isExternalLink) {
		this.isExternalLink = isExternalLink;
		return this;
	}

	public String getIconPath() {
		return iconPath;
	}

	public MenuVO setIconPath(String iconPath) {
		this.iconPath = iconPath;
		return this;
	}

	public List<MenuVO> getChildren() {
		return children;
	}

	public MenuVO setChildren(List<MenuVO> children) {
		this.children = children;
		return this;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public MenuVO setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
		return this;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public MenuVO setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
