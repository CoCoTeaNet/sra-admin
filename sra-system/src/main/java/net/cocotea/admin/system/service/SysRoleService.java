package net.cocotea.admin.system.service;

import net.cocotea.admin.system.param.role.SysRoleAddParam;
import net.cocotea.admin.system.param.role.SysRolePageParam;
import net.cocotea.admin.system.param.role.SysRoleUpdateParam;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.service.IBaseService;
import net.cocotea.admin.system.vo.SysRoleMenuVO;
import net.cocotea.admin.system.vo.SysRoleVO;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * 角色服务类
 * @date 2022-1-17 17:14:06
 * @author jwss
 */
public interface SysRoleService extends IBaseService<Page<SysRoleVO>, SysRolePageParam, SysRoleAddParam, SysRoleUpdateParam> {
    /**
     * 给角色赋予权限
     * @param sysRoleMenuVOList 角色菜单列表
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    boolean grantPermissionsByRoleId(List<SysRoleMenuVO> sysRoleMenuVOList) throws BusinessException;

    /**
     * 通过用户ID获取角色
     * @param userId 用户id
     * @return 角色
     */
    List<SysRoleVO> loadByUserId(String userId);
}
