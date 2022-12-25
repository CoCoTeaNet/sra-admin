package net.cocotea.admin.schedule.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author Guo wentao
 * @date 2022/9/1
 */
@Entity(tableName="sche_job_log")
public class ScheduleJobLog implements Serializable {
    private static final long serialVersionUID = -421811360095497688L;
    /**
     * 主键ID
     */
    @Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
    @Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String id;

    /**
     * 任务ID
     */
    @Column(name="JOB_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String jobId;

    /**
     * 任务触发时间
     */
    @Column(name="TRIGGER_TIME",type=java.sql.Types.DATE)
    private LocalDateTime triggerTime;

    /**
     * 任务触发人
     */
    @Column(name="TRIGGER_BY",length=32L,type=java.sql.Types.VARCHAR)
    private String triggerBy;

    /**
     * 任务执行结果;0失败 1成功
     */
    @Column(name="EXE_RESULT",length=1L,type=java.sql.Types.CHAR)
    private Integer exeResult;

    /**
     * 任务执行耗时ms
     */
    @Column(name="SPEND_TIME_MILLIS",type=java.sql.Types.BIGINT)
    private Long spendTimeMillis;

    @Column(name="FINISH_TIME",type=java.sql.Types.DATE)
    private LocalDateTime finishTime;

    /**
     * 创建时间
     */
    @Column(name="CREATE_TIME",type=java.sql.Types.DATE)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Column(name="CREATE_BY",length=32L,type=java.sql.Types.VARCHAR)
    private String createBy;

    /**
     * 更新时间
     */
    @Column(name="UPDATE_TIME",type=java.sql.Types.DATE)
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @Column(name="UPDATE_BY",length=32L,type=java.sql.Types.VARCHAR)
    private String updateBy;

    /**
     * 删除状态;0删除 1未删除
     */
    @Column(name="DELETE_STATUS",length=1L,type=java.sql.Types.CHAR,nullable=false)
    private Integer deleteStatus;

    /**
     * 乐观锁
     */
    @Column(name="REVISION",type=java.sql.Types.INTEGER)
    private Integer revision;

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

    public LocalDateTime getTriggerTime() {
        return triggerTime;
    }

    public ScheduleJobLog setTriggerTime(LocalDateTime triggerTime) {
        this.triggerTime = triggerTime;
        return this;
    }

    public String getTriggerBy() {
        return triggerBy;
    }

    public ScheduleJobLog setTriggerBy(String triggerBy) {
        this.triggerBy = triggerBy;
        return this;
    }

    public Integer getExeResult() {
        return exeResult;
    }

    public ScheduleJobLog setExeResult(Integer exeResult) {
        this.exeResult = exeResult;
        return this;
    }

    public Long getSpendTimeMillis() {
        return spendTimeMillis;
    }

    public ScheduleJobLog setSpendTimeMillis(Long spendTimeMillis) {
        this.spendTimeMillis = spendTimeMillis;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ScheduleJobLog setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public ScheduleJobLog setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ScheduleJobLog setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public ScheduleJobLog setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public ScheduleJobLog setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
        return this;
    }

    public Integer getRevision() {
        return revision;
    }

    public ScheduleJobLog setRevision(Integer revision) {
        this.revision = revision;
        return this;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public ScheduleJobLog setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
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
        return columnsBuffer.toString();
    }
}
