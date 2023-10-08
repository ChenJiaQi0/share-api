package top.chen.share.user.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.chen.share.common.interceptor.LogInterceptor;

/**
 * Author:CJQ
 * Date:2023/10/8
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Resource
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
    }
}
