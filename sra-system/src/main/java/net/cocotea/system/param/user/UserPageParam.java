package net.cocotea.system.param.user;

import net.cocotea.system.vo.UserVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_menu,系统菜单表  
 */
public class UserPageParam extends Page<UserVO> implements Serializable{

	private static final long serialVersionUID = 5565588370362046172L;

	private UserVO userVO;

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
}
