package com.jwss.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.jwss.common.enums.AccountStatusEnum;
import com.jwss.common.enums.SexEnum;
import com.jwss.common.model.BusinessException;
import com.jwss.system.entity.User;
import com.jwss.system.param.user.UserAddParam;
import com.jwss.system.param.user.UserLoginParam;
import com.jwss.system.service.IMenuService;
import com.jwss.system.service.IUserService;
import com.jwss.system.vo.LoginUserVO;
import com.jwss.system.vo.UserVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @date 2022-1-12 15:35:00
 * @author jwss
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Resource
    private IMenuService menuService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(UserAddParam param) {
        User user = sqlToyLazyDao.convertType(param, User.class);
        user.setNickname(String.format("SRA-%s", System.currentTimeMillis()))
                .setSex(SexEnum.MAN.getCode())
                .setAccountStatus(AccountStatusEnum.NORMAL.getCode());
        Object save = sqlToyLazyDao.save(user);
        // 授予用户角色
        return save != null;
    }

    @Override
    public LoginUserVO login(UserLoginParam param) throws BusinessException {
        User user = sqlToyLazyDao.convertType(param, User.class);
        user = sqlToyLazyDao.loadBySql("system_user_findByEntityParam", user);
        if (user == null) {
            throw new BusinessException("登录失败，用户名或密码错误");
        }
        // 默认记住我模式
        StpUtil.login(user.getId(), true);
        // 返回用户登录信息
        LoginUserVO loginUserVO = new LoginUserVO();
        loginUserVO.setLoginStatus(true);
        loginUserVO.setToken(StpUtil.getTokenValue());
        loginUserVO.setUserDetail(sqlToyLazyDao.convertType(user, UserVO.class));
        loginUserVO.setPermissions(menuService.listByUserId());
        return loginUserVO;
    }
}
