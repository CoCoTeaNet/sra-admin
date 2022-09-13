package com.sraapp.schedule.jobs;

import com.sraapp.schedule.IBaseJob;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class ContentSpider implements IBaseJob {
    private final Logger logger = LoggerFactory.getLogger(ContentSpider.class);

    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public void execute(Map<String, Object> params) throws Exception {
        logger.info("任务执行,time={}", System.currentTimeMillis());
    }

    public void test() {
        logger.info("exec test.");
    }
}
