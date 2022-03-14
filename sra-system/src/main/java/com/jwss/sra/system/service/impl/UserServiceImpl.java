package com.jwss.sra.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.druid.util.StringUtils;
import com.jwss.sra.common.enums.AccountStatusEnum;
import com.jwss.sra.common.enums.DeleteStatusEnum;
import com.jwss.sra.common.enums.IsSomethingEnum;
import com.jwss.sra.common.enums.SexEnum;
import com.jwss.sra.common.model.BusinessException;
import com.jwss.sra.framework.constant.RedisKey;
import com.jwss.sra.framework.service.IRedisService;
import com.jwss.sra.framework.util.IpUtils;
import com.jwss.sra.system.param.menu.MenuPageParam;
import com.jwss.sra.system.param.role.RoleUpdateParam;
import com.jwss.sra.system.param.user.UserAddParam;
import com.jwss.sra.system.param.user.UserLoginParam;
import com.jwss.sra.system.entity.User;
import com.jwss.sra.system.entity.UserRole;
import com.jwss.sra.system.param.user.UserPageParam;
import com.jwss.sra.system.param.user.UserUpdateParam;
import com.jwss.sra.system.service.IMenuService;
import com.jwss.sra.system.service.IRoleService;
import com.jwss.sra.system.service.IUserService;
import com.jwss.sra.system.vo.LoginUserVO;
import com.jwss.sra.system.vo.MenuVO;
import com.jwss.sra.system.vo.UserVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.EntityQuery;
import org.sagacity.sqltoy.model.Page;
import org.sagacity.sqltoy.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author jwss
 * @date 2022-1-12 15:35:00
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;
    @Resource
    private IMenuService menuService;
    @Resource
    private IRoleService roleService;
    @Resource
    private IRedisService redisService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(UserAddParam param) {
        User user = sqlToyLazyDao.convertType(param, User.class);
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
        Long aLong = sqlToyLazyDao.update(user);
        // 更新用户角色
        if (!StringUtils.isEmpty(param.getRoleId())) {
            sqlToyLazyDao.deleteByQuery(UserRole.class, EntityQuery.create().where("USER_ID=:userId").names("userId").values(param.getId()));
            UserRole userRole = new UserRole().setUserId(param.getId()).setRoleId(param.getRoleId());
            sqlToyLazyDao.save(userRole);
        }
        return aLong > 0;
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
        // 校验验证码
        String code = redisService.get(String.format(RedisKey.VERIFY_CODE, "LOGIN", IpUtils.getIp(request)));
        if (!param.getVerifyCode().equals(code)) {
            throw new BusinessException("验证码错误");
        }
        // 校验密码
        User user = sqlToyLazyDao.convertType(param, User.class);
        user = sqlToyLazyDao.loadBySql("system_user_findByEntityParam", user);
        if (user == null) {
            throw new BusinessException("登录失败，用户名或密码错误");
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
        MenuPageParam pageParam = new MenuPageParam();
        pageParam.setPageSize(1000);
        MenuVO menuVO = new MenuVO();
        menuVO.setIsMenu(IsSomethingEnum.YSE.getCode());
        pageParam.setMenuVO(menuVO);
        loginUserVO.setMenuList(menuService.listByTree(pageParam).getRows());
        loginUserVO.setUsername(user.getUsername());
        loginUserVO.setAvatar(user.getAvatar());
        loginUserVO.setId(user.getId());
        loginUserVO.setLoginStatus(true);
        loginUserVO.setToken(StpUtil.getTokenValue());
        // TODO 缓存权限
        return loginUserVO;
    }

    @Override
    public UserVO getDetail() {
        UserVO userVO = new UserVO();
        userVO.setId(String.valueOf(StpUtil.getLoginId()));
        return sqlToyLazyDao.loadBySql("system_user_findByEntityParam", userVO);
    }
}
