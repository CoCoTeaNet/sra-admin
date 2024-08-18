package net.cocotea.admin.api.system.service.impl;

import cn.hutool.core.convert.Convert;
import com.sagframe.sagacity.sqltoy.plus.conditions.Wrappers;
import com.sagframe.sagacity.sqltoy.plus.conditions.query.LambdaQueryWrapper;
import com.sagframe.sagacity.sqltoy.plus.dao.SqlToyHelperDao;
import net.cocotea.admin.api.system.model.dto.SysRoleAddDTO;
import net.cocotea.admin.api.system.model.dto.SysRolePageDTO;
import net.cocotea.admin.api.system.model.dto.SysRoleUpdateDTO;
import net.cocotea.admin.api.system.model.po.SysRole;
import net.cocotea.admin.api.system.model.po.SysRoleMenu;
import net.cocotea.admin.api.system.model.po.SysUserRole;
import net.cocotea.admin.api.system.model.vo.SysRoleMenuVO;
import net.cocotea.admin.api.system.model.vo.SysRoleVO;
import net.cocotea.admin.api.system.model.vo.SysUserRoleVO;
import net.cocotea.admin.api.system.service.SysRoleService;
import net.cocotea.admin.common.enums.IsEnum;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.BusinessException;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CoCoTea
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SqlToyHelperDao sqlToyHelperDao;

    @Override
    public boolean add(SysRoleAddDTO addDTO) throws BusinessException {
        SysRole sysRole = sqlToyHelperDao.convertType(addDTO, SysRole.class);
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>(SysRole.class)
                .select(SysRole::getId)
                .eq(SysRole::getRoleKey, addDTO.getRoleKey())
                .eq(SysRole::getIsDeleted, IsEnum.N.getCode());
        SysRole existSysRole = sqlToyHelperDao.findOne(wrapper);
        if (existSysRole != null) {
            throw new BusinessException("已存在该角色标识");
        }
        Object id = sqlToyHelperDao.save(sysRole);
        return id != null;
    }

    @Override
    public boolean deleteBatch(List<BigInteger> idList) {
        List<SysRole> sysRoleList = new ArrayList<>();
        for (BigInteger id : idList) {
            SysRole article = new SysRole();
            article.setId(id);
            article.setIsDeleted(IsEnum.Y.getCode());
            sysRoleList.add(article);
        }
        Long count = sqlToyHelperDao.updateAll(sysRoleList);
        return count > 0;
    }

    @Override
    public boolean update(SysRoleUpdateDTO updateDTO) {
        SysRole sysRole = sqlToyHelperDao.convertType(updateDTO, SysRole.class);
        Long update = sqlToyHelperDao.update(sysRole);
        return update > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean grantPermissionsByRoleId(List<SysRoleMenuVO> sysRoleMenuVOList) throws BusinessException {
        List<SysRoleMenu> sysRoleMenuList = sqlToyHelperDao.convertType(sysRoleMenuVOList, SysRoleMenu.class);
        if (sysRoleMenuList.isEmpty()) {
            throw new BusinessException("集合为空");
        }
        // 先删除所有权限再设置
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = Wrappers.lambdaWrapper(SysRoleMenu.class)
                .eq(SysRoleMenu::getRoleId, sysRoleMenuList.get(0).getRoleId());
        sqlToyHelperDao.delete(queryWrapper);
        // 重新添加权限
        long saved = sqlToyHelperDao.saveOrUpdateAll(sysRoleMenuList);
        return saved > 0;
    }

    @Override
    public List<SysRoleVO> loadByUserId(BigInteger userId) {
        // 角色与用户关联
        LambdaQueryWrapper<SysUserRoleVO> userRoleWrapper = new LambdaQueryWrapper<>(SysUserRoleVO.class)
                .select(SysUserRoleVO::getRoleId)
                .eq(SysUserRoleVO::getUserId, userId);
        List<BigInteger> roleIds = sqlToyHelperDao
                .findList(userRoleWrapper).stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        // 角色列表
        LambdaQueryWrapper<SysRole> roleWrapper = new LambdaQueryWrapper<>(SysRole.class)
                .select(SysRole::getId).select(SysRole::getRoleName).select(SysRole::getRoleKey)
                .in(SysRole::getId, roleIds)
                .eq(SysRole::getIsDeleted, IsEnum.N.getCode());
        List<SysRole> list = sqlToyHelperDao.findList(roleWrapper);
        return Convert.toList(SysRoleVO.class, list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(BigInteger id) {
        // 删除角色
        sqlToyHelperDao.delete(new SysRole().setId(id));
        // 删除角色权限关联关系
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = Wrappers.lambdaWrapper(SysRoleMenu.class)
                        .eq(SysRoleMenu::getRoleId, id);
        long deleted = sqlToyHelperDao.delete(queryWrapper);
        return deleted > 0;
    }

    @Override
    public ApiPage<SysRoleVO> listByPage(SysRolePageDTO pageDTO) {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>(SysRole.class)
                .select()
                .eq(SysRole::getIsDeleted, IsEnum.N.getCode())
                .like(SysRole::getRoleName, pageDTO.getSysRole().getRoleName())
                .like(SysRole::getRoleKey, pageDTO.getSysRole().getRoleKey())
                .like(SysRole::getRemark, pageDTO.getSysRole().getRemark())
                .orderByDesc(SysRole::getSort)
                .orderByDesc(SysRole::getId);
        Page<SysRole> page = sqlToyHelperDao.findPage(wrapper, new Page<SysRole>());
        return ApiPage.rest(page, SysRoleVO.class);
    }
}
