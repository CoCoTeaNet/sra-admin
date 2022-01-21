package com.jwss.system.service.impl;

import com.jwss.common.model.BusinessException;
import com.jwss.system.entity.Role;
import com.jwss.system.entity.RoleMenu;
import com.jwss.system.param.role.RoleAddParam;
import com.jwss.system.param.role.RolePageParam;
import com.jwss.system.param.role.RoleUpdateParam;
import com.jwss.system.service.IRoleService;
import com.jwss.system.vo.RoleMenuVO;
import com.jwss.system.vo.RoleVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    public boolean update(RoleUpdateParam param) {
        Role role = sqlToyLazyDao.convertType(param, Role.class);
        Long update = sqlToyLazyDao.update(role);
        return update > 0;
    }

    @Override
    public List<RoleVO> findAll() {
        return sqlToyLazyDao.findBySql(
                "select ID,ROLE_NAME,ROLE_KEY where DELETE_STATUS=1",
                null
        );
    }

    @Override
    public boolean grantPermissionsByRoleId(List<RoleMenuVO> roleMenuVOList) {
        List<RoleMenu> roleMenuList = sqlToyLazyDao.convertType(roleMenuVOList, RoleMenu.class);
        Long aLong = sqlToyLazyDao.saveOrUpdateAll(roleMenuList);
        return aLong > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(String id) {
        // 删除角色
        sqlToyLazyDao.delete(new Role().setId(id));
        // 删除角色权限关联关系
        Long aLong = sqlToyLazyDao.delete(new RoleMenu().setRoleId(id));
        return aLong > 0;
    }

    @Override
    public Page<RoleVO> listByPage(RolePageParam param) {
        Page<RoleVO> page = sqlToyLazyDao.findPageBySql(param, "system_role_findByEntityParam", param.getRoleVO());
        return page;
    }
}
