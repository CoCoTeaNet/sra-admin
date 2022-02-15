package com.jwss.sra.system.entity;

import java.io.Serializable;

import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;
import java.time.LocalDateTime;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * Table: sys_menu,Remark:系统菜单表  
 */
@Entity(tableName="sys_menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 5698424234803324100L;
	
	/**
	 * jdbcType:VARCHAR
	 * 主键id
	 */
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
	@Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String id;
	
	/**
	 * jdbcType:INT
	 * 乐观锁
	 */
	@Column(name="REVISION",length=10L,type=java.sql.Types.INTEGER,nullable=true)
	private Integer revision;
	
	/**
	 * jdbcType:VARCHAR
	 * 创建人
	 */
	@Column(name="CREATE_BY",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String createBy;
	
	/**
	 * jdbcType:DATETIME
	 * 创建时间
	 */
	@Column(name="CREATE_TIME",length=19L,type=java.sql.Types.DATE,nullable=false)
	private LocalDateTime createTime;
	
	/**
	 * jdbcType:VARCHAR
	 * 更新人
	 */
	@Column(name="UPDATE_BY",length=32L,type=java.sql.Types.VARCHAR,nullable=true)
	private String updateBy;
	
	/**
	 * jdbcType:DATETIME
	 * 更新时间
	 */
	@Column(name="UPDATE_TIME",length=19L,type=java.sql.Types.DATE,nullable=true)
	private LocalDateTime updateTime;
	
	/**
	 * jdbcType:VARCHAR
	 * 删除状态;0删除 1未删除
	 */
	@Column(name="DELETE_STATUS",length=255L,type=java.sql.Types.VARCHAR,nullable=true)
	private String deleteStatus;
	
	/**
	 * jdbcType:VARCHAR
	 * 菜单名称
	 */
	@Column(name="MENU_NAME",length=30L,type=java.sql.Types.VARCHAR,nullable=false)
	private String menuName;
	
	/**
	 * jdbcType:VARCHAR
	 * 权限编号
	 */
	@Column(name="PERMISSION_CODE",length=64L,type=java.sql.Types.VARCHAR,nullable=false)
	private String permissionCode;
	
	/**
	 * jdbcType:VARCHAR
	 * 路由地址
	 */
	@Column(name="ROUTER_PATH",length=255L,type=java.sql.Types.VARCHAR,nullable=false)
	private String routerPath;
	
	/**
	 * jdbcType:VARCHAR
	 * 父主键ID
	 */
	@Column(name="PARENT_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=true)
	private String parentId;
	
	/**
	 * jdbcType:CHAR
	 * 按钮类型;0目录 1菜单 2按钮
	 */
	@Column(name="MENU_TYPE",length=1L,type=java.sql.Types.CHAR,nullable=false)
	private String menuType;
	
	/**
	 * jdbcType:CHAR
	 * 是否菜单
	 */
	@Column(name="IS_MENU",length=1L,type=java.sql.Types.CHAR,nullable=false)
	private String isMenu;
	
	/**
	 * jdbcType:INT
	 * 显示顺序
	 */
	@Column(name="SORT",length=10L,type=java.sql.Types.INTEGER,nullable=false)
	private Integer sort;
	
	/**
	 * jdbcType:VARCHAR
	 * 组件路径
	 */
	@Column(name="COMPONENT_PATH",length=64L,type=java.sql.Types.VARCHAR,nullable=true)
	private String componentPath;
	
	/**
	 * jdbcType:CHAR
	 * 是否外链;0是 1否
	 */
	@Column(name="IS_EXTERNAL_LINK",length=1L,type=java.sql.Types.CHAR,nullable=false)
	private String isExternalLink;
	
	/**
	 * jdbcType:VARCHAR
	 * 菜单图标
	 */
	@Column(name="ICON_PATH",length=255L,type=java.sql.Types.VARCHAR,nullable=true)
	private String iconPath;
	
	/** default constructor */
	public Menu() {
	}
	
	/** pk constructor */
	public Menu(String id)
	{
		this.id=id;
	}
	
	/**
	 *@param id the id to set
	 */
	public Menu setId(String id) {
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
	public Menu setRevision(Integer revision) {
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
	public Menu setCreateBy(String createBy) {
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
	public Menu setCreateTime(LocalDateTime createTime) {
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
	public Menu setUpdateBy(String updateBy) {
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
	public Menu setUpdateTime(LocalDateTime updateTime) {
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
	public Menu setDeleteStatus(String deleteStatus) {
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
	public Menu setMenuName(String menuName) {
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
	public Menu setPermissionCode(String permissionCode) {
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
	public Menu setRouterPath(String routerPath) {
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
	public Menu setParentId(String parentId) {
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
	public Menu setMenuType(String menuType) {
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
	public Menu setIsMenu(String isMenu) {
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
	public Menu setSort(Integer sort) {
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
	public Menu setComponentPath(String componentPath) {
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
	public Menu setIsExternalLink(String isExternalLink) {
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
	public Menu setIconPath(String iconPath) {
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
	
}
