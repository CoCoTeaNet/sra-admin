package net.cocotea.admin.schedule.param;

import java.io.Serializable;

/**
 * CoCoTea
 * @date 2022-9-2 20:49:35
 */
public class ScheduleJobUpdateParam implements Serializable {
    private static final long serialVersionUID = 1857377900832759819L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 任务名称
     */
    private String name;

    private Integer type;
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

    private Integer sort;

    public String getId() {
        return id;
    }

    public ScheduleJobUpdateParam setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ScheduleJobUpdateParam setName(String name) {
        this.name = name;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public ScheduleJobUpdateParam setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public ScheduleJobUpdateParam setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public String getParameters() {
        return parameters;
    }

    public ScheduleJobUpdateParam setParameters(String parameters) {
        this.parameters = parameters;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCornExpression() {
        return cornExpression;
    }

    public ScheduleJobUpdateParam setCornExpression(String cornExpression) {
        this.cornExpression = cornExpression;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ScheduleJobUpdateParam setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getActive() {
        return active;
    }

    public ScheduleJobUpdateParam setActive(Integer active) {
        this.active = active;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public ScheduleJobUpdateParam setSort(Integer sort) {
        this.sort = sort;
        return this;
    }
}
