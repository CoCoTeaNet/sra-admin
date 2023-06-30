package net.cocotea.admin.system.service.impl;

import net.cocotea.admin.common.enums.DeleteStatusEnum;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.entity.SysRole;
import net.cocotea.admin.system.param.role.SysRoleAddParam;
import net.cocotea.admin.system.param.role.SysRolePageParam;
import net.cocotea.admin.system.param.role.SysRoleUpdateParam;
import net.cocotea.admin.system.entity.SysRoleMenu;
import net.cocotea.admin.system.service.SysRoleService;
import net.cocotea.admin.system.vo.SysRoleMenuVO;
import net.cocotea.admin.system.vo.SysRoleVO;
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
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(SysRoleAddParam param) throws BusinessException {
        SysRole sysRole = sqlToyLazyDao.convertType(param, SysRole.class);
        SysRole existRole = sqlToyLazyDao.loadBySql(
                "select ID from sys_role where #[ROLE_KEY=:roleKey] and DELETE_STATUS=1",
                sysRole
        );
        if (existRole != null) {
            throw new BusinessException("已存在该角色标识");
        }
        Object id = sqlToyLazyDao.save(sysRole);
        return id != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) {
        List<SysRole> sysRoleList = new ArrayList<>();
        for (String id : idList) {
            SysRole article = new SysRole();
            article.setId(id);
            article.setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
            sysRoleList.add(article);
        }
        Long count = sqlToyLazyDao.updateAll(sysRoleList);
        return count > 0;
    }

    @Override
    public boolean update(SysRoleUpdateParam param) {
        SysRole sysRole = sqlToyLazyDao.convertType(param, SysRole.class);
        Long update = sqlToyLazyDao.update(sysRole);
        return update > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean grantPermissionsByRoleId(List<SysRoleMenuVO> sysRoleMenuVOList) throws BusinessException {
        List<SysRoleMenu> sysRoleMenuList = sqlToyLazyDao.convertType(sysRoleMenuVOList, SysRoleMenu.class);
        if (sysRoleMenuList.size() == 0) {
            throw new BusinessException("集合为空");
        }
        // 先删除所有权限再设置
        sqlToyLazyDao.deleteByQuery(
                SysRoleMenu.class,
                EntityQuery.create()
                        .where("#[role_id=:roleId]").names("roleId").values(sysRoleMenuList.get(0).getRoleId()));
        // 重新添加权限
        Long aLong = sqlToyLazyDao.saveOrUpdateAll(sysRoleMenuList);
        return aLong > 0;
    }

    @Override
    public List<SysRoleVO> loadByUserId(String userId) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("userId", userId);
        return sqlToyLazyDao.findBySql("system_role_loadByUserId", map, SysRoleVO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(String id) {
        // 删除角色
        Long aLong = sqlToyLazyDao.delete(new SysRole().setId(id));
        // 删除角色权限关联关系
        sqlToyLazyDao.deleteByQuery(
                SysRoleMenu.class,
                EntityQuery.create().where("#[role_id = :roleId ]").names("roleId").values(id));
        return aLong > 0;
    }

    @Override
    public Page<SysRoleVO> listByPage(SysRolePageParam param) {
        Page<SysRoleVO> page = sqlToyLazyDao.findPageBySql(param, "system_role_findByPageParam", param.getRole());
        return page;
    }
}
