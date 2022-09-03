package com.sraapp.schedule.service;

import com.sraapp.schedule.entity.ScheduleJob;

import java.util.List;

/**
 * @author Guo wentao
 * @date 2022/9/1
 */
public interface IScheduleJobRegistryService {

    /**
     * 刷新全部计划任务，如果当前存在运行中计划任务，不强制中断
     *
     * @param scheduleJobList 刷新后的计划任务列表
     * @throws Exception 刷新任务注册表时出现的异常
     */
    void refreshAll(List<ScheduleJob> scheduleJobList) throws Exception;

    /**
     * 运行一次任务
     *
     * @param scheduleJob 计划任务信息
     * @return 是否执行成功
     * @throws Exception 准备任务时出现的异常
     */
    boolean start(ScheduleJob scheduleJob) throws Exception;

    /**
     * 刷新指定任务
     *
     * @param scheduleJob 计划任务信息
     * @return 是否执行成功
     * @throws Exception 刷新任务时出现的异常
     */
    boolean flushJob(ScheduleJob scheduleJob) throws Exception;
}
