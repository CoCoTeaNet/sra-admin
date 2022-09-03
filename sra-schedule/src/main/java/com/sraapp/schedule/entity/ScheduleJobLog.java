package com.sraapp.schedule.entity;

import com.sraapp.schedule.param.ScheduleJobLogAddParam;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Guo wentao
 * @date 2022/9/1
 */
public class ScheduleJobLog implements Serializable {
    private String id;
    private String jobId;
    private String triggerBy;
    private Date triggerTime;
    private Date finishTime;
    private long spendTimeMillis;
    private Integer exeResult;

    private Integer deleteStatus;

    public String getId() {
        return id;
    }

    public ScheduleJobLog setId(String id) {
        this.id = id;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public ScheduleJobLog setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public ScheduleJobLog setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
        return this;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public ScheduleJobLog setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
        return this;
    }

    public Integer getExeResult() {
        return exeResult;
    }

    public ScheduleJobLog setExeResult(Integer exeResult) {
        this.exeResult = exeResult;
        return this;
    }

    public long getSpendTimeMillis() {
        return spendTimeMillis;
    }

    public ScheduleJobLog setSpendTimeMillis(long spendTimeMillis) {
        this.spendTimeMillis = spendTimeMillis;
        return this;
    }

    public String getTriggerBy() {
        return triggerBy;
    }

    public ScheduleJobLog setTriggerBy(String triggerBy) {
        this.triggerBy = triggerBy;
        return this;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public ScheduleJobLog setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder columnsBuffer = new StringBuilder();
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("jobId=").append(getJobId()).append("\n");
        columnsBuffer.append("triggerTime=").append(getTriggerTime()).append("\n");
        columnsBuffer.append("finishTime=").append(getFinishTime()).append("\n");
        columnsBuffer.append("triggerBy=").append(getTriggerBy()).append("\n");
        columnsBuffer.append("exeResult=").append(getExeResult()).append("\n");
        columnsBuffer.append("spendTimeMillis=").append(getSpendTimeMillis()).append("\n");
        columnsBuffer.append("deleteStatus=").append(getDeleteStatus()).append("\n");
        return columnsBuffer.toString();
    }
}
