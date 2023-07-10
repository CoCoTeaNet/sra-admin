package net.cocotea.admin.schedule.core;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.schedule.core.entity.ScheduleJob;

import java.util.Map;

/**
 * 类模式执行器
 *
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2023-07-08 23:00:01
 */
public class ClzJobExecutor extends JobExecutor {

    protected Map<String, Object> executeParameters;

    ClzJobExecutor(ScheduleContext context) throws BusinessException {
        super(context);
    }

    @Override
    protected void doInitialize() throws BusinessException {
        ScheduleJob job = context.getJob();
        String parameters = job.getParameters();
        if (StrUtil.isNotBlank(parameters)) {
            executeParameters = JSONObject.parseObject(parameters);
        }
        if (executeParameters == null) {
            executeParameters = MapUtil.empty();
        }
    }

    @Override
    protected void doExecute() throws Exception {
        if (instance instanceof IBaseJob) {
            ((IBaseJob) instance).execute(executeParameters);
        }
    }
}
