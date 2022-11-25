package net.cocotea.bootstrap.aop;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import net.cocotea.bootstrap.properties.AopProperties;
import net.cocotea.common.model.ApiResult;
import net.cocotea.framework.service.IRedisService;
import net.cocotea.framework.util.IpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;

/**
 * 接口访问限制
 *
 * @author CoCoTea
 * @date 2022-9-9 17:25:21
 */
@Aspect
@Component
public class LimitFlowAspect {
    private final Logger logger = LoggerFactory.getLogger(LimitFlowAspect.class);

    @Resource
    private AopProperties aopProperties;
    @Resource
    private IRedisService redisService;

    @Pointcut("execution(public * net.cocotea.*.controller.*.*(..))")
    public void requestAspect() {
    }

    @Around(value = "requestAspect()")
    public Object methodBefore(ProceedingJoinPoint pjp) throws Throwable {
        boolean b = apiLimitAccessTimes();
        if (b) {
            return pjp.proceed();
        } else {
            return ApiResult.error("操作过于频繁");
        }
    }

    /**
     * 接口访问限制：1秒内运行访问N次
     */
    private boolean apiLimitAccessTimes() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            if (StpUtil.isLogin()) {
                String ip = IpUtils.getIp(requestAttributes.getRequest());
                String redisKey = ip + ":" + StpUtil.getLoginId();
                String value = redisService.get(redisKey);
                if (StrUtil.isBlank(value)) {
                    redisService.save(redisKey, String.valueOf(1), 1L);
                    return true;
                } if (Integer.parseInt(value) <= aopProperties.getVisits()) {
                    int count = Integer.parseInt(value);
                    count++;
                    redisService.set(redisKey, String.valueOf(count));
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
