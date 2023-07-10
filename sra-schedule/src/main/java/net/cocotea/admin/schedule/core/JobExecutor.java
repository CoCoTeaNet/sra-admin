package net.cocotea.admin.schedule.core;

import cn.hutool.core.util.ClassUtil;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.schedule.core.entity.ScheduleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2023-07-08 22:50:47
 */
public abstract class JobExecutor implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(JobExecutor.class);
    protected final ScheduleContext context;
    protected Object instance;
    private boolean initialized = false;
    protected boolean disabledConcurrentExecute = false;
    protected Class<?> executorClass;

    public static JobExecutor create(ScheduleContext context) throws BusinessException {
        ScheduleJob job = context.getJob();
        if (job.getType() == 1) {
            return new FnJobExecutor(context);
        }
        return new ClzJobExecutor(context);
    }

    public JobExecutor(ScheduleContext context) throws BusinessException {
        this.context = context;
        ScheduleJob job = context.getJob();
        String className = job.getClassName();
        if ((executorClass = ClassUtil.loadClass(className)) == null) {
            throw new BusinessException("无法扫描到类信息，请检查类: [" + className + "]是否存在...");
        }
        instance = context.getJobInstance(executorClass);
        disabledConcurrentExecute = job.getConcurrentExec() == 0;
        doInitialize();
        this.initialized = true;
    }

    @Override
    public void run() {
        try {
            if (!initialized) {
                throw new BusinessException("任务执行异常，任务初始化失败...");
            }
            context.start();
            doExecute();
            context.success();
        } catch (Exception e) {
            logger.error("计划任务执行出现异常! ", e);
            context.failure(e);
        }
    }

    public boolean isDisabledConcurrentExecute() {
        return disabledConcurrentExecute;
    }

    protected abstract void doInitialize() throws BusinessException;

    protected abstract void doExecute() throws Exception;

}
