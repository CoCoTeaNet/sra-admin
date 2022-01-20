package com.jwss.framework.service;

/**
 * @author jwss
 */
public interface RedisService {
    /**
     * 保存方法，时间为秒
     *
     * @param key k
     * @param value v
     * @param seconds 单位秒
     */
    void save(String key, String value, Long seconds);

    /**
     * 保存方法，时间为小时
     *
     * @param key k
     * @param value v
     * @param hours 单位小时
     */
    void saveByHours(String key, String value, int hours);

    /**
     * 保存方法，时效为永久
     *
     * @param key k
     * @param value v
     */
    void save(String key, String value);

    /**
     * 删除
     *
     * @param key k
     */
    void delete(String key);

    /**
     * 获取值
     *
     * @param key k
     * @return 值
     */
    String get(String key);
}
