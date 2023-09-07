package net.cocotea.admin.system.service.impl;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.sagframe.sagacity.sqltoy.plus.conditions.Wrappers;
import com.sagframe.sagacity.sqltoy.plus.conditions.query.LambdaQueryWrapper;
import com.sagframe.sagacity.sqltoy.plus.dao.SqlToyHelperDao;
import net.cocotea.admin.system.entity.SysUser;
import net.cocotea.admin.system.properties.DefaultProperties;
import net.cocotea.admin.common.enums.IsEnum;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.util.TreeBuilder;
import net.cocotea.admin.common.util.SecurityUtils;
import net.cocotea.admin.framework.constant.RedisKey;
import net.cocotea.admin.framework.service.IRedisService;
import net.cocotea.admin.framework.util.IpUtils;
import net.cocotea.admin.system.entity.SysUserRole;
import net.cocotea.admin.system.param.user.SysUserAddParam;
import net.cocotea.admin.system.param.login.SysLoginParam;
import net.cocotea.admin.system.param.user.SysUserPageParam;
import net.cocotea.admin.system.param.user.SysUserUpdateParam;
import net.cocotea.admin.system.properties.DevEnableProperties;
import net.cocotea.admin.system.service.SysMenuService;
import net.cocotea.admin.system.service.SysUserService;
import net.cocotea.admin.system.vo.SysLoginUserVO;
import net.cocotea.admin.system.vo.SysMenuVO;
import net.cocotea.admin.system.vo.SysUserVO;
import net.cocotea.admin.common.enums.DeleteStatusEnum;
import net.cocotea.admin.common.enums.LogTypeEnum;
import net.cocotea.admin.system.service.SysOperationLogService;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.EntityQuery;
import org.sagacity.sqltoy.model.Page;
import org.sagacity.sqltoy.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author CoCoTea
 * @date 2022-1-12 15:35:00
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private final TreeBuilder<SysMenuVO> dsUtils = new TreeBuilder<>();

    @Resource
    private DevEnableProperties devEnableProperties;

    @Resource
    private DefaultProperties defaultProperties;

    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Resource
    private SqlToyHelperDao sqlToyHelperDao;

    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private IRedisService redisService;

    @Resource
    private SysOperationLogService sysOperationLogService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(SysUserAddParam param) {
        SysUser sysUser = sqlToyLazyDao.convertType(param, SysUser.class);
        if (StringUtil.isNotBlank(param.getPassword())) {
            sysUser.setPassword(SecurityUtils.buildMd5Pwd(param.getPassword(), defaultProperties.getSalt()));
        } else {
            sysUser.setPassword(defaultProperties.getPassword());
        }
        Object userId = sqlToyLazyDao.save(sysUser);
        // 授予用户角色
        if (!(param.getRoleIds().isEmpty())) {
            for (String roleId : param.getRoleIds()) {
                SysUserRole userRole = new SysUserRole().setUserId(String.valueOf(userId)).setRoleId(roleId);
                sqlToyLazyDao.save(userRole);
            }
        }
        return userId != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(SysUserUpdateParam param) {
        SysUser sysUser = sqlToyLazyDao.convertType(param, SysUser.class);
        if (!(param.getRoleIds() == null || param.getRoleIds().isEmpty())) {
            sqlToyLazyDao.deleteByQuery(SysUserRole.class, EntityQuery.create().where("USER_ID=:userId").names("userId").values(param.getId()));
            // 删除用户角色再新增
            sqlToyLazyDao.deleteByQuery(
                    SysUserRole.class,
                    EntityQuery.create().where("USER_ID = :userId").names("userId").values(param.getId())
            );
            for (String roleId : param.getRoleIds()) {
                SysUserRole userRole = new SysUserRole().setUserId(param.getId()).setRoleId(roleId);
                sqlToyLazyDao.save(userRole);
            }
        }
        // 更新密码
        if (StringUtil.isNotBlank(param.getPassword())) {
            sysUser.setPassword(SecurityUtils.buildMd5Pwd(param.getPassword(), defaultProperties.getSalt()));
        }
        Long flag = sqlToyLazyDao.update(sysUser);
        return flag > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(String id) {
        // 删除用户
        SysUser sysUser = new SysUser().setId(id).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        Long aLong = sqlToyLazyDao.update(sysUser);
        // 删除用户关联关系
        sqlToyLazyDao.deleteByQuery(SysUserRole.class, EntityQuery.create().where("USER_ID=:userId").names("userId").values(sysUser.getId()));
        return aLong > 0;
    }

    @Override
    public boolean deleteBatch(List<String> idList) {
        if (idList != null) {
            idList.forEach(this::delete);
        }
        return idList != null && idList.size() > 0;
    }

    @Override
    public Page<SysUserVO> listByPage(SysUserPageParam param) {
        Page<SysUserVO> page = sqlToyLazyDao.findPageBySql(
                param,
                "system_user_findByPageParam",
                param.getUser()
        );
        return page;
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public SysLoginUserVO login(SysLoginParam param, HttpServletRequest request) throws BusinessException {
        SysUser sysUser;
        // 判断是否启用了强密码
        if (StringUtil.isBlank(devEnableProperties.getStrongPassword()) || !devEnableProperties.getStrongPassword().equals(param.getPassword())) {
            // 校验验证码
            String code = redisService.get(String.format(RedisKey.VERIFY_CODE, "LOGIN", IpUtils.getIp(request)));
            if (!param.getCaptcha().equals(code)) {
                throw new BusinessException("验证码错误");
            }
            // 校验密码
            sysUser = sqlToyLazyDao.convertType(param, SysUser.class);
            sysUser.setPassword(SecurityUtils.buildMd5Pwd(param.getPassword(), defaultProperties.getSalt()));
            sysUser = sqlToyLazyDao.loadBySql("system_user_findByEntityParam", sysUser);
            if (sysUser == null) {
                throw new BusinessException("登录失败，用户名或密码错误");
            }
        } else {
            sysUser = sqlToyLazyDao.loadBySql("system_user_findByEntityParam", new SysUser().setUsername(param.getUsername()));
        }
        // 记住我模式
        if (param.getRememberMe()) {
            StpUtil.login(
                    sysUser.getId(),
                    new SaLoginModel().setTimeout(3600 * 24 * 31)
            );
        } else {
            StpUtil.login(sysUser.getId());
        }
        // 更新用户登录时间和ip
        SysUser loginSysUser = new SysUser();
        loginSysUser.setId(sysUser.getId());
        loginSysUser.setLastLoginIp(IpUtils.getIp(request));
        loginSysUser.setLastLoginTime(LocalDateTime.now());
        sqlToyLazyDao.update(loginSysUser);
        // 缓存权限
        sysMenuService.cachePermission(sysUser.getId());
        // 保存登录日志
        sysOperationLogService.saveByLogType(LogTypeEnum.LOGIN.getCode(), request);
        return setLoginUser(sysUser);
    }

    @Override
    public SysUserVO getDetail() {
        SysUserVO sysUserVO = new SysUserVO();
        sysUserVO.setId(String.valueOf(StpUtil.getLoginId()));
        return sqlToyLazyDao.loadBySql("system_user_findByEntityParam", sysUserVO);
    }

    @Override
    public SysLoginUserVO loginUser() {
        SysUser sysUser = sqlToyLazyDao.loadBySql(
                "system_user_findByEntityParam",
                new SysUser().setId(String.valueOf(StpUtil.getLoginId()))
        );
        return setLoginUser(sysUser);
    }

    @Override
    public boolean doModifyPassword(String oldPassword, String newPassword) throws BusinessException {
        if (StringUtil.isBlank(oldPassword)) {
            throw new BusinessException("旧密码为空");
        }
        if (StringUtil.isBlank(newPassword)) {
            throw new BusinessException("新密码为空");
        }
        String loginId = (String) StpUtil.getLoginId();

        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers
                .lambdaWrapper(SysUser.class)
                .select(SysUser::getId)
                .select(SysUser::getPassword)
                .eq(SysUser::getId, loginId)
                .eq(SysUser::getDeleteStatus, DeleteStatusEnum.NOT_DELETE.getCode());
        SysUser sysUser = sqlToyHelperDao.findOne(queryWrapper);

        String md5PwdOld = SecurityUtils.buildMd5Pwd(oldPassword, defaultProperties.getSalt());
        if (!sysUser.getPassword().equals(md5PwdOld)) {
            throw new BusinessException("旧密码不正确");
        }
        String md5PwdNew = SecurityUtils.buildMd5Pwd(newPassword, defaultProperties.getSalt());
        sysUser.setPassword(md5PwdNew);
        return sqlToyHelperDao.update(sysUser) > 0;
    }

    private SysLoginUserVO setLoginUser(SysUser sysUser) {
        SysLoginUserVO sysLoginUserVO = new SysLoginUserVO();
        List<SysMenuVO> menuList = sysMenuService.listByUserId(IsEnum.Y.getCode());
        Map<String, SysMenuVO> menuMap = new TreeBuilder<SysMenuVO>().build(menuList);
        sysLoginUserVO.setMenuList(new ArrayList<>(menuMap.values()));
        sysLoginUserVO.setUsername(sysUser.getUsername());
        sysLoginUserVO.setNickname(sysUser.getNickname());
        sysLoginUserVO.setAvatar(sysUser.getAvatar());
        sysLoginUserVO.setId(sysUser.getId());
        sysLoginUserVO.setLoginStatus(true);
        sysLoginUserVO.setToken(StpUtil.getTokenValue());
        return sysLoginUserVO;
    }
}
