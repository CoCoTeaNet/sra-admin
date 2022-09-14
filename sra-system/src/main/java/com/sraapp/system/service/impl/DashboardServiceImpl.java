package com.sraapp.system.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.system.HostInfo;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import com.sraapp.common.enums.IsSomethingEnum;
import com.sraapp.common.enums.MenuTypeEnum;
import com.sraapp.common.constant.CharConstant;
import com.sraapp.framework.constant.GlobalValue;
import com.sraapp.framework.constant.RedisKey;
import com.sraapp.framework.service.IRedisService;
import com.sraapp.system.service.IDashboardService;
import com.sraapp.system.vo.SystemInfoVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.springframework.stereotype.Service;
import oshi.hardware.GlobalMemory;

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
        String tempSql = "select count(1) from %s where DELETE_STATUS=1 ";

        List<Map<String, Object>> mapList = new ArrayList<>(4);
        Long countUser = sqlToyLazyDao.getCount(String.format(tempSql, "sys_user"), null);
        hashMap=new HashMap<>(2);
        hashMap.put("title", "用户数量");
        hashMap.put("count", countUser);
        mapList.add(hashMap);

        String menuSql = String.format(tempSql, "sys_menu") + "and IS_MENU = " + IsSomethingEnum.YSE.getCode();
        Long countMenu = sqlToyLazyDao.getCount(menuSql, null);
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
                String.format(RedisKey.ONLINE_USER, CharConstant.ASTERISK)
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
        OsInfo osInfo = SystemUtil.getOsInfo();
        HostInfo hostInfo = SystemUtil.getHostInfo();
        systemInfoVO.setOs(osInfo.getName());
        systemInfoVO.setServerName(hostInfo.getName());
        systemInfoVO.setServerIp(hostInfo.getAddress());
        systemInfoVO.setServerArchitecture(osInfo.getArch());
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
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
        systemInfoVO.setCpuSystemUsed(cpuInfo.getSys());
        systemInfoVO.setCpuUserUsed(cpuInfo.getUsed());
        systemInfoVO.setCpuCount(cpuInfo.getCpuNum());
        systemInfoVO.setCpuFree(cpuInfo.getFree());
        // 内存信息
        GlobalMemory memory = OshiUtil.getMemory();
        systemInfoVO.setMemoryAvailableSize(memory.getAvailable());
        systemInfoVO.setMemoryTotalSize(memory.getTotal());
        // 磁盘信息
        File file = new File(SystemUtil.get(SystemUtil.FILE_SEPARATOR));
        systemInfoVO.setDiskTotalSize(file.getTotalSpace());
        systemInfoVO.setDiskFreeSize(file.getFreeSpace());
        systemInfoVO.setDiskPath(SystemUtil.get(SystemUtil.FILE_SEPARATOR));
        systemInfoVO.setDiskSeparator(SystemUtil.get(SystemUtil.FILE_SEPARATOR));
        return systemInfoVO;
    }
}
