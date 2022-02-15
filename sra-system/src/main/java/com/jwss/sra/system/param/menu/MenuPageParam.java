package com.jwss.sra.system.param.menu;

import com.jwss.sra.system.vo.MenuVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * @author jwss
 * @project sss-rbac-admin
 * @version 1.0.0
 * @description sys_menu,系统菜单表  
 */
@ApiModel("菜单分页参数")
public class MenuPageParam extends Page<MenuVO> implements Serializable{

	private static final long serialVersionUID = -772057092053351688L;

	@ApiModelProperty(value = "菜单属性")
	private MenuVO menuVO;

	public MenuVO getMenuVO() {
		return menuVO;
	}

	public void setMenuVO(MenuVO menuVO) {
		this.menuVO = menuVO;
	}
}
