package edu.poly.duantotnghiep.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
//    @Autowired
//    private InterceptorUser interceptorUser;
//    @Autowired
//    private RequestInterceptor requestInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptorUser).addPathPatterns("/**").excludePathPatterns("/admin/**");
//        registry.addInterceptor(requestInterceptor).addPathPatterns("/**");
//    }
}
