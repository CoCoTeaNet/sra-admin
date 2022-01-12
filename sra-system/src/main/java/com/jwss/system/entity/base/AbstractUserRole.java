/**
 *@Generated by sagacity-quickvo 5.0
 */
package com.jwss.system.entity.base;

import java.io.Serializable;
import java.util.List;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;
import java.math.BigInteger;

/**
 * @project sss-rbac-admin
 * @version 1.0.0
 * Table: sys_user_role,Remark:用户角色关联表  
 */
@Entity(tableName="sys_user_role",pk_constraint="PRIMARY")
public abstract class AbstractUserRole implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7613126616310523569L;
	
	/**
	 * jdbcType:BIGINT
	 * 用户ID
	 */
	@Id
	@Column(name="user_id",length=19L,type=java.sql.Types.BIGINT,nullable=false)
	protected BigInteger userId;
	
	/**
	 * jdbcType:BIGINT
	 * 角色ID
	 */
	@Id
	@Column(name="role_id",length=19L,type=java.sql.Types.BIGINT,nullable=false)
	protected BigInteger roleId;
	
	/**
	 * jdbcType:VARCHAR
	 * 用户主键ID
	 */
	@Column(name="USER_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	protected String userId;
	
	/**
	 * jdbcType:VARCHAR
	 * 角色主键ID
	 */
	@Column(name="ROLE_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
	protected String roleId;
	
	/** default constructor */
	public AbstractUserRole() {
	}
	
	/** pk constructor */
	public AbstractUserRole(BigInteger userId,BigInteger roleId)
	{
		this.userId=userId;
		this.roleId=roleId;
	}
	
	/**
	 *@param userId the userId to set
	 */
	public void setUserId(BigInteger userId) {
		this.userId=userId;
	}
		
	/**
	 *@return the UserId
	 */
	public BigInteger getUserId() {
	    return this.userId;
	}
	
	/**
	 *@param roleId the roleId to set
	 */
	public void setRoleId(BigInteger roleId) {
		this.roleId=roleId;
	}
		
	/**
	 *@return the RoleId
	 */
	public BigInteger getRoleId() {
	    return this.roleId;
	}
	
	/**
	 *@param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId=userId;
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
	public void setRoleId(String roleId) {
		this.roleId=roleId;
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
		columnsBuffer.append("userId=").append(getUserId()).append("\n");
		columnsBuffer.append("roleId=").append(getRoleId()).append("\n");
		return columnsBuffer.toString();
	}
	
}
