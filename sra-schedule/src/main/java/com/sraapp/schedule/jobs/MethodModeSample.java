package com.sraapp.schedule.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2022-09-14 15:20:07
 */
public class MethodModeSample {

    private final Logger logger = LoggerFactory.getLogger(MethodModeSample.class);

    public void run(String param) {
        logger.info("任务入参, {}", param);
        logger.info("任务执行,time={}", System.currentTimeMillis());
    }

}
