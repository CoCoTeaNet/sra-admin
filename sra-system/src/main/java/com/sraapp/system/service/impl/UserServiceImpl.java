package com.sraapp.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.druid.util.StringUtils;
import com.sraapp.common.enums.IsSomethingEnum;
import com.sraapp.common.model.BusinessException;
import com.sraapp.common.util.GenerateDsUtils;
import com.sraapp.common.util.SecurityUtils;
import com.sraapp.framework.constant.RedisKey;
import com.sraapp.framework.service.IRedisService;
import com.sraapp.framework.util.IpUtils;
import com.sraapp.system.entity.User;
import com.sraapp.system.entity.UserRole;
import com.sraapp.system.param.user.UserAddParam;
import com.sraapp.system.param.user.UserLoginParam;
import com.sraapp.system.param.user.UserPageParam;
import com.sraapp.system.param.user.UserUpdateParam;
import com.sraapp.system.properties.DefaultProperties;
import com.sraapp.system.properties.DevEnableProperties;
import com.sraapp.system.service.IMenuService;
import com.sraapp.system.service.IUserService;
import com.sraapp.system.vo.LoginUserVO;
import com.sraapp.system.vo.MenuVO;
import com.sraapp.system.vo.UserVO;
import com.sraapp.common.enums.DeleteStatusEnum;
import com.sraapp.common.enums.LogTypeEnum;
import com.sraapp.system.service.IOperationLogService;
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

/**
 * @author jwss
 * @date 2022-1-12 15:35:00
 */
@Service
public class UserServiceImpl implements IUserService {
    private final GenerateDsUtils<MenuVO> dsUtils = new GenerateDsUtils<>();

    @Resource
    private DevEnableProperties devEnableProperties;
    @Resource
    private DefaultProperties defaultProperties;
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;
    @Resource
    private IMenuService menuService;
    @Resource
    private IRedisService redisService;
    @Resource
    private IOperationLogService operationLogService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(UserAddParam param) {
        User user = sqlToyLazyDao.convertType(param, User.class);
        if (StringUtil.isNotBlank(param.getPassword())) {
            user.setPassword(SecurityUtils.buildMd5Pwd(param.getPassword(), defaultProperties.getSalt()));
        } else {
            user.setPassword(defaultProperties.getPassword());
        }
        Object userId = sqlToyLazyDao.save(user);
        // 授予用户角色
        UserRole userRole = new UserRole().setUserId((String) userId).setRoleId(param.getRoleId());
        Object roleId = sqlToyLazyDao.save(userRole);
        return userId != null && roleId != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(UserUpdateParam param) {
        User user = sqlToyLazyDao.convertType(param, User.class);
        // 更新用户角色
        if (!StringUtils.isEmpty(param.getRoleId())) {
            sqlToyLazyDao.deleteByQuery(UserRole.class, EntityQuery.create().where("USER_ID=:userId").names("userId").values(param.getId()));
            UserRole userRole = new UserRole().setUserId(param.getId()).setRoleId(param.getRoleId());
            sqlToyLazyDao.save(userRole);
        }
        // 更新密码
        if (StringUtil.isNotBlank(param.getPassword())) {
            user.setPassword(SecurityUtils.buildMd5Pwd(param.getPassword(), defaultProperties.getSalt()));
        }
        Long flag = sqlToyLazyDao.update(user);
        return flag > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(String id) {
        // 删除用户
        User user = new User().setId(id).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        Long aLong = sqlToyLazyDao.update(user);
        // 删除用户关联关系
        sqlToyLazyDao.deleteByQuery(UserRole.class, EntityQuery.create().where("USER_ID=:userId").names("userId").values(user.getId()));
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
    public Page<UserVO> listByPage(UserPageParam param) {
        Page<UserVO> page = sqlToyLazyDao.findPageBySql(param, "system_user_findByPageParam", param.getUserVO());
        return page;
    }

    @Override
    public LoginUserVO login(UserLoginParam param, HttpServletRequest request) throws BusinessException {
        User user;
        // 判断是否启用了强
        if (StringUtil.isBlank(devEnableProperties.getStrongPassword()) || !devEnableProperties.getStrongPassword().equals(param.getPassword())) {
            // 校验验证码
            String code = redisService.get(String.format(RedisKey.VERIFY_CODE, "LOGIN", IpUtils.getIp(request)));
            if (!param.getVerifyCode().equals(code)) {
                throw new BusinessException("验证码错误");
            }
            // 校验密码
            user = sqlToyLazyDao.convertType(param, User.class);
            user.setPassword(SecurityUtils.buildMd5Pwd(param.getPassword(), defaultProperties.getSalt()));
            user = sqlToyLazyDao.loadBySql("system_user_findByEntityParam", user);
            if (user == null) {
                throw new BusinessException("登录失败，用户名或密码错误");
            }
        } else {
            user = sqlToyLazyDao.loadBySql("system_user_findByEntityParam", new User().setUsername(param.getUsername()));
        }
        // 记住我模式
        StpUtil.login(user.getId(), param.getRememberMe());
        // 更新用户登录时间和ip
        User loginUser = new User();
        loginUser.setId(user.getId());
        loginUser.setLastLoginIp(IpUtils.getIp(request));
        loginUser.setLastLoginTime(LocalDateTime.now());
        sqlToyLazyDao.update(loginUser);
        // 返回用户登录信息
        LoginUserVO loginUserVO = new LoginUserVO();
        loginUserVO.setMenuList(new ArrayList<>(dsUtils.buildTreeDefault(menuService.listByUserId(IsSomethingEnum.YSE.getCode())).values()));
        loginUserVO.setUsername(user.getUsername());
        loginUserVO.setAvatar(user.getAvatar());
        loginUserVO.setId(user.getId());
        loginUserVO.setLoginStatus(true);
        loginUserVO.setToken(StpUtil.getTokenValue());
        // 缓存权限
        menuService.cachePermission(user.getId());
        // 保存登录日志
        operationLogService.saveByLogType(LogTypeEnum.LOGIN.getCode(), request);
        return loginUserVO;
    }

    @Override
    public UserVO getDetail() {
        UserVO userVO = new UserVO();
        userVO.setId(String.valueOf(StpUtil.getLoginId()));
        return sqlToyLazyDao.loadBySql("system_user_findByEntityParam", userVO);
    }
}
