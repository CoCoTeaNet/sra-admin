package net.cocotea.admin.system.entity;

import java.io.Serializable;

import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * Table: sys_role_menu,Remark:角色菜单关联表  
 */
@Entity(tableName="sys_role_menu")
public class RoleMenu implements Serializable {

	private static final long serialVersionUID = 6844523408155256370L;

	/**
	 * jdbcType:VARCHAR
	 * 主键id
	 */
	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
	@Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String id;

	/**
	 * jdbcType:VARCHAR
	 * 角色主键ID
	 */
	@Column(name="ROLE_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String roleId;
	
	/**
	 * jdbcType:VARCHAR
	 * 菜单主键ID
	 */
	@Column(name="MENU_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String menuId;
	
	/** default constructor */
	public RoleMenu() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 *@param roleId the roleId to set
	 */
	public RoleMenu setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
		
	/**
	 *@return the RoleId
	 */
	public String getRoleId() {
	    return this.roleId;
	}
	
	/**
	 *@param menuId the menuId to set
	 */
	public RoleMenu setMenuId(String menuId) {
		this.menuId=menuId;
		return this;
	}
		
	/**
	 *@return the MenuId
	 */
	public String getMenuId() {
	    return this.menuId;
	}


	/**
     * @todo vo columns to String
     */
    @Override
	public String toString() {
		StringBuilder columnsBuffer=new StringBuilder();
		columnsBuffer.append("roleId=").append(getRoleId()).append("\n");
		columnsBuffer.append("menuId=").append(getMenuId()).append("\n");
		return columnsBuffer.toString();
	}
	
}
