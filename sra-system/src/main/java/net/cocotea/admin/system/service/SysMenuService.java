package net.cocotea.admin.system.service;

import net.cocotea.admin.system.param.menu.SysMenuAddParam;
import net.cocotea.admin.system.param.menu.SysMenuPageParam;
import net.cocotea.admin.system.param.menu.SysMenuUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
import net.cocotea.admin.system.vo.SysMenuVO;
import org.sagacity.sqltoy.model.Page;

import java.util.Collection;
import java.util.List;

/**
 * @date 2022-1-16 15:47:03
 * @author jwss
 */
public interface SysMenuService extends IBaseService<Page<SysMenuVO>, SysMenuPageParam, SysMenuAddParam, SysMenuUpdateParam> {
    /**
     * 分页查询菜单
     * @param pageParam 分页参数
     * @return 分页结果集
     */
    Collection<SysMenuVO> listByTree(SysMenuPageParam param);

    /**
     * 获取用户的所有菜单
     * @param isMenu 是否菜单
     * @return 用户菜单集合
     */
    List<SysMenuVO> listByUserId(Integer isMenu);

    /**
     * 获取角色请所有菜单
     * @param roleId 角色主键id
     * @return 菜单列表
     */
    List<SysMenuVO> listByRoleId(String roleId);

    /**
     * 缓存用户权限
     * @param userId 用户主键id
     * @return 用户权限
     */
    List<SysMenuVO> cachePermission(String userId);

    /**
     * 获取用户缓存权限
     * @param userId 用户主键id
     * @return 用户权限
     */
    List<SysMenuVO> getCachePermission(String userId);

    Collection<SysMenuVO> listByTreeAsRoleSelection(SysMenuPageParam pageParam);
}
