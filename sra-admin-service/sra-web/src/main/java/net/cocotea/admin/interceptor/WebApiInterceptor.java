package net.cocotea.admin.interceptor;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.text.CharPool;
import cn.hutool.core.util.StrUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.cocotea.admin.api.system.service.SysLogService;
import net.cocotea.admin.common.constant.RedisKeyConst;
import net.cocotea.admin.common.enums.LogTypeEnum;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.service.RedisService;
import net.cocotea.admin.common.util.IpUtils;
import net.cocotea.admin.properties.DefaultProp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class WebApiInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(WebApiInterceptor.class);

    @Resource
    private RedisService redisService;

    @Resource
    private DefaultProp defaultProp;

    @Resource
    private SysLogService sysLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 接口访问限制
        boolean limitFlag = apiLimitAccessTimes();
        if (limitFlag) {
            throw new BusinessException("操作过快，请稍后再试！");
        }
        // 在线用户续期
        if (StpUtil.isLogin()) {
            if (StrUtil.isBlank(redisService.get(RedisKeyConst.ONLINE_USER))) {
                String loginId = String.valueOf(StpUtil.getLoginId());
                redisService.save(String.format(RedisKeyConst.ONLINE_USER, loginId), loginId, 30L);
            }
        }
        // 打印请求内容
        logger.info(
                "### 请求IP：{}，请求地址：{}，请求方式，{}，请求方法：{}",
                request.getRemoteAddr(),
                request.getRequestURL().toString(),
                request.getMethod(),
                request.getRequestURI()
        );
        // 保存登录日志与操作日志,如果没有登录不去保存
        if (StpUtil.isLogin()) {
            sysLogService.saveByLogType(LogTypeEnum.OPERATION.getCode(), request);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 接口访问限制：1秒内运行访问N次
     */
    private boolean apiLimitAccessTimes() {
        boolean flag = false;
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null && StpUtil.isLogin()) {
            String ip = IpUtils.getIp(requestAttributes.getRequest());
            String redisKey = ip + CharPool.COLON + StpUtil.getLoginId();
            String value = redisService.get(redisKey);
            if (StrUtil.isBlank(value)) {
                redisService.save(redisKey, String.valueOf(1), 1L);
            } else if (Integer.parseInt(value) <= defaultProp.getOnceVisits()) {
                int count = Integer.parseInt(value);
                count++;
                redisService.save(redisKey, String.valueOf(count), 1L);
            } else {
                flag = true;
            }
        }
        return flag;
    }

}
