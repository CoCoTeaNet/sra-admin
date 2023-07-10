package net.cocotea.admin.schedule.jobs;

import net.cocotea.admin.schedule.core.IBaseJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2023-07-10 16:28:17
 */
public class ClzTypeJob implements IBaseJob {
    private final Logger logger = LoggerFactory.getLogger(ClzTypeJob.class);
    @Override
    public void execute(Map<String, Object> param) throws Exception {
        logger.info("任务入参, {}", param);
    }
}
