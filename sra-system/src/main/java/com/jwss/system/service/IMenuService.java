package com.jwss.system.service;

import com.jwss.system.param.menu.MenuAddParam;
import com.jwss.system.param.menu.MenuPageParam;
import com.jwss.system.vo.MenuVO;
import org.sagacity.sqltoy.model.Page;

/**
 * @date 2022-1-16 15:47:03
 * @author jwss
 */
public interface IMenuService {
    /**
     * 新增菜单
     * @param param 新增菜单参数
     * @return 成功返回TRUE
     */
    boolean add(MenuAddParam param);

    /**
     * 分页查询菜单
     * @param pageParam 分页参数
     * @return 分页结果集
     */
    Page<MenuVO> listByPage(MenuPageParam pageParam);
}
