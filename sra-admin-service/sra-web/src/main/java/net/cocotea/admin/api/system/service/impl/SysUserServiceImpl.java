package net.cocotea.admin.api.system.service.impl;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.sagframe.sagacity.sqltoy.plus.conditions.Wrappers;
import com.sagframe.sagacity.sqltoy.plus.conditions.query.LambdaQueryWrapper;
import com.sagframe.sagacity.sqltoy.plus.conditions.update.LambdaUpdateWrapper;
import com.sagframe.sagacity.sqltoy.plus.dao.SqlToyHelperDao;
import net.cocotea.admin.api.system.model.dto.*;
import net.cocotea.admin.api.system.model.po.SysUser;
import net.cocotea.admin.api.system.model.po.SysUserRole;
import net.cocotea.admin.api.system.model.vo.*;
import net.cocotea.admin.api.system.service.SysLogService;
import net.cocotea.admin.api.system.service.SysMenuService;
import net.cocotea.admin.api.system.service.SysRoleService;
import net.cocotea.admin.api.system.service.SysUserService;
import net.cocotea.admin.common.constant.RedisKeyConst;
import net.cocotea.admin.common.enums.IsEnum;
import net.cocotea.admin.common.enums.LogTypeEnum;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.service.RedisService;
import net.cocotea.admin.common.util.IpUtils;
import net.cocotea.admin.common.util.TreeBuilder;
import net.cocotea.admin.properties.DefaultProp;
import net.cocotea.admin.util.LoginUtils;
import net.cocotea.admin.util.SecurityUtils;
import org.sagacity.sqltoy.dao.LightDao;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.sagacity.sqltoy.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author CoCoTea
 * @version 2.0.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private DefaultProp defaultProp;

    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private RedisService redisService;

    @Resource
    private SysLogService sysLogService;

    @Resource
    private SqlToyHelperDao sqlToyHelperDao;

    @Resource
    private SecurityUtils securityUtils;

    @Resource
    private SysRoleService sysRoleService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(SysUserAddDTO addDTO) {
        SysUser sysUser = sqlToyHelperDao.convertType(addDTO, SysUser.class);
        if (StringUtil.isNotBlank(addDTO.getPassword())) {
            sysUser.setPassword(securityUtils.getPwd(addDTO.getPassword()));
        } else {
            sysUser.setPassword(defaultProp.getPassword());
        }
        Object userId = sqlToyHelperDao.save(sysUser);

        // 授予用户角色
        if (!(addDTO.getRoleIds().isEmpty())) {
            for (BigInteger roleId : addDTO.getRoleIds()) {
                SysUserRole sysUserRole = new SysUserRole().setUserId(LoginUtils.parse(userId)).setRoleId(roleId);
                sqlToyHelperDao.save(sysUserRole);
            }
        }

        return userId != null;
    }

    @Override
    public boolean delete(BigInteger id) {
        // 假删除，用户关联的数据不必操作
        SysUser sysUser = new SysUser().setId(id).setIsDeleted(IsEnum.Y.getCode());
        return sqlToyHelperDao.update(sysUser) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(SysUserUpdateDTO updateDTO) {
        SysUser sysUser = Convert.convert(SysUser.class, updateDTO);
        if (!(updateDTO.getRoleIds() == null || updateDTO.getRoleIds().isEmpty())) {
            // 删除用户角色关联
            LambdaUpdateWrapper<SysUserRole> updateWrapper = new LambdaUpdateWrapper<>(SysUserRole.class)
                    .eq(SysUserRole::getUserId, updateDTO.getId());
            sqlToyHelperDao.delete(updateWrapper);
            // 添加用户角色关联
            for (BigInteger roleId : updateDTO.getRoleIds()) {
                SysUserRole sysUserRole = new SysUserRole().setUserId(updateDTO.getId()).setRoleId(roleId);
                sqlToyHelperDao.save(sysUserRole);
            }
        }
        // 更新密码
        if (StringUtil.isNotBlank(updateDTO.getPassword())) {
            sysUser.setPassword(securityUtils.getPwd(updateDTO.getPassword()));
        }
        Long flag = sqlToyHelperDao.update(sysUser);
        return flag > 0;
    }

    @Override
    public boolean deleteBatch(List<BigInteger> idList) {
        if (idList != null) {
            idList.forEach(this::delete);
        }
        return idList != null && !idList.isEmpty();
    }

    @Override
    public ApiPage<SysUserVO> listByPage(SysUserPageDTO param) {
        // 系统用户查询条件
        LambdaQueryWrapper<SysUser> userWrapper = Wrappers.lambdaWrapper(SysUser.class)
                .select()
                .like(SysUser::getNickname, param.getSysUser().getNickname())
                .like(SysUser::getUsername, param.getSysUser().getUsername())
                .eq(SysUser::getSex, param.getSysUser().getSex())
                .eq(SysUser::getMobilePhone, param.getSysUser().getMobilePhone())
                .eq(SysUser::getAccountStatus, param.getSysUser().getAccountStatus())
                .eq(SysUser::getIsDeleted, IsEnum.N.getCode())
                .orderByDesc(SysUser::getId);
        Page<SysUser> page = sqlToyHelperDao.findPage(userWrapper, new Page<>(param.getPageSize(), param.getPageNo()));
        List<SysUserVO> voList = new ArrayList<>(page.getRows().size());
        page.getRows().forEach(row -> {
            SysUserVO vo = Convert.convert(SysUserVO.class, row);
            vo.setRoleList(sysRoleService.loadByUserId(row.getId()));
            voList.add(vo);
        });
        return ApiPage.rest(page, voList);
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public String login(SysLoginDTO loginDTO, HttpServletRequest request) throws BusinessException {
        SysUser sysUser;
        // 强密码为空或者为none表示“启用”
        boolean strongPwdFlag =
                StrUtil.isBlank(defaultProp.getStrongPassword())
                        || !defaultProp.getStrongPassword().equals(loginDTO.getPassword())
                        || !"none".equals(loginDTO.getPassword());
        LambdaQueryWrapper<SysUser> userWrapper = new LambdaQueryWrapper<>(SysUser.class)
                .select(SysUser::getId).select(SysUser::getNickname).select(SysUser::getAvatar)
                .eq(SysUser::getUsername, loginDTO.getUsername())
                .eq(SysUser::getIsDeleted, IsEnum.N.getCode());
        // 验证码缓存键
        String key = null;
        if (strongPwdFlag) {
            // 校验验证码
            key = String.format(RedisKeyConst.VERIFY_CODE_LOGIN, loginDTO.getCaptchaId());
            String code = redisService.get(key);
            if (!loginDTO.getCaptcha().equals(code)) {
                throw new BusinessException("验证码错误");
            }
            // 校验密码
            String pwd = securityUtils.getPwd(loginDTO.getPassword());
            userWrapper.eq(SysUser::getPassword, pwd);
            sysUser = sqlToyHelperDao.findOne(userWrapper);
            if (sysUser == null) {
                throw new BusinessException("登录失败，用户名或密码错误");
            }
        } else {
            sysUser = sqlToyHelperDao.findOne(userWrapper);
        }
        // 记住我模式
        if (loginDTO.getRememberMe()) {
            StpUtil.login(sysUser.getId(), new SaLoginModel().setTimeout(3600 * 24 * 365));
        } else {
            StpUtil.login(sysUser.getId());
        }
        // 更新用户登录时间和ip
        SysUser loginSysUser = new SysUser();
        loginSysUser.setId(sysUser.getId());
        loginSysUser.setLastLoginIp(IpUtils.getIp(request));
        loginSysUser.setLastLoginTime(LocalDateTime.now());
        sqlToyLazyDao.update(loginSysUser);
        // 保存登录日志
        sysLogService.saveByLogType(LogTypeEnum.LOGIN.getCode(), request);
        // 删除缓存
        if (StrUtil.isNotBlank(key)) {
            redisService.delete(key);
        }
        return StpUtil.getTokenValue();
    }

    @Override
    public SysUserVO getDetail() {
        BigInteger loginId = LoginUtils.loginId();
        // 用户信息
        LambdaQueryWrapper<SysUser> userWrapper = new LambdaQueryWrapper<>(SysUser.class)
                .select()
                .eq(SysUser::getId, loginId)
                .eq(SysUser::getIsDeleted, IsEnum.N.getCode());
        SysUser sysUser = sqlToyHelperDao.findOne(userWrapper);
        SysUserVO sysUserVO = Convert.convert(SysUserVO.class, sysUser);
        return sysUserVO.setRoleList(sysRoleService.loadByUserId(loginId));
    }

    @Override
    public SysLoginUserVO loginUser() {
        BigInteger loginId = LoginUtils.loginIdEx();
        LambdaQueryWrapper<SysUser> userWrapper = new LambdaQueryWrapper<>(SysUser.class)
                .select(SysUser::getId).select(SysUser::getUsername).select(SysUser::getAvatar)
                .select(SysUser::getNickname)
                .eq(SysUser::getId, loginId)
                .eq(SysUser::getIsDeleted, IsEnum.N.getCode());
        SysUser sysUser = sqlToyHelperDao.findOne(userWrapper);
        SysLoginUserVO sysLoginUser = new SysLoginUserVO();
        // 用户菜单
        List<SysMenuVO> menuList = sysMenuService.listByUserId(IsEnum.Y.getCode());
        menuList = new TreeBuilder<SysMenuVO>().get(menuList);
        sysLoginUser.setMenuList(Convert.toList(SysMenuTreeVO.class, menuList));
        // 用户基本信息
        sysLoginUser
                .setUsername(sysUser.getUsername())
                .setNickname(sysUser.getNickname())
                .setAvatar(sysUser.getAvatar())
                .setId(sysUser.getId())
                .setLoginStatus(true)
                .setToken(StpUtil.getTokenValue());
        return sysLoginUser;
    }

    @Override
    public boolean updateByUser(SysLoginUserUpdateDTO param) {
        SysUser sysUser = Convert.convert(SysUser.class, param);
        sysUser.setId(LoginUtils.loginId());
        return sqlToyLazyDao.update(sysUser) > 0;
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
                .eq(SysUser::getIsDeleted, IsEnum.N.getCode());
        SysUser sysUser = sqlToyHelperDao.findOne(queryWrapper);

        String pwdOld = securityUtils.getPwd(oldPassword);
        if (!sysUser.getPassword().equals(pwdOld)) {
            throw new BusinessException("旧密码不正确");
        }
        String pwdNew = securityUtils.getPwd(newPassword);
        sysUser.setPassword(pwdNew);
        return sqlToyHelperDao.update(sysUser) > 0;
    }

    @Override
    public Map<BigInteger, SysUser> getMap(List<BigInteger> ids) {
        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.lambdaWrapper(SysUser.class)
                .in(SysUser::getId, ids);
        List<SysUser> list = sqlToyHelperDao.findList(queryWrapper);
        return list.stream().collect(Collectors.toMap(SysUser::getId, i -> i));
    }

    @Override
    public void doModifyAvatar(String avatarName) {
        BigInteger loginId = LoginUtils.loginId();
        SysUser sysUser = new SysUser().setId(loginId).setAvatar(avatarName);
        sqlToyHelperDao.update(sysUser);
    }
}
