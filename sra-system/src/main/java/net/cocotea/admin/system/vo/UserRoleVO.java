package net.cocotea.admin.system.vo;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_user_role,用户角色关联表  
 */
public class UserRoleVO implements Serializable {

	private static final long serialVersionUID = 4531576278077869409L;
	
/*---begin-auto-generate-don't-update-this-area--*/	
	/**
	 * 用户主键ID
	 */
	private String userId;
	
	/**
	 * 角色主键ID
	 */
	private String roleId;
	
	
	/**
	 *@param userId the userId to set
	 */
	public UserRoleVO setUserId(String userId) {
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
	public UserRoleVO setRoleId(String roleId) {
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
/*---end-auto-generate-don't-update-this-area--*/	
}
