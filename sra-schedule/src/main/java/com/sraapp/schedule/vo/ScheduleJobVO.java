package com.sraapp.schedule.vo;

import java.io.Serializable;

/**
 * @author Guo wentao
 * @date 2022/8/29
 */
public class ScheduleJobVO implements Serializable {

    private String id;
    private String name;
    private String className;
    private String cornExpression;
    private String description;
    private String active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCornExpression() {
        return cornExpression;
    }

    public void setCornExpression(String cornExpression) {
        this.cornExpression = cornExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }


    @Override
    public String toString() {
        StringBuilder columnsBuffer = new StringBuilder();
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("name=").append(getName()).append("\n");
        columnsBuffer.append("className=").append(getClassName()).append("\n");
        columnsBuffer.append("cornExpression=").append(getCornExpression()).append("\n");
        columnsBuffer.append("description=").append(getDescription()).append("\n");
        columnsBuffer.append("active=").append(getActive()).append("\n");
        return columnsBuffer.toString();
    }
}
