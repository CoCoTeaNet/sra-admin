package net.cocotea.admin.system.entity;

import java.io.Serializable;

import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * Table: sys_user_role,Remark:用户角色关联表  
 */
@Entity(tableName="sys_user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 7063853937784637106L;

	@Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
	@Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String id;

	/**
	 * jdbcType:VARCHAR
	 * 用户主键ID
	 */
	@Column(name="USER_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String userId;
	
	/**
	 * jdbcType:VARCHAR
	 * 角色主键ID
	 */
	@Column(name="ROLE_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	private String roleId;
	
	/** default constructor */
	public UserRole() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 *@param userId the userId to set
	 */
	public UserRole setUserId(String userId) {
		this.userId=userId;
		return this;
	}
		
	/**
	 *@return the UserId
	 */
	public String getUserId() {
	    return this.userId;
	}
	
	/**
	 *@param roleId the roleId to set
	 */
	public UserRole setRoleId(String roleId) {
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
     * @todo vo columns to String
     */
    @Override
	public String toString() {
		StringBuilder columnsBuffer=new StringBuilder();
		columnsBuffer.append("userId=").append(getUserId()).append("\n");
		columnsBuffer.append("roleId=").append(getRoleId()).append("\n");
		return columnsBuffer.toString();
	}
	
}
