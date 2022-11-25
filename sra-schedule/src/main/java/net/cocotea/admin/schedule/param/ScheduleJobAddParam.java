package net.cocotea.admin.schedule.param;

import java.io.Serializable;

/**
 * CoCoTea
 * @date 2022-9-2 20:46:46
 */
public class ScheduleJobAddParam implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务对应类名
     */
    private String className;

    private String methodName;

    private String parameters;

    /**
     * Cron表达式
     */
    private String cornExpression;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 是否启用;0未启用 1启用
     */
    private Integer active;
    private Integer type;

    private Integer sort;

    public Integer getType() {
        return type;
    }

    public ScheduleJobAddParam setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public ScheduleJobAddParam setName(String name) {
        this.name = name;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public ScheduleJobAddParam setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public ScheduleJobAddParam setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public String getParameters() {
        return parameters;
    }

    public ScheduleJobAddParam setParameters(String parameters) {
        this.parameters = parameters;
        return this;
    }

    public String getCornExpression() {
        return cornExpression;
    }

    public ScheduleJobAddParam setCornExpression(String cornExpression) {
        this.cornExpression = cornExpression;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ScheduleJobAddParam setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getActive() {
        return active;
    }

    public ScheduleJobAddParam setActive(Integer active) {
        this.active = active;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public ScheduleJobAddParam setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
}
