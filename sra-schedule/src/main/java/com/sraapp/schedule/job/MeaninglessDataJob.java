package com.sraapp.schedule.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MeaninglessDataJob implements SchedulingConfigurer {
    private final static Logger logger = LoggerFactory.getLogger(MeaninglessDataJob.class);
    private final static String DEFAULT_CORN = "5 * * * * ?";
    private String corn = DEFAULT_CORN;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(()->{
            logger.info("do something.");
        }, triggerContext -> {
            CronTrigger cronTrigger = new CronTrigger(corn);
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }

    public String getCorn() {
        return corn;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }
}
