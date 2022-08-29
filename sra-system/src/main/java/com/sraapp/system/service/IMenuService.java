package com.sraapp.system.service;

import com.sraapp.common.service.IBaseService;
import com.sraapp.system.param.menu.MenuAddParam;
import com.sraapp.system.param.menu.MenuPageParam;
import com.sraapp.system.param.menu.MenuUpdateParam;
import com.sraapp.system.vo.MenuVO;
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
    List<MenuVO> listByUserId(Integer isMenu);

    /**
     * 获取角色请所有菜单
     * @param roleId 角色主键id
     * @return 菜单列表
     */
    List<MenuVO> listByRoleId(String roleId);

    /**
     * 缓存用户权限
     * @param userId 用户主键id
     * @return 用户权限
     */
    List<MenuVO> cachePermission(String userId);

    /**
     * 获取用户缓存权限
     * @param userId 用户主键id
     * @return 用户权限
     */
    List<MenuVO> getCachePermission(String userId);
}
