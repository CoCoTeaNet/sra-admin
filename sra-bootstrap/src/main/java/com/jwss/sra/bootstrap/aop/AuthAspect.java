package com.jwss.sra.bootstrap.aop;

import cn.dev33.satoken.stp.StpUtil;
import com.jwss.sra.framework.constant.RedisKey;
import com.jwss.sra.framework.service.IRedisService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.sagacity.sqltoy.utils.StringUtil;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * 用户认证切面
 *
 * @author jwss
 * @date 2022-4-10 20:23:17
 */
@Aspect
@Component
public class AuthAspect {
    @Resource
    private IRedisService redisService;

    @Pointcut("execution(public * com.jwss.sra.*.controller.*.*(..))")
    public void requestAspect() {
    }

    @Before(value = "requestAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        onlineUsersRenewal();
    }

    /**
     * 在线用户续期
     */
    private void onlineUsersRenewal() {
        if (StpUtil.isLogin()) {
            if (StringUtil.isBlank(redisService.get(RedisKey.ONLINE_USER))) {
                String loginId = String.valueOf(StpUtil.getLoginId());
                redisService.save(String.format(RedisKey.ONLINE_USER, loginId), loginId, 30L);
            }
        }
    }
}
