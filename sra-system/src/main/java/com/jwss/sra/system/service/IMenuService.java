package com.jwss.sra.system.service;

import com.jwss.sra.common.service.IBaseService;
import com.jwss.sra.system.param.menu.MenuAddParam;
import com.jwss.sra.system.param.menu.MenuPageParam;
import com.jwss.sra.system.param.menu.MenuUpdateParam;
import com.jwss.sra.system.vo.MenuVO;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * @date 2022-1-16 15:47:03
 * @author jwss
 */
public interface IMenuService extends IBaseService<Page<MenuVO>, MenuPageParam, MenuAddParam, MenuUpdateParam> {
    /**
     * 分页查询菜单
     * @param pageParam 分页参数
     * @return 分页结果集
     */
    Page<MenuVO> listByTree(MenuPageParam pageParam);

    /**
     * 获取用户的所有菜单
     * @param isMenu 是否菜单
     * @return 用户菜单集合
     */
    List<MenuVO> listByUserId(String isMenu);

    /**
     * 获取角色请所有菜单
     * @param roleId 角色主键id
     * @return 菜单列表
     */
    List<MenuVO> listByRoleId(String roleId);
}
