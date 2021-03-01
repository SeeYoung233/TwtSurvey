package cn.twt.survey.app.config;

import cn.twt.survey.app.handler.Interceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Bean
    public Interceptor getInterceptor(){
        return new Interceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(getInterceptor());
        registration.addPathPatterns("/api/**");
        registration.excludePathPatterns("/api/user/login");
        registration.excludePathPatterns("/api/user/register");
        registration.excludePathPatterns("/api/hello");
        registration.excludePathPatterns("/api/record/addRecord");
        registration.excludePathPatterns("/api/question/getQuestionByPaper");
        registration.excludePathPatterns("/api/paper/getPaper");
    }
}
