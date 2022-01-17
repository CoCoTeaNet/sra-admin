package com.jwss.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 获取用户权限集合
 * @date 2022-1-17 16:06:44
 * @author jwss
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
