package com.sraapp.schedule.param;

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
}
