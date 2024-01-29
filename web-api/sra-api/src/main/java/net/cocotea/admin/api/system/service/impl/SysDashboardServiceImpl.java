package net.cocotea.admin.api.system.service.impl;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.text.CharPool;
import cn.hutool.system.HostInfo;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import com.sagframe.sagacity.sqltoy.plus.conditions.query.LambdaQueryWrapper;
import com.sagframe.sagacity.sqltoy.plus.dao.SqlToyHelperDao;
import net.cocotea.admin.api.system.model.po.SysMenu;
import net.cocotea.admin.api.system.model.po.SysRole;
import net.cocotea.admin.api.system.model.po.SysUser;
import net.cocotea.admin.api.system.model.vo.SysOverviewVO;
import net.cocotea.admin.api.system.model.vo.SystemInfoVO;
import net.cocotea.admin.api.system.service.SysDashboardService;
import net.cocotea.admin.common.constant.GlobalConst;
import net.cocotea.admin.common.constant.RedisKeyConst;
import net.cocotea.admin.common.enums.IsEnum;
import net.cocotea.admin.common.enums.MenuTypeEnum;
import net.cocotea.admin.common.service.RedisService;
import org.springframework.stereotype.Service;
import oshi.hardware.GlobalMemory;

import jakarta.annotation.Resource;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CoCoTea
 */
@Service
public class SysDashboardServiceImpl implements SysDashboardService {
    @Resource
    private SqlToyHelperDao sqlToyHelperDao;
    @Resource
    private RedisService redisService;

    @Override
    public List<SysOverviewVO> getCount() {
        List<SysOverviewVO> sysOverviewList = new ArrayList<>(4);
        LambdaQueryWrapper<SysUser> sysUserWrapper = new LambdaQueryWrapper<>(SysUser.class)
                .select().eq(SysUser::getIsDeleted, IsEnum.N.getCode());
        Long countUser = sqlToyHelperDao.count(sysUserWrapper);
        sysOverviewList.add(new SysOverviewVO().setTitle("用户数量").setCount(countUser));

        LambdaQueryWrapper<SysMenu> sysMenuWrapper = new LambdaQueryWrapper<>(SysMenu.class)
                .select()
                .eq(SysMenu::getIsDeleted, IsEnum.N.getCode())
                .eq(SysMenu::getIsMenu, IsEnum.Y.getCode())
                .eq(SysMenu::getMenuType, MenuTypeEnum.MENU.getCode());
        Long countMenu = sqlToyHelperDao.count(sysMenuWrapper);
        sysOverviewList.add(new SysOverviewVO().setTitle("菜单数量").setCount(countMenu));

        LambdaQueryWrapper<SysRole> sysRoleWrapper = new LambdaQueryWrapper<>(SysRole.class)
                .select().eq(SysRole::getIsDeleted, IsEnum.N.getCode());
        long countRole = sqlToyHelperDao.count(sysRoleWrapper);
        sysOverviewList.add(new SysOverviewVO().setTitle("角色数量").setCount(countRole));

        Long countOnline = (long) redisService.keys(
                String.format(RedisKeyConst.ONLINE_USER, "*")
        ).size();
        sysOverviewList.add(new SysOverviewVO().setTitle("在线用户").setCount(countOnline));
        return sysOverviewList;
    }

    @Override
    public SystemInfoVO getSystemInfo() {
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
                LocalDateTimeUtil.ofUTC(GlobalConst.START_TIME),
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
