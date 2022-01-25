package com.jwss.system.service;

import com.jwss.common.model.BusinessException;
import com.jwss.system.param.role.RoleAddParam;
import com.jwss.system.param.role.RolePageParam;
import com.jwss.system.param.role.RoleUpdateParam;
import com.jwss.system.vo.RoleMenuVO;
import com.jwss.system.vo.RoleVO;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * 角色服务类
 * @date 2022-1-17 17:14:06
 * @author jwss
 */
public interface IRoleService {

    /**
     * 角色新增
     * @param param 角色新增参数
     * @return 成功返回TRUE
     * @throws BusinessException 异常
     */
    boolean add(RoleAddParam param) throws BusinessException;

    /**
     * 角色更新
     * @param param 角色更新参数
     * @return 成功true
     */
    boolean update(RoleUpdateParam param);

    /**
     * 查找所有角色
     * @return 角色集合
     */
    List<RoleVO> findAll();

    /**
     * 给角色赋予权限
     * @param roleMenuVOList 角色菜单列表
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    boolean grantPermissionsByRoleId(List<RoleMenuVO> roleMenuVOList) throws BusinessException;

    /**
     * 删除角色
     * @param id 角色id
     * @return 成功返回true
     */
    boolean delete(String id);

    /**
     * 分页获取角色
     * @param param 分页参数
     * @return 角色分页集合
     */
    Page<RoleVO> listByPage(RolePageParam param);
}
