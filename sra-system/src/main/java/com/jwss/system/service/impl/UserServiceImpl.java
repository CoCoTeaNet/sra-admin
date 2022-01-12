package com.jwss.system.service.impl;

import com.jwss.system.service.IUserService;
import com.jwss.system.sqlmethod.UserServiceSqlMethod;
import com.jwss.system.vo.UserVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @date 2022-1-12 15:35:00
 * @author jwss
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public Page<UserVO> searchFruitOrder(Page pageModel, UserVO userVO) {
        Page<UserVO> pageBySql = sqlToyLazyDao.findPageBySql(pageModel, UserServiceSqlMethod.SYSTEM_SEARCH_FRUIT_ORDER, userVO);
        return pageBySql;
    }
}
