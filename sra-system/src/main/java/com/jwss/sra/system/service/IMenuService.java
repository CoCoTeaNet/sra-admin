package com.jwss.sra.system.service;

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
public interface IMenuService {
    /**
     * 新增菜单
     * @param param 新增菜单参数
     * @return 成功返回TRUE
     */
    boolean add(MenuAddParam param);

    /**
     * 批量移除
     * @param idList id集合
     * @return 成功返回true
     */
    boolean deleteBatch(List<String> idList);

    /**
     * 分页查询菜单
     * @param pageParam 分页参数
     * @return 分页结果集
     */
    Page<MenuVO> listByPage(MenuPageParam pageParam);

    /**
     * 分页查询菜单
     * @param pageParam 分页参数
     * @return 分页结果集
     */
    Page<MenuVO> listByTree(MenuPageParam pageParam);

    /**
     * 更新菜单
     * @param param 更新菜单参数
     * @return 成功返回TRUE
     */
    boolean update(MenuUpdateParam param);

    /**
     * 获取用户的所有菜单
     * @param isMenu 是否菜单
     * @return 用户菜单集合
     */
    List<MenuVO> listByUserId(String isMenu);

    /**
     * 删除菜单以及所有子菜单
     * @param id 主键id
     * @return 成功返回TRUE
     */
    boolean delete(String id);

    /**
     * 获取角色请所有菜单
     * @param roleId 角色主键id
     * @return 菜单列表
     */
    List<MenuVO> listByRoleId(String roleId);
}
