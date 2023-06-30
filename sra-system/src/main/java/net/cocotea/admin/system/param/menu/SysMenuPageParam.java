package net.cocotea.admin.system.param.menu;

import net.cocotea.admin.system.vo.SysMenuVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_menu,系统菜单表  
 */
public class SysMenuPageParam extends Page<SysMenuVO> implements Serializable{

	private static final long serialVersionUID = -772057092053351688L;

	private SysMenuVO menu;

	public SysMenuVO getMenu() {
		return menu;
	}

	public SysMenuPageParam setMenu(SysMenuVO menu) {
		this.menu = menu;
		return this;
	}
}
