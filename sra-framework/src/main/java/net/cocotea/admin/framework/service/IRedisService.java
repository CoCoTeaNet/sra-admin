package net.cocotea.admin.framework.service;

import java.util.Set;

/**
 * @author jwss
 */
public interface IRedisService {
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
     * 保存方法，时间为分钟
     *
     * @param key k
     * @param value v
     * @param minutes 单位分钟
     */
    void saveByMinutes(String key, String value, int minutes);

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
     * 修改值
     * @param key k
     * @param value v
     */
    void set(String key, String value);

    /**
     * 获取值
     *
     * @param key k
     * @return 值
     */
    String get(String key);

    /**
     * 哈希
     * @param key 集合key
     * @param hashKey 元素key
     * @param value 元素值
     */
    void hashPut(String key, String hashKey, String value);

    /**
     * 匹配键
     * @param pattern 正则表达式
     * @return 键集合
     */
    Set<String> keys(String pattern);
}
