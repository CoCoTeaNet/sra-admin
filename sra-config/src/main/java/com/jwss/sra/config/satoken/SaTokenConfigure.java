package com.jwss.sra.config.satoken;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.jwss.sra.config.properties.SatokenProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jwss
 * @date 2022-1-17 16:12:05
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer{
    private final Logger logger = LoggerFactory.getLogger(SaTokenConfigure.class);

    @Resource
    private SatokenProperties satokenProperties;

    /**
     * 注册 [Sa-Token全局过滤器]
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        SaServletFilter saServletFilter = new SaServletFilter()
            // 指定 拦截路由
            .addInclude("/**")
            // 认证函数: 每次请求执行
            .setAuth(obj -> {
                logger.info("---------- 进入Sa-Token全局认证 -----------");
                // 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
                SaRouter.match("/**", "/user/doLogin", StpUtil::checkLogin);
            })
            // 异常处理函数：每次认证函数发生异常时执行此函数
            .setError(e -> {
                logger.error("---------- 进入Sa-Token异常处理 -----------");
                return e.getMessage();
            })
            // 前置函数：在每次认证函数之前执行
            .setBeforeAuth(r -> {
                // ---------- 设置一些安全响应头 ----------
                SaHolder.getResponse()
                        // 服务器名称
                        .setServer("sra-server")
                        // 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
                        .setHeader("X-Frame-Options", "SAMEORIGIN")
                        // 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
                        .setHeader("X-XSS-Protection", "1; mode=block")
                        // 禁用浏览器内容嗅探
                        .setHeader("X-Content-Type-Options", "nosniff");
            });
        // 放行路由
        getExcludeList().forEach(saServletFilter::addExclude);
        return saServletFilter;
    }

    /**
     * 获取放行路由列表
     * @return 路由集合
     */
    public List<String> getExcludeList() {
        List<String> excludes = satokenProperties.getExcludes();
        logger.info("############# 放行 ##############");
        if (excludes != null) {
            excludes.forEach(logger::info);
        }
        logger.info("############# 路由 ##############");
        return excludes;
    }

    /**
     * 注册Sa-Token的注解拦截器，打开注解式鉴权功能
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
    }
}
