package com.sraapp.framework.service.impl;

import com.sraapp.framework.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author jwss
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void save(String key, String value, Long seconds){
        stringRedisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    @Override
    public void saveByHours(String key, String value, int hours){
        stringRedisTemplate.opsForValue().set(key, value, hours, TimeUnit.HOURS);
    }

    @Override
    public void saveByMinutes(String key, String value, int minutes){
        stringRedisTemplate.opsForValue().set(key, value, minutes, TimeUnit.MINUTES);
    }

    @Override
    public void save(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, 0);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void hashPut(String key, String hashKey, String value) {
        stringRedisTemplate.opsForHash().put(key, hashKey, value);
    }

    @Override
    public Set<String> keys(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }
}
