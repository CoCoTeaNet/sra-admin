package com.jwss.framework.service.impl;

import com.jwss.framework.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jwss
 */
@Service
public class RedisServiceImpl implements RedisService {
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
    public void save(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
