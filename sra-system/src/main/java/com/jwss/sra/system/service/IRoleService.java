package com.jwss.sra.system.service;

import com.jwss.sra.common.model.BusinessException;
import com.jwss.sra.common.service.IBaseService;
import com.jwss.sra.system.param.role.RoleAddParam;
import com.jwss.sra.system.param.role.RolePageParam;
import com.jwss.sra.system.param.role.RoleUpdateParam;
import com.jwss.sra.system.vo.RoleMenuVO;
import com.jwss.sra.system.vo.RoleVO;
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
}
