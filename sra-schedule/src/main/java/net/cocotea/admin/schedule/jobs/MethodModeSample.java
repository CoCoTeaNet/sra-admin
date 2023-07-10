package net.cocotea.admin.schedule.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2022-09-14 15:20:07
 */
public class MethodModeSample {

    private final Logger logger = LoggerFactory.getLogger(MethodModeSample.class);

    public void run(TsParam param, Map<String, Object> secParam) {
        logger.info("任务入参, {}, {}", param, secParam);
        logger.info("任务执行,time={}", System.currentTimeMillis());
    }

    public static class TsParam {
        private String number;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "TsParam{" +
                    "number='" + number + '\'' +
                    '}';
        }
    }
}
