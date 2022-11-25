package net.cocotea.admin.schedule;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONValidator;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.schedule.annotation.DisableConcurrentExecute;
import net.cocotea.admin.schedule.entity.ScheduleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2022-09-09 18:10:36
 */
public class ScheduleJobRunnable implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleJobRunnable.class);
    private static final LocalVariableTableParameterNameDiscoverer DISCOVERER = new LocalVariableTableParameterNameDiscoverer();
    private final ScheduleJob scheduleJob;
    private boolean initialized = false;
    private boolean disabledConcurrentExecute = false;
    private Object instance;
    private Method method;
    private final ScheduleContext context;

    public ScheduleJobRunnable(ScheduleContext context, ScheduleJob scheduleJob) throws Exception {
        this.scheduleJob = scheduleJob;
        this.context = context;
        this.doInitialize();
    }

    private void doInitialize() throws Exception {
        String className = scheduleJob.getClassName();
        Class<?> jobClass = Class.forName(className);
        boolean functionMode = scheduleJob.getType() == 1;
        if (!functionMode) {
            // 类模式
            // 查看该任务类是否存在DisableConcurrentExecute注解
            Annotation[] declaredAnnotations = jobClass.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                if (declaredAnnotation instanceof DisableConcurrentExecute) {
                    disabledConcurrentExecute = true;
                    break;
                }
            }
        } else {
            // 函数模式
            String methodName = scheduleJob.getMethodName();
            List<Method> methods = new ArrayList<>();
            for (Method method : jobClass.getDeclaredMethods()) {
                if (method.getName().equals(methodName)) {
                    methods.add(method);
                }
            }
            if (methods.size() == 0) {
                throw new BusinessException("函数不存在");
            } else if (methods.size() > 1) {
                for (Method method : methods) {
                    int parameterCount = method.getParameterCount();
                    String parameters = scheduleJob.getParameters();
                    try (JSONValidator validator = JSONValidator.from(parameters)) {
                        JSONObject jsonObject = JSONObject.parseObject(parameters);
                        Set<String> keys = jsonObject.keySet();
                        if (keys.size() == parameterCount) {
                            String[] parameterNames = DISCOVERER.getParameterNames(method);
                            for (String parameterName : parameterNames) {
                                if (!keys.contains(parameterName)) {
                                    break;
                                }
                            }
                            this.method = method;
                            break;
                        }
                    }
                }
            } else {
                method = methods.get(0);
            }
        }
        instance = jobClass.getDeclaredConstructor().newInstance();
        this.initialized = !functionMode || this.method != null;
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
        context.start();
        try {
            if (!isInitialized()) {
                throw new BusinessException("任务执行异常，任务初始化失败...");
            }
            Integer type = scheduleJob.getType();
            String scheduleJobParameters = scheduleJob.getParameters();
            if (type == 0 && instance instanceof IBaseJob) {
                IBaseJob job = (IBaseJob) instance;
                Map<String, Object> param;
                if (StrUtil.isNotBlank(scheduleJobParameters)) {
                    param = JSON.parseObject(scheduleJobParameters);
                } else {
                    param = new HashMap<>();
                }
                job.execute(param);
            } else if (type == 1) {
                int parameterCount = method.getParameterCount();
                if (parameterCount > 0) {
                    reflectInvokeMethod(scheduleJobParameters);
                } else {
                    method.invoke(instance);
                }
            }
            context.success();
        } catch (Exception e) {
            logger.error("计划任务执行出现异常! ", e);
            context.failure(e);
        }
    }

    private void reflectInvokeMethod(String parametersString) throws InvocationTargetException, IllegalAccessException, IOException {
        Parameter[] parameters = method.getParameters();
        Object[] parameterObjects = new Object[parameters.length];
        try (JSONValidator jsonValidator = JSONValidator.from(parametersString)) {
            JSONObject jsonObject = JSON.parseObject(parametersString);
            if (parameters.length == 1) {
                Parameter theParam = parameters[0];
                Class<?> type = theParam.getType();
                if (Map.class == type) {
                    parameterObjects[0] = jsonObject;
                } else if (String.class == type) {
                    parameterObjects[0] = parametersString;
                } else {
                    parameterObjects[0] = JSON.parseObject(parametersString, type);
                }
            } else {
                String[] parameterNames = DISCOVERER.getParameterNames(method);
                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    Object object = jsonObject.getObject(parameterNames[i], parameter.getType());
                    parameterObjects[i] = object;
                }
            }
        }
        method.invoke(instance, parameterObjects);
    }
}
