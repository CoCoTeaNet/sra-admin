package com.jwss.system.service.impl;

import com.jwss.common.enums.DeleteStatusEnum;
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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
    public List<MenuVO> listByTree() {
        List<MenuVO> menuVOList = sqlToyLazyDao.findBySql(MenuSqlMethod.SYSTEM_FIND_USER_MENU, new MenuVO());
        Map<String, MenuVO> menuRootMap = new HashMap<>(menuVOList.size() + 1);
        Map<String, MenuVO> menuChildMap = new HashMap<>(menuVOList.size() + 1);
        String root = String.valueOf(0);
        menuVOList.forEach(item -> {
            if (root.equals(item.getParentId())) {
                menuRootMap.put(item.getId(), item);
            } else {
                menuChildMap.put(item.getId(), item);
            }
        });
        for (Map.Entry<String, MenuVO> item : menuChildMap.entrySet()) {
            MenuVO value = item.getValue();
            if (menuRootMap.get(value.getParentId()) != null) {
                List<MenuVO> children = menuRootMap.get(item.getValue().getParentId()).getChildren();
                if (children != null) {
                    children.add(value);
                } else {
                    ArrayList<MenuVO> list = new ArrayList<>();
                    list.add(value);
                    menuRootMap.get(value.getParentId()).setChildren(list);
                }
            } else if(menuChildMap.get(value.getParentId()) != null) {
                List<MenuVO> children = menuChildMap.get(value.getParentId()).getChildren();
                if (children != null) {
                    children.add(value);
                } else {
                    ArrayList<MenuVO> list = new ArrayList<>();
                    list.add(value);
                    menuChildMap.get(value.getParentId()).setChildren(list);
                }
            }
        }
        return new ArrayList<>(menuRootMap.values());
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

    @Override
    public boolean delete(String id) {
        Menu menu = new Menu().setId(id).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        Long update = sqlToyLazyDao.update(menu);
        return update > 0;
    }
}
