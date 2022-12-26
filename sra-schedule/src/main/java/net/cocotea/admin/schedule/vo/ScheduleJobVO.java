
package net.cocotea.admin.schedule.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Guo wentao
 * @date 2022/8/29
 */
public class ScheduleJobVO implements Serializable {
    private static final long serialVersionUID = 1651150165407974544L;
    private String id;
    private String name;
    private String methodName;
    private String parameters;
    private Integer type;
    private String className;
    private String cornExpression;
    private String description;
    private Integer active;
    private Integer sort;
    private LocalDateTime nextExeTime;

    public String getId() {
        return id;
    }

    public ScheduleJobVO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ScheduleJobVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public ScheduleJobVO setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public String getParameters() {
        return parameters;
    }

    public ScheduleJobVO setParameters(String parameters) {
        this.parameters = parameters;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public ScheduleJobVO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public ScheduleJobVO setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getCornExpression() {
        return cornExpression;
    }

    public ScheduleJobVO setCornExpression(String cornExpression) {
        this.cornExpression = cornExpression;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ScheduleJobVO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getActive() {
        return active;
    }

    public ScheduleJobVO setActive(Integer active) {
        this.active = active;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public ScheduleJobVO setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public LocalDateTime getNextExeTime() {
        return nextExeTime;
    }

    public ScheduleJobVO setNextExeTime(LocalDateTime nextExeTime) {
        this.nextExeTime = nextExeTime;
        return this;
    }

    @Override
    public String toString() {
        return "ScheduleJobVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameters='" + parameters + '\'' +
                ", type=" + type +
                ", className='" + className + '\'' +
                ", cornExpression='" + cornExpression + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", sort=" + sort +
                ", nextExeTime=" + nextExeTime +
                '}';
    }
}