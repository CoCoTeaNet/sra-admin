package com.jwss.sra.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.jwss.sra.common.enums.DeleteStatusEnum;
import com.jwss.sra.common.enums.IsSomethingEnum;
import com.jwss.sra.common.util.GenerateDsUtils;
import com.jwss.sra.common.util.StringUtils;
import com.jwss.sra.framework.constant.RedisKey;
import com.jwss.sra.framework.service.IRedisService;
import com.jwss.sra.system.param.menu.MenuUpdateParam;
import com.jwss.sra.system.entity.Menu;
import com.jwss.sra.system.param.menu.MenuAddParam;
import com.jwss.sra.system.param.menu.MenuPageParam;
import com.jwss.sra.system.service.IMenuService;
import com.jwss.sra.system.vo.MenuVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.sagacity.sqltoy.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author jwss
 */
@Service
public class MenuServiceImpl implements IMenuService {
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;
    @Resource
    private IRedisService redisService;

    @Override
    public boolean add(MenuAddParam param) {
        Menu menu = sqlToyLazyDao.convertType(param, Menu.class);
        if (StringUtil.isBlank(menu.getParentId())) {
            menu.setParentId(String.valueOf(0));
        }
        if (StringUtil.isBlank(menu.getPermissionCode()) && StringUtil.isNotBlank(menu.getRouterPath())) {
            menu.setPermissionCode(menu.getRouterPath().replace(StringUtils.LEFT_LINE, StringUtils.COLON));
        }
        Object menuId = sqlToyLazyDao.save(menu);
        return menuId != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) {
        idList.forEach(this::delete);
        return idList.size() > 0;
    }

    @Override
    public Page<MenuVO> listByPage(MenuPageParam pageParam) {
        Page<MenuVO> page = sqlToyLazyDao.findPageBySql(pageParam, "system_menu_findByPageParam", pageParam.getMenuVO());
        return page;
    }

    @Override
    public Page<MenuVO> listByTree(MenuPageParam pageParam) {
        Page<MenuVO> menuVoPage = sqlToyLazyDao.findPageBySql(pageParam, "system_menu_findByPageParam", pageParam.getMenuVO());
        List<MenuVO> menuVOList = menuVoPage.getRows();
        GenerateDsUtils<MenuVO> dsUtils = new GenerateDsUtils<>();
        Map<String, MenuVO> voMap = dsUtils.buildTreeDefault(menuVOList);
        menuVoPage.setRows(new ArrayList<>(voMap.values()));
        return menuVoPage;
    }

    @Override
    public boolean update(MenuUpdateParam param) {
        Menu menu = sqlToyLazyDao.convertType(param, Menu.class);
        Long update = sqlToyLazyDao.update(menu);
        return update > 0;
    }

    @Override
    public List<MenuVO> listByUserId(String isMenu) {
        Map<String, Object> hashMap = new HashMap<>(2);
        hashMap.put("userId", StpUtil.getLoginId());
        hashMap.put("isMenu", isMenu);
        List<MenuVO> menuVOList = sqlToyLazyDao.findBySql("system_menu_findUserPermission", hashMap, MenuVO.class);
        return menuVOList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(String id) {
        Menu menu = new Menu().setId(id).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
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

    @Override
    public List<MenuVO> listByRoleId(String roleId) {
        Map<String, Object> hashMap = new HashMap<>(1);
        hashMap.put("roleId", roleId);
        List<MenuVO> menuVOList = sqlToyLazyDao.findBySql("system_menu_findByCommonParam", hashMap, MenuVO.class);
        return menuVOList;
    }

    @Override
    public List<MenuVO> cachePermission(String userId) {
        // 缓存权限
        List<MenuVO> permissions = listByUserId(IsSomethingEnum.NO.getCode());
        redisService.save(String.format(RedisKey.USER_PERMISSION, userId), JSONUtil.toJsonStr(permissions), 3600 * 24L);
        return permissions;
    }

    @Override
    public List<MenuVO> getCachePermission(String userId) {
        String s = redisService.get(String.format(RedisKey.USER_PERMISSION, userId));
        logger.info("[{}]-permissions={}", userId, s);
        return JSONUtil.toList(s, MenuVO.class);
    }

}
