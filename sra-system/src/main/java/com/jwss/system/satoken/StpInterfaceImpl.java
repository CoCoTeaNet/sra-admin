package com.jwss.system.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.jwss.system.service.IMenuService;
import com.jwss.system.vo.MenuVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取用户权限集合
 * @date 2022-1-17 16:06:44
 * @author jwss
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private IMenuService menuService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<MenuVO> menuList = menuService.listByUserId();
        List<String> list = new ArrayList<>();
        menuList.forEach(item -> list.add(item.getPermissionCode()));
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
