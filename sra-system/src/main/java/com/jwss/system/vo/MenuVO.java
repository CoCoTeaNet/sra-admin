package com.jwss.system.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_menu,系统菜单表  
 */
public class MenuVO implements Serializable {

	private static final long serialVersionUID = 6856092554842076547L;
	
/*---begin-auto-generate-don't-update-this-area--*/	
	/**
	 * 主键id
	 */
	private String id;
	
	/**
	 * 乐观锁
	 */
	private Integer revision;
	
	/**
	 * 创建人
	 */
	private String createBy;
	
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	
	/**
	 * 更新人
	 */
	private String updateBy;
	
	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
	
	/**
	 * 删除状态;0删除 1未删除
	 */
	private String deleteStatus;
	
	/**
	 * 菜单名称
	 */
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
	private String isMenu;
	
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
	
	
	/**
	 *@param id the id to set
	 */
	public MenuVO setId(String id) {
		this.id=id;
		return this;
	}
		
	/**
	 *@return the Id
	 */
	public String getId() {
	    return this.id;
	}
	
	/**
	 *@param revision the revision to set
	 */
	public MenuVO setRevision(Integer revision) {
		this.revision=revision;
		return this;
	}
		
	/**
	 *@return the Revision
	 */
	public Integer getRevision() {
	    return this.revision;
	}
	
	/**
	 *@param createBy the createBy to set
	 */
	public MenuVO setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
		
	/**
	 *@return the CreateBy
	 */
	public String getCreateBy() {
	    return this.createBy;
	}
	
	/**
	 *@param createTime the createTime to set
	 */
	public MenuVO setCreateTime(LocalDateTime createTime) {
		this.createTime=createTime;
		return this;
	}
		
	/**
	 *@return the CreateTime
	 */
	public LocalDateTime getCreateTime() {
	    return this.createTime;
	}
	
	/**
	 *@param updateBy the updateBy to set
	 */
	public MenuVO setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
		
	/**
	 *@return the UpdateBy
	 */
	public String getUpdateBy() {
	    return this.updateBy;
	}
	
	/**
	 *@param updateTime the updateTime to set
	 */
	public MenuVO setUpdateTime(LocalDateTime updateTime) {
		this.updateTime=updateTime;
		return this;
	}
		
	/**
	 *@return the UpdateTime
	 */
	public LocalDateTime getUpdateTime() {
	    return this.updateTime;
	}
	
	/**
	 *@param deleteStatus the deleteStatus to set
	 */
	public MenuVO setDeleteStatus(String deleteStatus) {
		this.deleteStatus=deleteStatus;
		return this;
	}
		
	/**
	 *@return the DeleteStatus
	 */
	public String getDeleteStatus() {
	    return this.deleteStatus;
	}
	
	/**
	 *@param menuName the menuName to set
	 */
	public MenuVO setMenuName(String menuName) {
		this.menuName=menuName;
		return this;
	}
		
	/**
	 *@return the MenuName
	 */
	public String getMenuName() {
	    return this.menuName;
	}
	
	/**
	 *@param permissionCode the permissionCode to set
	 */
	public MenuVO setPermissionCode(String permissionCode) {
		this.permissionCode=permissionCode;
		return this;
	}
		
	/**
	 *@return the PermissionCode
	 */
	public String getPermissionCode() {
	    return this.permissionCode;
	}
	
	/**
	 *@param routerPath the routerPath to set
	 */
	public MenuVO setRouterPath(String routerPath) {
		this.routerPath=routerPath;
		return this;
	}
		
	/**
	 *@return the RouterPath
	 */
	public String getRouterPath() {
	    return this.routerPath;
	}
	
	/**
	 *@param parentId the parentId to set
	 */
	public MenuVO setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
		
	/**
	 *@return the ParentId
	 */
	public String getParentId() {
	    return this.parentId;
	}
	
	/**
	 *@param menuType the menuType to set
	 */
	public MenuVO setMenuType(String menuType) {
		this.menuType=menuType;
		return this;
	}
		
	/**
	 *@return the MenuType
	 */
	public String getMenuType() {
	    return this.menuType;
	}
	
	/**
	 *@param isMenu the isMenu to set
	 */
	public MenuVO setIsMenu(String isMenu) {
		this.isMenu=isMenu;
		return this;
	}
		
	/**
	 *@return the IsMenu
	 */
	public String getIsMenu() {
	    return this.isMenu;
	}
	
	/**
	 *@param sort the sort to set
	 */
	public MenuVO setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
		
	/**
	 *@return the Sort
	 */
	public Integer getSort() {
	    return this.sort;
	}
	
	/**
	 *@param componentPath the componentPath to set
	 */
	public MenuVO setComponentPath(String componentPath) {
		this.componentPath=componentPath;
		return this;
	}
		
	/**
	 *@return the ComponentPath
	 */
	public String getComponentPath() {
	    return this.componentPath;
	}
	
	/**
	 *@param isExternalLink the isExternalLink to set
	 */
	public MenuVO setIsExternalLink(String isExternalLink) {
		this.isExternalLink=isExternalLink;
		return this;
	}
		
	/**
	 *@return the IsExternalLink
	 */
	public String getIsExternalLink() {
	    return this.isExternalLink;
	}
	
	/**
	 *@param iconPath the iconPath to set
	 */
	public MenuVO setIconPath(String iconPath) {
		this.iconPath=iconPath;
		return this;
	}
		
	/**
	 *@return the IconPath
	 */
	public String getIconPath() {
	    return this.iconPath;
	}

	/**
	* @todo vo columns to String
	*/
	@Override
	public String toString() {
		StringBuilder columnsBuffer=new StringBuilder();
			columnsBuffer.append("id=").append(getId()).append("\n");
			columnsBuffer.append("revision=").append(getRevision()).append("\n");
			columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
			columnsBuffer.append("createTime=").append(getCreateTime()).append("\n");
			columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
			columnsBuffer.append("updateTime=").append(getUpdateTime()).append("\n");
			columnsBuffer.append("deleteStatus=").append(getDeleteStatus()).append("\n");
			columnsBuffer.append("menuName=").append(getMenuName()).append("\n");
			columnsBuffer.append("permissionCode=").append(getPermissionCode()).append("\n");
			columnsBuffer.append("routerPath=").append(getRouterPath()).append("\n");
			columnsBuffer.append("parentId=").append(getParentId()).append("\n");
			columnsBuffer.append("menuType=").append(getMenuType()).append("\n");
			columnsBuffer.append("isMenu=").append(getIsMenu()).append("\n");
			columnsBuffer.append("sort=").append(getSort()).append("\n");
			columnsBuffer.append("componentPath=").append(getComponentPath()).append("\n");
			columnsBuffer.append("isExternalLink=").append(getIsExternalLink()).append("\n");
			columnsBuffer.append("iconPath=").append(getIconPath()).append("\n");
		return columnsBuffer.toString();
	}
/*---end-auto-generate-don't-update-this-area--*/	
}
