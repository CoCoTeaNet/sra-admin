package net.cocotea.admin.system.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import net.cocotea.admin.system.properties.DevEnableProperties;
import net.cocotea.admin.system.service.IMenuService;
import net.cocotea.admin.system.service.IRoleService;
import net.cocotea.admin.common.enums.IsSomethingEnum;
import net.cocotea.admin.system.vo.MenuVO;
import net.cocotea.admin.system.vo.RoleVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取用户权限集合
 *
 * @author jwss
 * @date 2022-1-17 16:06:44
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private IMenuService menuService;
    @Resource
    private IRoleService roleService;
    @Resource
    private DevEnableProperties devEnableProperties;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        StpUtil.checkLogin();
        List<MenuVO> cachePermissionList = menuService.getCachePermission((String) loginId);
        List<String> list;
        // 1关闭了缓存 2缓存失效了 3有缓存
        if (!devEnableProperties.getPermissionCache()) {
            List<MenuVO> menuList = menuService.listByUserId(IsSomethingEnum.N.getCode());
            list = new ArrayList<>(menuList.size());
            menuList.forEach(item -> list.add(item.getPermissionCode()));
        } else if (cachePermissionList == null) {
            List<MenuVO> permission = menuService.cachePermission((String) loginId);
            list = new ArrayList<>(permission.size());
            permission.forEach(i -> list.add(i.getPermissionCode()));
        } else {
            list = new ArrayList<>(cachePermissionList.size());
            cachePermissionList.forEach(i -> list.add(i.getPermissionCode()));
        }
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        StpUtil.checkLogin();
        RoleVO roleVO = roleService.loadByUserId((String) loginId);
        List<String> list = new ArrayList<>(1);
        list.add(roleVO.getRoleKey());
        return list;
    }
}
