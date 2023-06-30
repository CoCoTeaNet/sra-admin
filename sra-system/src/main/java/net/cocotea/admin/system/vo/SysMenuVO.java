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
public class SysMenuVO implements Serializable {

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

	private List<SysMenuVO> children;

	public String getId() {
		return id;
	}

	public SysMenuVO setId(String id) {
		this.id = id;
		return this;
	}

	public String getMenuName() {
		return menuName;
	}

	public SysMenuVO setMenuName(String menuName) {
		this.menuName = menuName;
		return this;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public SysMenuVO setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
		return this;
	}

	public String getRouterPath() {
		return routerPath;
	}

	public SysMenuVO setRouterPath(String routerPath) {
		this.routerPath = routerPath;
		return this;
	}

	public String getParentId() {
		return parentId;
	}

	public SysMenuVO setParentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public SysMenuVO setMenuType(Integer menuType) {
		this.menuType = menuType;
		return this;
	}

	public String getIsMenu() {
		return isMenu;
	}

	public SysMenuVO setIsMenu(String isMenu) {
		this.isMenu = isMenu;
		return this;
	}

	public Integer getMenuStatus() {
		return menuStatus;
	}

	public SysMenuVO setMenuStatus(Integer menuStatus) {
		this.menuStatus = menuStatus;
		return this;
	}

	public Integer getSort() {
		return sort;
	}

	public SysMenuVO setSort(Integer sort) {
		this.sort = sort;
		return this;
	}

	public String getComponentPath() {
		return componentPath;
	}

	public SysMenuVO setComponentPath(String componentPath) {
		this.componentPath = componentPath;
		return this;
	}

	public Integer getIsExternalLink() {
		return isExternalLink;
	}

	public SysMenuVO setIsExternalLink(Integer isExternalLink) {
		this.isExternalLink = isExternalLink;
		return this;
	}

	public String getIconPath() {
		return iconPath;
	}

	public SysMenuVO setIconPath(String iconPath) {
		this.iconPath = iconPath;
		return this;
	}

	public List<SysMenuVO> getChildren() {
		return children;
	}

	public SysMenuVO setChildren(List<SysMenuVO> children) {
		this.children = children;
		return this;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public SysMenuVO setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
		return this;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public SysMenuVO setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
