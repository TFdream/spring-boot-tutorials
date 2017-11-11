package springboot.tutorials.mybatis.annotation.web;

import springboot.tutorials.mybatis.annotation.web.interceptor.FooInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Ricky Fung
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new FooInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/users/login", "/api/users/detail");
        super.addInterceptors(registry);
    }

}
