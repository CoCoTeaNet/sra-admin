package net.cocotea.admin.schedule.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.schedule.param.ScheduleJobAddParam;
import net.cocotea.admin.schedule.param.ScheduleJobPageParam;
import net.cocotea.admin.schedule.vo.ScheduleJobVO;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.schedule.param.ScheduleJobUpdateParam;
import net.cocotea.admin.schedule.service.ScheduleJobService;
import org.sagacity.sqltoy.model.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/schedule/job")
@RestController
public class ScheduleJobController {
    @Resource
    private ScheduleJobService scheduleJobService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@RequestBody ScheduleJobAddParam param) throws BusinessException {
        boolean r = scheduleJobService.add(param);
        return ApiResult.ok(r);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<String> param) throws BusinessException {
        boolean r = scheduleJobService.deleteBatch(param);
        return ApiResult.ok(r);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@RequestBody ScheduleJobPageParam param) throws BusinessException {
        Page<ScheduleJobVO> r = scheduleJobService.listByPage(param);
        return ApiResult.ok(r);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@RequestBody ScheduleJobUpdateParam param) throws BusinessException {
        boolean r = scheduleJobService.update(param);
        return ApiResult.ok(r);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @GetMapping("/execute")
    public ApiResult<?> execute(String id) throws BusinessException {
        String uuid = scheduleJobService.execute(id);
        return ApiResult.ok(uuid);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @GetMapping("/progress")
    public ApiResult<?> progress(String id) throws BusinessException {
        boolean r = scheduleJobService.getExecuteProgress(id);
        return ApiResult.ok(r);
    }
}
