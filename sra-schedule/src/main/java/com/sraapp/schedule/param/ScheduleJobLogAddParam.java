package com.sraapp.schedule.param;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Guo wentao
 * @date 2022/8/29
 */
public class ScheduleJobLogAddParam implements Serializable {

    private String jobId;
    private String triggerBy;
    private Date triggerTime;
    private Date finishTime;
    private long spendTimeMillis;
    private Integer exeResult;


    public String getJobId() {
        return jobId;
    }

    public ScheduleJobLogAddParam setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public ScheduleJobLogAddParam setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
        return this;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public ScheduleJobLogAddParam setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
        return this;
    }

    public Integer getExeResult() {
        return exeResult;
    }

    public ScheduleJobLogAddParam setExeResult(Integer exeResult) {
        this.exeResult = exeResult;
        return this;
    }

    public long getSpendTimeMillis() {
        return spendTimeMillis;
    }

    public ScheduleJobLogAddParam setSpendTimeMillis(long spendTimeMillis) {
        this.spendTimeMillis = spendTimeMillis;
        return this;
    }

    public String getTriggerBy() {
        return triggerBy;
    }

    public ScheduleJobLogAddParam setTriggerBy(String triggerBy) {
        this.triggerBy = triggerBy;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder columnsBuffer = new StringBuilder();
        columnsBuffer.append("jobId=").append(getJobId()).append("\n");
        columnsBuffer.append("triggerTime=").append(getTriggerTime()).append("\n");
        columnsBuffer.append("finishTime=").append(getFinishTime()).append("\n");
        columnsBuffer.append("triggerBy=").append(getTriggerBy()).append("\n");
        columnsBuffer.append("exeResult=").append(getExeResult()).append("\n");
        columnsBuffer.append("spendTimeMillis=").append(getSpendTimeMillis()).append("\n");
        return columnsBuffer.toString();
    }
}
