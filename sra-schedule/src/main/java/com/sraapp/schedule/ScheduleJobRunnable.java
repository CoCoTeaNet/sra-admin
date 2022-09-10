package com.sraapp.schedule;

import cn.dev33.satoken.stp.StpUtil;
import com.sraapp.common.model.BusinessException;
import com.sraapp.framework.service.IRedisService;
import com.sraapp.schedule.annotation.DisableConcurrentExecute;
import com.sraapp.schedule.entity.ScheduleJob;
import com.sraapp.schedule.param.ScheduleJobLogAddParam;
import com.sraapp.schedule.service.IScheduleJobLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2022-09-09 18:10:36
 */
public class ScheduleJobRunnable implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleJobRunnable.class);

    private final ScheduleJob scheduleJob;
    private boolean initialized = false;
    private boolean disabledConcurrentExecute = false;
    private Class<?> jobClass;
    private Object instance;
    private Method method;
    private transient String operator = "";
    private transient IScheduleJobLogService scheduleJobLogService;

    public ScheduleJobRunnable(IScheduleJobLogService scheduleJobLogService, ScheduleJob scheduleJob, String operator) throws Exception {
        this.operator = operator;
        this.scheduleJob = scheduleJob;
        this.scheduleJobLogService = scheduleJobLogService;
        this.doInitialize();
    }

    private void doInitialize() throws Exception {
        String className = scheduleJob.getClassName();
        jobClass = Class.forName(className);
        if (scheduleJob.getType() == 0) {
            // 类模式
            // 查看该任务类是否存在DisableConcurrentExecute注解
            Annotation[] declaredAnnotations = jobClass.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                if (declaredAnnotation instanceof DisableConcurrentExecute) {
                    disabledConcurrentExecute = true;
                    break;
                }
            }
            // 按照原有逻辑，将其优化成可以禁止并发执行，并且对该类进行缓存
            instance = jobClass.getDeclaredConstructor().newInstance();
        } else {
            // 函数模式
            String methodName = scheduleJob.getMethodName();
            List<Method> methods = new ArrayList<>();
            for (Method method : jobClass.getDeclaredMethods()) {
                if (method.getName().equals(methodName)) {
                    methods.add(method);
                }
            }
            Object instance = jobClass.newInstance();
            if (methods.size() == 0) {
                throw new BusinessException("函数不存在");
            } else if (methods.size() > 1) {
                // 后续改成按相应的参数查询方法
                throw new BusinessException("存在同名函数");
            } else {
                method = methods.get(0);
            }
        }
        this.initialized = true;
    }

    public ScheduleJob getScheduleJob() {
        return scheduleJob;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public boolean isDisabledConcurrentExecute() {
        return disabledConcurrentExecute;
    }

    @Override
    public void run() {
        int result = 1;
        Date triggerTime = new Date();
        String taskName = scheduleJob.getName();
        logger.info("开始执行计划任务: {}", taskName);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(taskName);
        try {
            if (!isInitialized()) {
                throw new BusinessException("任务执行异常，任务初始化失败...");
            }
            Integer type = scheduleJob.getType();
            if (type == 0 && instance instanceof IBaseJob) {
                IBaseJob job = (IBaseJob) instance;
                job.execute();
            } else if (type == 1) {
                method.invoke(instance);
            }
        } catch (Exception e) {
            result = 0;
            logger.error("计划任务执行出现异常! ", e);
        }
        stopWatch.stop();
        logger.info("计划任务: {} 执行耗时: {}ms", taskName, stopWatch.getLastTaskTimeMillis());
        try {
            ScheduleJobLogAddParam param = new ScheduleJobLogAddParam()
                    .setJobId(scheduleJob.getId())
                    .setExeResult(result)
                    .setTriggerBy(operator)
                    .setTriggerTime(triggerTime)
                    .setFinishTime(new Date())
                    .setSpendTimeMillis(stopWatch.getLastTaskTimeMillis());
            scheduleJobLogService.add(param);
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }
}
