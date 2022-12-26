package net.cocotea.admin.schedule;

import java.util.Map;

/**
 * @author Guo wentao
 * @date 2022/9/1
 */
public interface IBaseJob {

    /**
     * 计划任务执行方法
     *
     * @throws Exception 抛出的异常
     */
    void execute(Map<String, Object> param) throws Exception;

}
