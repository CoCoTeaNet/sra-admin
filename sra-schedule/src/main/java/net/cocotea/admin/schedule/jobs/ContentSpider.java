package net.cocotea.admin.schedule.jobs;

import com.alibaba.fastjson.JSONObject;
import net.cocotea.admin.schedule.IBaseJob;
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
        logger.info("任务入参, {}", params);
        logger.info("任务执行,time={}", System.currentTimeMillis());
    }

    public void test(JSONObject param) {
        logger.info("exec test.param={}", param);
        logger.info("sqlToyLazyDao inject = {}", sqlToyLazyDao);
    }
}
