package com.jwss.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.jwss.common.enums.DeleteStatusEnum;
import com.jwss.system.entity.Menu;
import com.jwss.system.param.menu.MenuAddParam;
import com.jwss.system.param.menu.MenuPageParam;
import com.jwss.system.param.menu.MenuUpdateParam;
import com.jwss.system.service.IMenuService;
import com.jwss.system.vo.MenuVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Page<MenuVO> page = sqlToyLazyDao.findPageBySql(pageParam, "system_menu_findByEntityParam", pageParam.getMenuVO());
        return page;
    }

    @Override
    public List<MenuVO> listByTree() {
        List<MenuVO> menuVOList = sqlToyLazyDao.findBySql("system_menu_findByEntityParam", new MenuVO());
        Map<String, MenuVO> menuRootMap = new HashMap<>(menuVOList.size() + 1);
        Map<String, MenuVO> menuChildMap = new HashMap<>(menuVOList.size() + 1);
        String root = String.valueOf(0);
        // 1.将根节点元素和子节点元素通过id映射分离
        menuVOList.forEach(item -> {
            if (root.equals(item.getParentId())) {
                menuRootMap.put(item.getId(), item);
            } else {
                menuChildMap.put(item.getId(), item);
            }
        });
        // 遍历子节点，通过映射id去给子节点分配父元素
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
        Map<String, Object> hashMap = new HashMap<>(1);
        hashMap.put("userId", StpUtil.getLoginId());
        List<MenuVO> menuVOList = sqlToyLazyDao.findBySql("system_menu_findUserPermission", hashMap, MenuVO.class);
        return menuVOList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(String id) {
        Menu menu = new Menu().setId(id).setDeleteStatus(DeleteStatusEnum.NOT_DELETE.getCode());
        Long update = sqlToyLazyDao.update(menu);
        if (update <= 0) {
            return false;
        }
        // 获取子节点
        HashMap<String, Object> paramsMap = new HashMap<>(Character.UPPERCASE_LETTER);
        paramsMap.put("parentId", id);
        List<Menu> menuList = sqlToyLazyDao.findBySql(
                "select id from sys_menu where #[PARENT_ID=:parentId] and DELETE_STATUS=1",
                paramsMap, Menu.class);
        if (menuList.size() > 0) {
            // 存在子节点，删除子节点
            menuList.forEach(item -> delete(item.getId()));
        }
        return true;
    }

}
