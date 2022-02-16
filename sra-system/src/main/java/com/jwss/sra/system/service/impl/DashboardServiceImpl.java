package com.jwss.sra.system.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.oshi.OshiUtil;
import com.jwss.sra.common.util.StringUtils;
import com.jwss.sra.framework.constant.GlobalValue;
import com.jwss.sra.framework.constant.RedisKey;
import com.jwss.sra.framework.service.IRedisService;
import com.jwss.sra.system.service.IDashboardService;
import com.jwss.sra.system.vo.SystemInfoVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.net.UnknownHostException;
import java.time.Duration;
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
    private IRedisService redisService;

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
        Long countOnline = (long) redisService.keys(
                String.format(RedisKey.ONLINE_USER, StringUtils.ASTERISK)
        ).size();
        hashMap=new HashMap<>(2);
        hashMap.put("title", "在线用户");
        hashMap.put("count", countOnline);
        mapList.add(hashMap);
        return mapList;
    }

    @Override
    public SystemInfoVO getSystemInfo() throws UnknownHostException {
        SystemInfoVO systemInfoVO = new SystemInfoVO();
        // 服务器信息
        systemInfoVO.setOs(SystemUtil.getOsInfo().getName());
        systemInfoVO.setServerName(SystemUtil.getHostInfo().getName());
        systemInfoVO.setServerIp(SystemUtil.getHostInfo().getAddress());
        systemInfoVO.setServerArchitecture(SystemUtil.getOsInfo().getArch());
        // java信息
        systemInfoVO.setJavaName(SystemUtil.getJvmInfo().getName());
        systemInfoVO.setJavaVersion(SystemUtil.getJavaInfo().getVersion());
        systemInfoVO.setJavaPath(SystemUtil.getJavaRuntimeInfo().getHomeDir());
        // 服务运行信息
        systemInfoVO.setProjectPath(System.getProperty("user.dir"));
        Duration between = LocalDateTimeUtil.between(
                LocalDateTimeUtil.ofUTC(GlobalValue.START_TIME),
                LocalDateTimeUtil.ofUTC(System.currentTimeMillis())
        );
        systemInfoVO.setRunningTime(between.getSeconds());
        // CPU信息
        systemInfoVO.setCpuSystemUsed(OshiUtil.getCpuInfo().getSys());
        systemInfoVO.setCpuUserUsed(OshiUtil.getCpuInfo().getUsed());
        systemInfoVO.setCpuFree(OshiUtil.getCpuInfo().getFree());
        systemInfoVO.setCpuCount(OshiUtil.getCpuInfo().getCpuNum());
        // 内存信息
        systemInfoVO.setMemoryTotalSize(OshiUtil.getMemory().getTotal());
        systemInfoVO.setMemoryAvailableSize(OshiUtil.getMemory().getAvailable());
        // 磁盘信息
        File file = new File(SystemUtil.get(SystemUtil.FILE_SEPARATOR));
        systemInfoVO.setDiskTotalSize(file.getTotalSpace());
        systemInfoVO.setDiskFreeSize(file.getFreeSpace());
        systemInfoVO.setDiskPath(SystemUtil.get(SystemUtil.FILE_SEPARATOR));
        systemInfoVO.setDiskSeparator(SystemUtil.get(SystemUtil.FILE_SEPARATOR));
        return systemInfoVO;
    }
}
