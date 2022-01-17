package com.jwss.system.service.impl;

import com.jwss.system.entity.Menu;
import com.jwss.system.param.menu.MenuAddParam;
import com.jwss.system.param.menu.MenuPageParam;
import com.jwss.system.param.menu.MenuUpdateParam;
import com.jwss.system.service.IMenuService;
import com.jwss.system.sqlmethod.MenuSqlMethod;
import com.jwss.system.vo.MenuVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.sagacity.sqltoy.model.QueryExecutor;
import org.sagacity.sqltoy.model.QueryResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jwss
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(MenuAddParam param) {
        Menu menu = sqlToyLazyDao.convertType(param, Menu.class);
        if (menu.getParentId() == null) {
            menu.setParentId(String.valueOf(0));
        }
        Object menuId = sqlToyLazyDao.save(menu);
        return menuId != null;
    }

    @Override
    public Page<MenuVO> listByPage(MenuPageParam pageParam) {
        Page<MenuVO> page = sqlToyLazyDao.findPageBySql(pageParam, MenuSqlMethod.SYSTEM_FIND_PAGE_MENU, pageParam.getMenuVO());
        return page;
    }

    @Override
    public boolean update(MenuUpdateParam param) {
        Menu menu = sqlToyLazyDao.convertType(param, Menu.class);
        Long update = sqlToyLazyDao.update(menu);
        return update > 0;
    }

    @Override
    public List<MenuVO> listByUserId() {
        QueryExecutor resultType = new QueryExecutor(MenuSqlMethod.SYSTEM_FIND_USER_MENU).resultType(MenuVO.class);
        return sqlToyLazyDao.findByQuery(resultType).getRows();
    }
}
