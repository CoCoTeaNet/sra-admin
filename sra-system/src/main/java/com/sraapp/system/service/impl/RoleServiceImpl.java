package com.sraapp.system.service.impl;

import com.sraapp.common.enums.DeleteStatusEnum;
import com.sraapp.common.model.BusinessException;
import com.sraapp.system.entity.User;
import com.sraapp.system.entity.UserRole;
import com.sraapp.system.param.role.RoleAddParam;
import com.sraapp.system.param.role.RolePageParam;
import com.sraapp.system.param.role.RoleUpdateParam;
import com.sraapp.system.entity.Role;
import com.sraapp.system.entity.RoleMenu;
import com.sraapp.system.service.IRoleService;
import com.sraapp.system.vo.RoleMenuVO;
import com.sraapp.system.vo.RoleVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.EntityQuery;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jwss
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(RoleAddParam param) throws BusinessException {
        Role role = sqlToyLazyDao.convertType(param, Role.class);
        Role existRole = sqlToyLazyDao.loadBySql(
                "select ID from sys_role where #[ROLE_KEY=:roleKey] and DELETE_STATUS=1",
                role
        );
        if (existRole != null) {
            throw new BusinessException("已存在该角色标识");
        }
        Object id = sqlToyLazyDao.save(role);
        return id != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) {
        List<Role> roleList = new ArrayList<>();
        for (String id : idList) {
            Role article = new Role();
            article.setId(id);
            article.setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
            roleList.add(article);
        }
        Long count = sqlToyLazyDao.updateAll(roleList);
        return count > 0;
    }

    @Override
    public boolean update(RoleUpdateParam param) {
        Role role = sqlToyLazyDao.convertType(param, Role.class);
        Long update = sqlToyLazyDao.update(role);
        return update > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean grantPermissionsByRoleId(List<RoleMenuVO> roleMenuVOList) throws BusinessException {
        List<RoleMenu> roleMenuList = sqlToyLazyDao.convertType(roleMenuVOList, RoleMenu.class);
        if (roleMenuList.size() == 0) {
            throw new BusinessException("集合为空");
        }
        // 先删除所有权限再设置
        sqlToyLazyDao.deleteByQuery(
                RoleMenu.class,
                EntityQuery.create()
                        .where("#[role_id=:roleId]").names("roleId").values(roleMenuList.get(0).getRoleId()));
        // 重新添加权限
        Long aLong = sqlToyLazyDao.saveOrUpdateAll(roleMenuList);
        return aLong > 0;
    }

    @Override
    public RoleVO loadByUserId(String userId) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("userId", userId);
        return sqlToyLazyDao.loadBySql("system_role_loadByUserId", map, RoleVO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(String id) {
        // 删除角色
        Long aLong = sqlToyLazyDao.delete(new Role().setId(id));
        // 删除角色权限关联关系
        sqlToyLazyDao.deleteByQuery(
                RoleMenu.class,
                EntityQuery.create().where("#[role_id = :roleId ]").names("roleId").values(id));
        return aLong > 0;
    }

    @Override
    public Page<RoleVO> listByPage(RolePageParam param) {
        Page<RoleVO> page = sqlToyLazyDao.findPageBySql(param, "system_role_findByPageParam", param.getRoleVO());
        return page;
    }
}
