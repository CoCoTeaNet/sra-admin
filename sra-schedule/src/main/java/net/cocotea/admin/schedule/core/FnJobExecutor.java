package net.cocotea.admin.schedule.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.schedule.core.entity.ScheduleJob;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 函数模式执行器
 *
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2023-07-08 23:00:23
 */
public class FnJobExecutor extends JobExecutor {

    protected Object[] executeParameters;
    protected Method executeMethod;

    FnJobExecutor(ScheduleContext context) throws BusinessException {
        super(context);
    }

    @Override
    protected void doInitialize() throws BusinessException {
        ScheduleJob job = context.getJob();
        String parametersStr = job.getParameters();
        // 确定参数数量
        Object parametersObj = JSON.parse(parametersStr);
        int parametersCount = parametersObj instanceof JSONArray ? ((JSONArray) parametersObj).size() : 1;
        // 根据参数寻找对应的方法
        String methodName = job.getMethodName();
        Method[] declaredMethods = executorClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (!declaredMethod.getName().equals(methodName)) {
                continue;
            }
            Parameter[] parameters = declaredMethod.getParameters();
            if (parameters.length != parametersCount) {
                continue;
            }
            if (tryParseParameters(declaredMethod, parameters, parametersObj, parametersCount)) {
                executeMethod = declaredMethod;
                break;
            }
        }
        if (executeMethod == null) {
            throw new BusinessException("未在类[ " + executorClass.getName() + " ] 中找到方法: [" + methodName + "]");
        }
    }

    @Override
    protected void doExecute() throws InvocationTargetException, IllegalAccessException {
        executeMethod.invoke(instance, executeParameters);
    }

    private boolean tryParseParameters(Method declaredMethod, Parameter[] parameters, Object parametersObj, int parametersCount) {
        if (parametersCount == 1) {
            return tryParseSingleParameter(declaredMethod, parameters, parametersObj);
        }
        return tryParseMultipleParameters(declaredMethod, parameters, parametersObj);
    }

    private boolean tryParseMultipleParameters(Method declaredMethod, Parameter[] parameters, Object parametersObj) {
        JSONArray parametersJSONArr = (JSONArray) parametersObj;
        Object[] temp = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Class<?> type = parameter.getType();
            try {
                Object parameterJavaObj = parametersJSONArr.getObject(i, type);
                temp[i] = parameterJavaObj;
            } catch (Exception e) {
                return false;
            }
        }
        executeParameters = temp;
        return true;
    }

    private boolean tryParseSingleParameter(Method declaredMethod, Parameter[] parameters, Object parametersObj) {
        Parameter parameter = parameters[0];
        Class<?> type = parameter.getType();
        try {
            Object parameterJavaObj = JSON.toJavaObject((JSONObject) parametersObj, type);
            executeParameters = new Object[]{parameterJavaObj};
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
