package com.sraapp.system.service;

import com.sraapp.common.model.BusinessException;
import com.sraapp.common.service.IBaseService;
import com.sraapp.system.param.role.RoleAddParam;
import com.sraapp.system.param.role.RolePageParam;
import com.sraapp.system.param.role.RoleUpdateParam;
import com.sraapp.system.vo.RoleMenuVO;
import com.sraapp.system.vo.RoleVO;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * 角色服务类
 * @date 2022-1-17 17:14:06
 * @author jwss
 */
public interface IRoleService extends IBaseService<Page<RoleVO>, RolePageParam, RoleAddParam, RoleUpdateParam> {
    /**
     * 给角色赋予权限
     * @param roleMenuVOList 角色菜单列表
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    boolean grantPermissionsByRoleId(List<RoleMenuVO> roleMenuVOList) throws BusinessException;

    /**
     * 通过用户ID获取角色
     * @param userId 用户id
     * @return 角色
     */
    RoleVO loadByUserId(String userId);
}
