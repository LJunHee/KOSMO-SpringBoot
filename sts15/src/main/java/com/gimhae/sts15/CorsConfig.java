package com.gimhae.sts15;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
	
	public FilterRegistrationBean filter() {
		FilterRegistrationBean bean=new FilterRegistrationBean<>(new LoginFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedMethods("OPTIONS","GET", "POST", "PUT", "DELETE")
            .allowedOrigins("http://localhost:3000")
            .allowCredentials(true);
    }
}
