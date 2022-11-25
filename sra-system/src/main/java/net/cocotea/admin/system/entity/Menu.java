package net.cocotea.admin.system.entity;

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
	private Integer deleteStatus;
	
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
	private Integer menuType;
	
	/**
	 * jdbcType:CHAR
	 * 是否菜单
	 */
	@Column(name="IS_MENU",length=1L,type=java.sql.Types.CHAR,nullable=false)
	private Integer isMenu;

	/**
	 * jdbcType:CHAR
	 * 0显示&启用 1隐藏&关闭 2显示&关闭 3隐藏&启用
	 */
	@Column(name="MENU_STATUS",length=1L,type=java.sql.Types.CHAR,nullable=false)
	private Integer menuStatus;
	
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
	private Integer isExternalLink;
	
	/**
	 * jdbcType:VARCHAR
	 * 菜单图标
	 */
	@Column(name="ICON_PATH",length=255L,type=java.sql.Types.VARCHAR,nullable=true)
	private String iconPath;

	public String getId() {
		return id;
	}

	public Menu setId(String id) {
		this.id = id;
		return this;
	}

	public Integer getRevision() {
		return revision;
	}

	public Menu setRevision(Integer revision) {
		this.revision = revision;
		return this;
	}

	public String getCreateBy() {
		return createBy;
	}

	public Menu setCreateBy(String createBy) {
		this.createBy = createBy;
		return this;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public Menu setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public Menu setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		return this;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public Menu setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public Menu setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
		return this;
	}

	public String getMenuName() {
		return menuName;
	}

	public Menu setMenuName(String menuName) {
		this.menuName = menuName;
		return this;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public Menu setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
		return this;
	}

	public String getRouterPath() {
		return routerPath;
	}

	public Menu setRouterPath(String routerPath) {
		this.routerPath = routerPath;
		return this;
	}

	public String getParentId() {
		return parentId;
	}

	public Menu setParentId(String parentId) {
		this.parentId = parentId;
		return this;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public Menu setMenuType(Integer menuType) {
		this.menuType = menuType;
		return this;
	}

	public Integer getIsMenu() {
		return isMenu;
	}

	public Menu setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
		return this;
	}

	public Integer getMenuStatus() {
		return menuStatus;
	}

	public Menu setMenuStatus(Integer menuStatus) {
		this.menuStatus = menuStatus;
		return this;
	}

	public Integer getSort() {
		return sort;
	}

	public Menu setSort(Integer sort) {
		this.sort = sort;
		return this;
	}

	public String getComponentPath() {
		return componentPath;
	}

	public Menu setComponentPath(String componentPath) {
		this.componentPath = componentPath;
		return this;
	}

	public Integer getIsExternalLink() {
		return isExternalLink;
	}

	public Menu setIsExternalLink(Integer isExternalLink) {
		this.isExternalLink = isExternalLink;
		return this;
	}

	public String getIconPath() {
		return iconPath;
	}

	public Menu setIconPath(String iconPath) {
		this.iconPath = iconPath;
		return this;
	}

	@Override
	public String toString() {
		return "Menu{" +
				"id='" + id + '\'' +
				", revision=" + revision +
				", createBy='" + createBy + '\'' +
				", createTime=" + createTime +
				", updateBy='" + updateBy + '\'' +
				", updateTime=" + updateTime +
				", deleteStatus=" + deleteStatus +
				", menuName='" + menuName + '\'' +
				", permissionCode='" + permissionCode + '\'' +
				", routerPath='" + routerPath + '\'' +
				", parentId='" + parentId + '\'' +
				", menuType=" + menuType +
				", isMenu=" + isMenu +
				", menuStatus=" + menuStatus +
				", sort=" + sort +
				", componentPath='" + componentPath + '\'' +
				", isExternalLink=" + isExternalLink +
				", iconPath='" + iconPath + '\'' +
				'}';
	}
}
