package com.jwss.sra.system.service.impl;

import com.jwss.sra.common.util.StringUtils;
import com.jwss.sra.framework.constant.RedisKey;
import com.jwss.sra.framework.service.IRedisService;
import com.jwss.sra.system.service.IDashboardService;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jwss
 */
@Service
public class DashboardServiceImpl implements IDashboardService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;
    @Resource
    private IRedisService IRedisService;

    @Override
    public List<Map<String, Object>> getCount() {
        Map<String, Object> hashMap;
        String tempSql = "select count(1) from %s where DELETE_STATUS=1";

        List<Map<String, Object>> mapList = new ArrayList<>(4);
        Long countUser = sqlToyLazyDao.getCount(String.format(tempSql, "sys_user"), null);
        hashMap=new HashMap<>(2);
        hashMap.put("title", "用户数量");
        hashMap.put("count", countUser);
        mapList.add(hashMap);
        Long countMenu = sqlToyLazyDao.getCount(String.format(tempSql, "sys_menu"), null);
        hashMap=new HashMap<>(2);
        hashMap.put("title", "菜单数量");
        hashMap.put("count", countMenu);
        mapList.add(hashMap);
        Long countRole = sqlToyLazyDao.getCount(String.format(tempSql, "sys_role"), null);
        hashMap=new HashMap<>(2);
        hashMap.put("title", "角色数量");
        hashMap.put("count", countRole);
        mapList.add(hashMap);
        Long countOnline = (long) IRedisService.keys(
                String.format(RedisKey.ONLINE_USER, StringUtils.ASTERISK)
        ).size();
        hashMap=new HashMap<>(2);
        hashMap.put("title", "在线用户");
        hashMap.put("count", countOnline);
        mapList.add(hashMap);
        return mapList;
    }
}
