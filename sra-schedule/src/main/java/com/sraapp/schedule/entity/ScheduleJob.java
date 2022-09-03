package com.sraapp.schedule.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author CoCoTea
 * Table: sche_job,Remark:计划任务表
 */
@Entity(tableName = "sche_job")
public class ScheduleJob implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id(strategy = "generator", generator = "org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
    @Column(name = "ID", length = 32L, type = java.sql.Types.VARCHAR, nullable = false)
    private String id;

    /**
     * 任务名称
     */
    @Column(name = "NAME", length = 90L, type = java.sql.Types.VARCHAR, nullable = false)
    private String name;

    /**
     * 任务对应类名
     */
    @Column(name = "CLASS_NAME", length = 500L, type = java.sql.Types.VARCHAR, nullable = false)
    private String className;

    /**
     * Cron表达式
     */
    @Column(name = "CORN_EXPRESSION", length = 64L, type = java.sql.Types.VARCHAR, nullable = false)
    private String cornExpression;

    /**
     * 任务描述
     */
    @Column(name = "DESCRIPTION", length = 900L, type = java.sql.Types.VARCHAR)
    private String description;

    /**
     * 是否启用;0未启用 1启用
     */
    @Column(name = "ACTIVE", length = 1L, type = java.sql.Types.CHAR, nullable = false)
    private Integer active;

    /**
     * 删除状态;0删除 1未删除
     */
    @Column(name = "DELETE_STATUS", type = java.sql.Types.INTEGER, nullable = false)
    private Integer deleteStatus;

    /**
     * 乐观锁
     */
    @Column(name = "REVISION", type = java.sql.Types.INTEGER)
    private Integer revision;


    public String getId() {
        return this.id;
    }

    public ScheduleJob setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ScheduleJob setName(String name) {
        this.name = name;
        return this;
    }

    public String getClassName() {
        return this.className;
    }

    public ScheduleJob setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getCornExpression() {
        return this.cornExpression;
    }

    public ScheduleJob setCornExpression(String cornExpression) {
        this.cornExpression = cornExpression;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public ScheduleJob setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getActive() {
        return this.active;
    }

    public ScheduleJob setActive(Integer active) {
        this.active = active;
        return this;
    }

    public Integer getDeleteStatus() {
        return this.deleteStatus;
    }

    public ScheduleJob setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
        return this;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public ScheduleJob setRevision(Integer revision) {
        this.revision = revision;
        return this;
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
        columnsBuffer.append("deleteStatus=").append(getDeleteStatus()).append("\n");
        columnsBuffer.append("revision=").append(getRevision()).append("\n");
        return columnsBuffer.toString();
    }
}